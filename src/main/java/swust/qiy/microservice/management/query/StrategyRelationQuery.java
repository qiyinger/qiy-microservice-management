package swust.qiy.microservice.management.query;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.Data;
import swust.qiy.microservice.core.query.BaseQuery;
import swust.qiy.microservice.core.util.CommonUtil;
import swust.qiy.microservice.management.entity.StrategyRelation;

/**
 * @author qiying
 */
@Data
public class StrategyRelationQuery extends BaseQuery<StrategyRelation> {

  private Integer id;
  private Integer strategyId;
  private Integer routeId;

  @Override
  public QueryWrapper<StrategyRelation> toQueryWrapper() {
    QueryWrapper<StrategyRelation> queryWrapper = new QueryWrapper<>();
      if (!CommonUtil.isEmpty(id)) {
        queryWrapper.eq("id", id);
      }
      if (!CommonUtil.isEmpty(strategyId)) {
        queryWrapper.eq("strategy_id", strategyId);
      }
      if (!CommonUtil.isEmpty(routeId)) {
        queryWrapper.eq("route_id", routeId);
      }
    return queryWrapper;
  }
}