package swust.qiy.microservice.management.service.impl;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swust.qiy.microservice.core.constant.StatusConstant;
import swust.qiy.microservice.core.enums.ResultCodeEnum;
import swust.qiy.microservice.core.result.Result;
import swust.qiy.microservice.core.result.ResultUtil;
import swust.qiy.microservice.core.service.impl.BaseServiceImpl;
import swust.qiy.microservice.core.util.CommonUtil;
import swust.qiy.microservice.management.dao.MicroserviceDao;
import swust.qiy.microservice.management.entity.Microservice;
import swust.qiy.microservice.management.entity.MicroserviceVersion;
import swust.qiy.microservice.management.service.MicroserviceVersionService;

/**
 * @author qiying
 */
@Service
public class MicroserviceVersionServiceImpl extends BaseServiceImpl<MicroserviceVersion>
  implements MicroserviceVersionService {

  @Autowired
  private MicroserviceDao microserviceDao;

  @Override
  public Result save(MicroserviceVersion model) {
    if (CommonUtil.isEmpty(model.getMicroserviceId())) {
      return ResultUtil.create(ResultCodeEnum.PARAM_ERROR, "微服务Id不能为空");
    }
    Microservice microservice = microserviceDao.selectById(model.getMicroserviceId());
    if (CommonUtil.isEmpty(microservice)) {
      return ResultUtil.create(ResultCodeEnum.PARAM_ERROR, "应用Id错误");
    }
    if (CommonUtil.isEmpty(model.getVersion())) {
      ResultUtil.create(ResultCodeEnum.PARAM_ERROR, "微服务版本不能为空");
    }
    model.setCreateTime(LocalDateTime.now());
    model.setOnlineStatus(StatusConstant.PENDING_STARTED);
    return super.save(model);
  }
}
