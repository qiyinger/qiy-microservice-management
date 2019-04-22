package swust.qiy.microservice.management.service.impl;

import java.time.LocalDateTime;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swust.qiy.microservice.core.enums.ResultCodeEnum;
import swust.qiy.microservice.core.result.Result;
import swust.qiy.microservice.core.result.ResultUtil;
import swust.qiy.microservice.core.service.impl.BaseServiceImpl;
import swust.qiy.microservice.management.dao.ApplicationDao;
import swust.qiy.microservice.management.dao.MicroserviceDao;
import swust.qiy.microservice.management.entity.Application;
import swust.qiy.microservice.management.entity.Microservice;
import swust.qiy.microservice.management.entity.MicroserviceVersion;
import swust.qiy.microservice.management.service.MicroserviceService;
import swust.qiy.microservice.management.service.MicroserviceVersionService;

/**
 * @author qiying
 */
@Service
public class MicroserviceServiceImpl extends BaseServiceImpl<Microservice>
  implements MicroserviceService {

  @Autowired
  private ApplicationDao applicationDao;
  @Autowired
  private MicroserviceDao microserviceDao;
  @Autowired
  private MicroserviceVersionService microserviceVersionService;

  @Override
  public Result save(Microservice model, MicroserviceVersion version) {
    Application application = applicationDao.selectById(model.getAppId());
    if (null == application) {
      return ResultUtil.create(ResultCodeEnum.PARAM_ERROR, "应用Id错误");
    }
    model.setSystemId(application.getSystemId());
    model.setAllCode(application.getAllCode() + "-" + model.getCode());
    model.setCreateTime(LocalDateTime.now());
    int serviceId = microserviceDao.insert(model);
    if (StringUtils.isBlank(version.getVersion())) {
      return ResultUtil.create(ResultCodeEnum.PARAM_ERROR, "版本号不能为空");
    }
    version.setMicroserviceId(serviceId);
    version.setCreateTime(LocalDateTime.now());
    return microserviceVersionService.save(version);
  }

  @Override
  public Result update(Microservice model) {
    Microservice microservice = microserviceDao.selectById(model.getId());
    if (null == microservice) {
      return ResultUtil.create(ResultCodeEnum.PARAM_ERROR, "微服务Id错误");
    }
    // 如果修改了code, 检查重复并更新allCode
    if (!microservice.getCode().equals(model.getCode())) {
      Application application = applicationDao.selectById(microservice.getAppId());
      if (null == application) {
        return ResultUtil.create(ResultCodeEnum.RECORD_NOT_EXIST, "应用不存在");
      }
      String allCode = application.getAllCode() + model.getCode();
      int count = microserviceDao.countByAllCode(allCode);
      if (count != 0) {
        return ResultUtil.create(ResultCodeEnum.RECORD_EXIST, "应用下已存在code, 请修改code");
      }
      microservice.setAllCode(allCode);
    }
    BeanUtils.copyProperties(model, microservice);
    return super.save(microservice);
  }

}
