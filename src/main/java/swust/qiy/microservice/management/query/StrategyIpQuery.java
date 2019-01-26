package swust.qiy.microservice.management.query;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
  private String type;
  private String ipList;
  private String serviceList;
  private Integer strategyId;

  @Override
  public QueryWrapper<StrategyIp> toQueryWrapper() {
    QueryWrapper<StrategyIp> queryWrapper = new QueryWrapper<>();
      if (!CommonUtil.isEmpty(id)) {
        queryWrapper.eq("id", id);
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
    return queryWrapper;
  }
}