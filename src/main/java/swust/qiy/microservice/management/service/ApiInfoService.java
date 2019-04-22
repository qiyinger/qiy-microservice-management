package swust.qiy.microservice.management.service;

import swust.qiy.microservice.core.result.Result;
import swust.qiy.microservice.core.service.BaseService;
import swust.qiy.microservice.management.entity.ApiInfo;

/**
 * @author qiying
 */
public interface ApiInfoService extends BaseService<ApiInfo> {

  Result<Integer> importApi(String url, Integer serviceVersionId);

  Result online(Integer id);

  Result offline(Integer id);

}
