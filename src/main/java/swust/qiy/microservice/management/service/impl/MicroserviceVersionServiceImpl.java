package swust.qiy.microservice.management.service.impl;

import java.time.LocalDateTime;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import swust.qiy.microservice.core.enums.ResultCodeEnum;
import swust.qiy.microservice.core.result.Result;
import swust.qiy.microservice.core.result.ResultAsset;
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

  @Resource
  private MicroserviceDao microserviceDao;
  @Resource
  private MicroserviceVersionDao microserviceVersionDao;

  @Override
  public Result save(MicroserviceVersion model) {
    ResultAsset.notEmpty(model.getVersion(), ResultCodeEnum.PARAM_ERROR, "微服务版本不能为空");
    ResultAsset.notNull(model.getMicroserviceId(), ResultCodeEnum.PARAM_ERROR, "微服务Id不能为空");

    Microservice microservice = microserviceDao.selectById(model.getMicroserviceId());
    ResultAsset.notNull(microservice, ResultCodeEnum.PARAM_ERROR, "微服务Id错误");

    MicroserviceVersionQuery query = new MicroserviceVersionQuery();
    query.setMicroserviceId(model.getMicroserviceId());
    query.setVersion(model.getVersion());
    Integer count = microserviceVersionDao.selectCount(query.toQueryWrapper());
    ResultAsset.isTrue(count == 0, ResultCodeEnum.RECORD_EXIST, "微服务版本已存在");

    model.setCreateTime(LocalDateTime.now());
    model.setOnline(false);
    model.setPublish(false);
    return super.save(model);
  }

  @Override
  public Result update(MicroserviceVersion model) {
    ResultAsset.notEmpty(model.getVersion(), ResultCodeEnum.PARAM_ERROR, "微服务版本不能为空");
    MicroserviceVersion microserviceVersion = microserviceVersionDao.selectById(model.getId());
    ResultAsset.isNull(microserviceVersion, ResultCodeEnum.RECORD_NOT_EXIST, "微服务Id错误");

    if (!microserviceVersion.getVersion().equals(model.getVersion())) {
      MicroserviceVersionQuery query = new MicroserviceVersionQuery();
      query.setVersion(model.getVersion());
      query.setMicroserviceId(microserviceVersion.getMicroserviceId());
      int count = microserviceVersionDao.selectCount(query.toQueryWrapper());
      ResultAsset.isTrue(count == 0, ResultCodeEnum.RECORD_EXIST, "版本号已存在");
      microserviceVersion.setVersion(model.getVersion());
    }
    microserviceVersion.setDescription(model.getDescription());
    return super.update(microserviceVersion);
  }

  @Override
  public Result online(Integer versionId) {
    MicroserviceVersion version = microserviceVersionDao.selectById(versionId);
    ResultAsset.notNull(version, ResultCodeEnum.PARAM_ERROR, "微服务版本Id错误");
    ResultAsset.isTrue(version.getOnline(), ResultCodeEnum.INVALID_OPERATION);
    version.setOnline(true);
    return super.update(version);
  }

  @Override
  public Result offline(Integer versionId) {
    MicroserviceVersion version = microserviceVersionDao.selectById(versionId);
    ResultAsset.notNull(version, ResultCodeEnum.PARAM_ERROR, "微服务版本Id错误");
    ResultAsset.isTrue(!version.getOnline(), ResultCodeEnum.INVALID_OPERATION);
    version.setOnline(false);
    return super.update(version);
  }

  @Override
  public Result publish(Integer versionId) {
    MicroserviceVersion version = microserviceVersionDao.selectById(versionId);
    ResultAsset.notNull(version, ResultCodeEnum.PARAM_ERROR, "微服务版本Id错误");
    ResultAsset.isTrue(version.getPublish(), ResultCodeEnum.INVALID_OPERATION, "服务已发布");
    version.setPublish(true);
    return super.update(version);
  }

  @Override
  public Result unpublish(Integer versionId) {
    MicroserviceVersion version = microserviceVersionDao.selectById(versionId);
    ResultAsset.notNull(version, ResultCodeEnum.PARAM_ERROR, "微服务版本Id错误");
    ResultAsset.isTrue(!version.getPublish(), ResultCodeEnum.INVALID_OPERATION, "服务已发布");
    version.setPublish(false);
    return super.update(version);
  }

}
