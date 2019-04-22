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
  private String name;
  private Byte type;
  private String description;
  private String ipList;
  private Integer gatewayId;
  private List<Integer> gatewayIds;

  @Override
  public QueryWrapper<StrategyIp> toQueryWrapper() {
    QueryWrapper<StrategyIp> queryWrapper = new QueryWrapper<>();
      if (!CommonUtil.isEmpty(id)) {
      queryWrapper.eq("id", id);
      }
      if (!CommonUtil.isEmpty(ids)) {
      queryWrapper.in("id", ids);
      }
      if (!CommonUtil.isEmpty(name)) {
      queryWrapper.eq("name", name);
      }
      if (!CommonUtil.isEmpty(type)) {
      queryWrapper.eq("type", type);
      }
      if (!CommonUtil.isEmpty(description)) {
      queryWrapper.eq("description", description);
      }
      if (!CommonUtil.isEmpty(ipList)) {
      queryWrapper.eq("ip_list", ipList);
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