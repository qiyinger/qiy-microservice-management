package swust.qiy.microservice.management.service;

import swust.qiy.microservice.core.result.Result;
import swust.qiy.microservice.core.service.BaseService;
import swust.qiy.microservice.management.entity.ApiApply;

/**
 * @author qiying
 */
public interface ApiApplyService extends BaseService<ApiApply> {

  Result pass(Integer id);

  Result refuse(Integer id);

}
