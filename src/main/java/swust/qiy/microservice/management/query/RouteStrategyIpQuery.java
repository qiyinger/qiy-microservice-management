package swust.qiy.microservice.management.query;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.List;
import lombok.Data;
import swust.qiy.microservice.core.query.BaseQuery;
import swust.qiy.microservice.core.util.CommonUtil;
import swust.qiy.microservice.management.entity.RouteStrategyIp;

/**
 * @author qiying
 */
@Data
public class RouteStrategyIpQuery extends BaseQuery<RouteStrategyIp> {

  private Integer id;
  private List<Integer> ids;
  private Integer routeId;
  private List<Integer> routeIds;
  private Integer strategyIpId;
  private List<Integer> strategyIpIds;

  @Override
  public QueryWrapper<RouteStrategyIp> toQueryWrapper() {
    QueryWrapper<RouteStrategyIp> queryWrapper = new QueryWrapper<>();
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
      if (!CommonUtil.isEmpty(strategyIpId)) {
      queryWrapper.eq("strategy_ip_id", strategyIpId);
      }
      if (!CommonUtil.isEmpty(strategyIpIds)) {
      queryWrapper.in("strategy_ip_id", strategyIpIds);
      }
    return queryWrapper;
  }
}