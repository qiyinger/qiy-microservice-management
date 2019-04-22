package swust.qiy.microservice.management.service;

import swust.qiy.microservice.core.result.Result;
import swust.qiy.microservice.core.service.BaseService;
import swust.qiy.microservice.management.entity.Route;

/**
 * @author qiying
 */
public interface RouteService extends BaseService<Route> {

  Result<Integer> save(Route model, boolean isPublish);

  Result publish(Integer id);

  Result stop(Integer id);

  /**
   * 重新加载所有路由
   */
  Result reload(Integer getewayId);

  Result update(Route route, boolean isPublish);

}
