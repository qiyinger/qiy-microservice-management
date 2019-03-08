package swust.qiy.microservice.management.query;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.List;
import lombok.Data;
import swust.qiy.microservice.core.query.BaseQuery;
import swust.qiy.microservice.core.util.CommonUtil;
import swust.qiy.microservice.management.entity.StrategyIp;

/**
 * @author qiying
 */
@Data
public class StrategyIpQuery extends BaseQuery<StrategyIp> {

  private Integer id;
  private List<Integer> ids;
  private Byte type;
  private String ipList;
  private String serviceList;
  private Integer strategyId;
  private List<Integer> strategyIds;

  @Override
  public QueryWrapper<StrategyIp> toQueryWrapper() {
    QueryWrapper<StrategyIp> queryWrapper = new QueryWrapper<>();
      if (!CommonUtil.isEmpty(id)) {
      queryWrapper.eq("id", id);
      }
      if (!CommonUtil.isEmpty(ids)) {
      queryWrapper.in("id", ids);
      }
      if (!CommonUtil.isEmpty(type)) {
      queryWrapper.eq("type", type);
      }
      if (!CommonUtil.isEmpty(ipList)) {
      queryWrapper.eq("ip_list", ipList);
      }
      if (!CommonUtil.isEmpty(serviceList)) {
      queryWrapper.eq("service_list", serviceList);
      }
      if (!CommonUtil.isEmpty(strategyId)) {
      queryWrapper.eq("strategy_id", strategyId);
      }
      if (!CommonUtil.isEmpty(strategyIds)) {
        queryWrapper.in("strategy_id", strategyIds);
      }
    return queryWrapper;
  }
}