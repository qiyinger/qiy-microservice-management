package swust.qiy.microservice.management.service;

import swust.qiy.microservice.core.result.Result;
import swust.qiy.microservice.core.service.BaseService;
import swust.qiy.microservice.management.entity.MicroserviceVersion;

/**
 * @author qiying
 */
public interface MicroserviceVersionService extends BaseService<MicroserviceVersion> {

  Result online(Integer versionId);

  Result offline(Integer versionId);

  Result publish(Integer versionId);

  Result unpublish(Integer versionId);

}
