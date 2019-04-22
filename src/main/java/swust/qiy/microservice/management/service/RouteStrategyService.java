package swust.qiy.microservice.management.service;

import java.util.List;
import swust.qiy.microservice.core.result.Result;
import swust.qiy.microservice.core.service.BaseService;
import swust.qiy.microservice.management.entity.RouteStrategy;

/**
 * @author qiying
 */
public interface RouteStrategyService extends BaseService<RouteStrategy> {

  Result save(Integer routeId, List<Integer> strategyIds, Byte type);

}
