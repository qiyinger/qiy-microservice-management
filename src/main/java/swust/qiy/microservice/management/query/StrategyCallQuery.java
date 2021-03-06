package swust.qiy.microservice.management.query;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.List;
import lombok.Data;
import swust.qiy.microservice.core.query.BaseQuery;
import swust.qiy.microservice.core.util.CommonUtil;
import swust.qiy.microservice.management.entity.StrategyCall;

/**
 * @author qiying
 */
@Data
public class StrategyCallQuery extends BaseQuery<StrategyCall> {

  private Integer id;
  private List<Integer> ids;
  private String name;
  private String description;
  private Byte timeUnit;
  private Integer timePeriod;
  private Integer rateLimit;
  private Integer gatewayId;
  private List<Integer> gatewayIds;

  @Override
  public QueryWrapper<StrategyCall> toQueryWrapper() {
    QueryWrapper<StrategyCall> queryWrapper = new QueryWrapper<>();
      if (!CommonUtil.isEmpty(id)) {
      queryWrapper.eq("id", id);
      }
      if (!CommonUtil.isEmpty(ids)) {
      queryWrapper.in("id", ids);
      }
      if (!CommonUtil.isEmpty(name)) {
      queryWrapper.eq("name", name);
      }
      if (!CommonUtil.isEmpty(description)) {
      queryWrapper.eq("description", description);
      }
      if (!CommonUtil.isEmpty(timeUnit)) {
      queryWrapper.eq("time_unit", timeUnit);
      }
      if (!CommonUtil.isEmpty(timePeriod)) {
      queryWrapper.eq("time_period", timePeriod);
      }
      if (!CommonUtil.isEmpty(rateLimit)) {
      queryWrapper.eq("rate_limit", rateLimit);
      }
      if (!CommonUtil.isEmpty(gatewayId)) {
      queryWrapper.eq("gateway_id", gatewayId);
      }
      if (!CommonUtil.isEmpty(gatewayIds)) {
      queryWrapper.in("gateway_id", gatewayIds);
      }
    return queryWrapper;
  }
}