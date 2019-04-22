package swust.qiy.microservice.management.service.impl;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swust.qiy.microservice.core.constant.StatusConstant;
import swust.qiy.microservice.core.enums.ResultCodeEnum;
import swust.qiy.microservice.core.result.Result;
import swust.qiy.microservice.core.result.ResultUtil;
import swust.qiy.microservice.core.service.impl.BaseServiceImpl;
import swust.qiy.microservice.management.dao.MicroserviceDao;
import swust.qiy.microservice.management.dao.MicroserviceVersionDao;
import swust.qiy.microservice.management.entity.Microservice;
import swust.qiy.microservice.management.entity.MicroserviceVersion;
import swust.qiy.microservice.management.query.MicroserviceVersionQuery;
import swust.qiy.microservice.management.service.MicroserviceVersionService;

/**
 * @author qiying
 */
@Service
public class MicroserviceVersionServiceImpl extends BaseServiceImpl<MicroserviceVersion>
  implements MicroserviceVersionService {

  @Autowired
  private MicroserviceDao microserviceDao;
  @Autowired
  private MicroserviceVersionDao microserviceVersionDao;

  @Override
  public Result save(MicroserviceVersion model) {
    Microservice microservice = microserviceDao.selectById(model.getMicroserviceId());
    if (microservice == null) {
      return ResultUtil.create(ResultCodeEnum.PARAM_ERROR, "微服务Id错误");
    }
    model.setCreateTime(LocalDateTime.now());
    model.setOnlineStatus(StatusConstant.PENDING_STARTED);
    return super.save(model);
  }

  @Override
  public Result update(MicroserviceVersion model) {
    MicroserviceVersion microserviceVersion = microserviceVersionDao.selectById(model.getId());
    if (microserviceVersion == null) {
      return ResultUtil.create(ResultCodeEnum.RECORD_NOT_EXIST);
    }
    if (!microserviceVersion.getVersion().equals(model.getVersion())) {
      MicroserviceVersionQuery query = new MicroserviceVersionQuery();
      query.setVersion(model.getVersion());
      query.setMicroserviceId(microserviceVersion.getMicroserviceId());
      int count = microserviceVersionDao.selectCount(query.toQueryWrapper());
      if (count > 0) {
        return ResultUtil.create(ResultCodeEnum.RECORD_EXIST, "版本号已存在");
      }
      microserviceVersion.setVersion(model.getVersion());
    }
    microserviceVersion.setDescription(model.getDescription());
    microserviceVersion.setNumOfInst(model.getNumOfInst());
    return super.update(microserviceVersion);
  }

  @Override
  public Result online(Integer versionId) {
    MicroserviceVersion microserviceVersion = microserviceVersionDao.selectById(versionId);
    if (StatusConstant.PENDING_STARTED != microserviceVersion.getOnlineStatus()) {
      return ResultUtil.create(ResultCodeEnum.INVALID_OPERATION);
    }
    microserviceVersion.setOnlineStatus(StatusConstant.STARTED);
    return super.update(microserviceVersion);
  }

  @Override
  public Result offline(Integer versionId) {
    MicroserviceVersion microserviceVersion = microserviceVersionDao.selectById(versionId);
    if (StatusConstant.STARTED != microserviceVersion.getOnlineStatus()) {
      return ResultUtil.create(ResultCodeEnum.INVALID_OPERATION);
    }
    microserviceVersion.setOnlineStatus(StatusConstant.PENDING_STARTED);
    return super.update(microserviceVersion);
  }
}
