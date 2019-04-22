package swust.qiy.microservice.management.service;

import swust.qiy.microservice.core.result.Result;
import swust.qiy.microservice.core.service.BaseService;
import swust.qiy.microservice.management.entity.Gateway;

/**
 * @author qiying
 */
public interface GatewayService extends BaseService<Gateway> {

  Result enable(Integer gatewayId);

  Result stop(Integer getewayId);

}
