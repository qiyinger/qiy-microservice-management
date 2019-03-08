package swust.qiy.microservice.management.service.impl;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swust.qiy.microservice.core.enums.ResultCodeEnum;
import swust.qiy.microservice.core.result.Result;
import swust.qiy.microservice.core.result.ResultUtil;
import swust.qiy.microservice.core.service.impl.BaseServiceImpl;
import swust.qiy.microservice.core.util.CommonUtil;
import swust.qiy.microservice.management.dao.ApplicationDao;
import swust.qiy.microservice.management.entity.Application;
import swust.qiy.microservice.management.entity.Microservice;
import swust.qiy.microservice.management.service.MicroserviceService;

/**
 * @author qiying
 */
@Service
public class MicroserviceServiceImpl extends BaseServiceImpl<Microservice>
  implements MicroserviceService {

  @Autowired
  private ApplicationDao applicationDao;

  @Override
  public Result save(Microservice model) {
    if (CommonUtil.isEmpty(model.getAppId())) {
      return ResultUtil.create(ResultCodeEnum.PARAM_ERROR, "应用Id不能为空");
    }
    Application application = applicationDao.selectById(model.getAppId());
    if (CommonUtil.isEmpty(application)) {
      return ResultUtil.create(ResultCodeEnum.PARAM_ERROR, "应用Id错误");
    }
    if (CommonUtil.isEmpty(model.getCode())) {
      ResultUtil.create(ResultCodeEnum.PARAM_ERROR, "微服务编号不能为空");
    }
    model.setCode(application.getCode() + "-" + model.getCode());
    model.setCreateTime(LocalDateTime.now());
    return super.save(model);
  }
}
