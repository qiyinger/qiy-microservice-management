package swust.qiy.microservice.management.service.impl;

import java.time.LocalDateTime;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swust.qiy.microservice.core.enums.ResultCodeEnum;
import swust.qiy.microservice.core.result.Result;
import swust.qiy.microservice.core.result.ResultAsset;
import swust.qiy.microservice.core.result.ResultUtil;
import swust.qiy.microservice.core.service.impl.BaseServiceImpl;
import swust.qiy.microservice.management.dao.ApplicationDao;
import swust.qiy.microservice.management.dao.MicroserviceDao;
import swust.qiy.microservice.management.dao.MicroserviceVersionDao;
import swust.qiy.microservice.management.entity.Application;
import swust.qiy.microservice.management.entity.Microservice;
import swust.qiy.microservice.management.entity.MicroserviceVersion;
import swust.qiy.microservice.management.query.MicroserviceQuery;
import swust.qiy.microservice.management.query.MicroserviceVersionQuery;
import swust.qiy.microservice.management.service.MicroserviceService;
import swust.qiy.microservice.management.service.MicroserviceVersionService;

/**
 * @author qiying
 */
@Service
public class MicroserviceServiceImpl extends BaseServiceImpl<Microservice>
  implements MicroserviceService {

  @Resource
  private ApplicationDao applicationDao;
  @Resource
  private MicroserviceDao microserviceDao;
  @Resource
  private MicroserviceVersionDao microserviceVersionDao;
  @Autowired
  private MicroserviceVersionService microserviceVersionService;

  @Override
  public Result save(Microservice model, MicroserviceVersion version) {
    ResultAsset.notEmpty(model.getCode(), ResultCodeEnum.PARAM_ERROR, "微服务编码不能为空");
    ResultAsset.notEmpty(model.getName(), ResultCodeEnum.PARAM_ERROR, "微服务名称不能为空");
    ResultAsset.notNull(model.getAppId(), ResultCodeEnum.PARAM_ERROR, "所属应用不能为空");
    MicroserviceQuery query = new MicroserviceQuery();
    query.setCode(model.getCode());
    Integer count = microserviceDao.selectCount(query.toQueryWrapper());
    ResultAsset.isTrue(count == 0, ResultCodeEnum.RECORD_EXIST, "微服务编码已存在");
    Application application = applicationDao.selectById(model.getAppId());
    ResultAsset.notNull(application, ResultCodeEnum.PARAM_ERROR, "应用Id错误");
    model.setSystemId(application.getSystemId());
    model.setCreateTime(LocalDateTime.now());
    microserviceDao.insert(model);
    version.setMicroserviceId(model.getId());
    version.setCreateTime(LocalDateTime.now());
    return microserviceVersionService.save(version);
  }

  @Override
  public Result update(Microservice model) {
    ResultAsset.notNull(model.getId(), ResultCodeEnum.PARAM_ERROR, "微服务Id不能为空");
    ResultAsset.notEmpty(model.getName(), ResultCodeEnum.PARAM_ERROR, "微服务名称不能为空");
    Microservice microservice = microserviceDao.selectById(model.getId());
    ResultAsset.notNull(microservice, ResultCodeEnum.PARAM_ERROR, "微服务Id错误");
    microservice.setName(model.getName());
    return super.save(microservice);
  }

  @Override
  public Result<Integer> deleteById(int id) {
    MicroserviceVersionQuery query = new MicroserviceVersionQuery();
    query.setMicroserviceId(id);
    Integer count = microserviceVersionDao.selectCount(query.toQueryWrapper());
    ResultAsset.isTrue(count == 0, ResultCodeEnum.INVALID_OPERATION, "无法删除！请删除微服务下的所有版本");
    return super.deleteById(id);
  }
}
