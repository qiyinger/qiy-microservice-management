package swust.qiy.microservice.management.query;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.List;
import lombok.Data;
import swust.qiy.microservice.core.query.BaseQuery;
import swust.qiy.microservice.core.util.CommonUtil;
import swust.qiy.microservice.management.entity.RouteStrategyCall;

/**
 * @author qiying
 */
@Data
public class RouteStrategyCallQuery extends BaseQuery<RouteStrategyCall> {

  private Integer id;
  private List<Integer> ids;
  private Integer routeId;
  private List<Integer> routeIds;
  private Integer strategyCallId;
  private List<Integer> strategyCallIds;

  @Override
  public QueryWrapper<RouteStrategyCall> toQueryWrapper() {
    QueryWrapper<RouteStrategyCall> queryWrapper = new QueryWrapper<>();
      if (!CommonUtil.isEmpty(id)) {
      queryWrapper.eq("id", id);
      }
      if (!CommonUtil.isEmpty(ids)) {
      queryWrapper.in("id", ids);
      }
      if (!CommonUtil.isEmpty(routeId)) {
      queryWrapper.eq("route_id", routeId);
      }
      if (!CommonUtil.isEmpty(routeIds)) {
      queryWrapper.in("route_id", routeIds);
      }
      if (!CommonUtil.isEmpty(strategyCallId)) {
      queryWrapper.eq("strategy_call_id", strategyCallId);
      }
      if (!CommonUtil.isEmpty(strategyCallIds)) {
      queryWrapper.in("strategy_call_id", strategyCallIds);
      }
    return queryWrapper;
  }
}