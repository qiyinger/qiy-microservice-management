package swust.qiy.microservice.management.service.impl;

import java.time.LocalDateTime;
import org.springframework.stereotype.Service;
import swust.qiy.microservice.core.constant.StatusConstant;
import swust.qiy.microservice.core.result.Result;
import swust.qiy.microservice.core.service.impl.BaseServiceImpl;
import swust.qiy.microservice.management.entity.SystemInfo;
import swust.qiy.microservice.management.service.SystemInfoService;

/**
 * @author qiying
 */
@Service
public class SystemInfoServiceImpl extends BaseServiceImpl<SystemInfo>
  implements SystemInfoService {

  @Override
  public Result save(SystemInfo model) {
    model.setCreateTime(LocalDateTime.now());
    model.setStatus(StatusConstant.DISABLE);
    return super.save(model);
  }
}
