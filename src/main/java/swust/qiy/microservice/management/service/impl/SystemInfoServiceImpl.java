package swust.qiy.microservice.management.service.impl;

import java.time.LocalDateTime;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import swust.qiy.microservice.core.enums.ResultCodeEnum;
import swust.qiy.microservice.core.result.Result;
import swust.qiy.microservice.core.result.ResultAsset;
import swust.qiy.microservice.core.service.impl.BaseServiceImpl;
import swust.qiy.microservice.management.dao.ApplicationDao;
import swust.qiy.microservice.management.dao.GatewayDao;
import swust.qiy.microservice.management.dao.SystemInfoDao;
import swust.qiy.microservice.management.entity.SystemInfo;
import swust.qiy.microservice.management.query.ApplicationQuery;
import swust.qiy.microservice.management.query.GatewayQuery;
import swust.qiy.microservice.management.query.SystemInfoQuery;
import swust.qiy.microservice.management.service.SystemInfoService;

/**
 * @author qiying
 */
@Service
public class SystemInfoServiceImpl extends BaseServiceImpl<SystemInfo>
  implements SystemInfoService {

  @Resource
  private SystemInfoDao systemInfoDao;
  @Resource
  private ApplicationDao applicationDao;
  @Resource
  private GatewayDao gatewayDao;


  @Override
  public Result save(SystemInfo model) {
    ResultAsset.notEmpty(model.getCode(), ResultCodeEnum.PARAM_ERROR, "系统编码不能为空");
    ResultAsset.notEmpty(model.getName(), ResultCodeEnum.PARAM_ERROR, "系统名称不能为空");
    SystemInfoQuery query = new SystemInfoQuery();
    query.setCode(model.getCode());
    ResultAsset.isTrue(systemInfoDao.selectCount(query.toQueryWrapper()) == 0,
      ResultCodeEnum.PARAM_ERROR, "已存在系统编码，请修改");
    model.setCreateTime(LocalDateTime.now());
    return super.save(model);
  }

  @Override
  public Result<Integer> update(SystemInfo model) {
    ResultAsset.notNull(model.getId(), ResultCodeEnum.PARAM_ERROR, "系统Id不能为空");
    ResultAsset.notEmpty(model.getName(), ResultCodeEnum.PARAM_ERROR, "系统名称不能为空");
    SystemInfo systemInfo = systemInfoDao.selectById(model.getId());
    ResultAsset.notNull(systemInfo, ResultCodeEnum.RECORD_NOT_EXIST, "系统Id错误");
    systemInfo.setName(model.getName());
    systemInfo.setDescription(model.getDescription());
    return super.update(model);
  }

  @Override
  public Result<Integer> deleteById(int id) {
    ApplicationQuery query = new ApplicationQuery();
    query.setSystemId(id);
    Integer count = applicationDao.selectCount(query.toQueryWrapper());
    ResultAsset.isTrue(count == 0, ResultCodeEnum.INVALID_OPERATION, "无法删除！请先删除该系统下的应用！");
    GatewayQuery gquery = new GatewayQuery();
    gquery.setSystemId(id);
    Integer count1 = gatewayDao.selectCount(gquery.toQueryWrapper());
    ResultAsset.isTrue(count1 == 0, ResultCodeEnum.INVALID_OPERATION, "无法删除！请先删除该系统下的网关！");
    return super.deleteById(id);
  }
}
