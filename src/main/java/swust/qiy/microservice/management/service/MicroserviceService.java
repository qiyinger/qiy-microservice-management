package swust.qiy.microservice.management.service;

import swust.qiy.microservice.core.result.Result;
import swust.qiy.microservice.core.service.BaseService;
import swust.qiy.microservice.management.entity.Microservice;
import swust.qiy.microservice.management.entity.MicroserviceVersion;

/**
 * @author qiying
 */
public interface MicroserviceService extends BaseService<Microservice> {

  Result save(Microservice model, MicroserviceVersion version);
}
