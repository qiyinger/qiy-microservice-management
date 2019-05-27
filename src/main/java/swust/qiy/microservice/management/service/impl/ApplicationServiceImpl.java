package swust.qiy.microservice.management.service.impl;

import java.time.LocalDateTime;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import swust.qiy.microservice.core.enums.ResultCodeEnum;
import swust.qiy.microservice.core.result.Result;
import swust.qiy.microservice.core.result.ResultAsset;
import swust.qiy.microservice.core.service.impl.BaseServiceImpl;
import swust.qiy.microservice.management.dao.ApplicationDao;
import swust.qiy.microservice.management.dao.MicroserviceDao;
import swust.qiy.microservice.management.dao.SystemInfoDao;
import swust.qiy.microservice.management.entity.Application;
import swust.qiy.microservice.management.entity.SystemInfo;
import swust.qiy.microservice.management.query.ApplicationQuery;
import swust.qiy.microservice.management.query.MicroserviceQuery;
import swust.qiy.microservice.management.service.ApplicationService;

/**
 * @author qiying
 */
@Service
public class ApplicationServiceImpl extends BaseServiceImpl<Application>
  implements ApplicationService {

  @Resource
  private SystemInfoDao systemInfoDao;
  @Resource
  private ApplicationDao applicationDao;
  @Resource
  private MicroserviceDao microserviceDao;

  @Override
  public Result save(Application model) {
    ResultAsset.notNull(model.getSystemId(), ResultCodeEnum.PARAM_ERROR, "系统Id不能为空");
    SystemInfo systemInfo = systemInfoDao.selectById(model.getSystemId());
    ResultAsset.notNull(systemInfo, ResultCodeEnum.PARAM_ERROR, "系统Id错误");
    ResultAsset.notEmpty(model.getCode(), ResultCodeEnum.PARAM_ERROR, "应用编号不能为空");
    ApplicationQuery query = new ApplicationQuery();
    query.setCode(model.getCode());
    query.setSystemId(model.getSystemId());
    Integer count = applicationDao.selectCount(query.toQueryWrapper());
    ResultAsset.isTrue(count == 0, ResultCodeEnum.RECORD_EXIST, "系统下已存该编码");
    model.setCreateTime(LocalDateTime.now());
    return super.save(model);
  }

  @Override
  public Result<Integer> update(Application model) {
    ResultAsset.notNull(model.getId(), ResultCodeEnum.PARAM_ERROR, "应用Id不能为空");
    ResultAsset.notEmpty(model.getName(), ResultCodeEnum.PARAM_ERROR, "应用名称不能为空");
    Application application = applicationDao.selectById(model.getId());
    ResultAsset.notNull(application, ResultCodeEnum.RECORD_NOT_EXIST, "应用Id错误");
    application.setName(model.getName());
    application.setDescription(model.getDescription());
    return super.update(model);
  }

  @Override
  public Result<Integer> deleteById(int id) {
    MicroserviceQuery query = new MicroserviceQuery();
    query.setAppId(id);
    Integer count = microserviceDao.selectCount(query.toQueryWrapper());
    ResultAsset.isTrue(count == 0, ResultCodeEnum.INVALID_OPERATION, "无法删除！请先删除该应用下的微服务");
    return super.deleteById(id);
  }
}
