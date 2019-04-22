package swust.qiy.microservice.management.query;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;
import swust.qiy.microservice.core.query.BaseQuery;
import swust.qiy.microservice.core.util.CommonUtil;
import swust.qiy.microservice.management.entity.Route;

/**
 * @author qiying
 */
@Data
public class RouteQuery extends BaseQuery<Route> {

  private Integer id;
  private List<Integer> ids;
  private String name;
  private LocalDateTime startCreateTime;
  private LocalDateTime endCreateTime;
  private LocalDateTime createTime;
  private LocalDateTime startUpdateTime;
  private LocalDateTime endUpdateTime;
  private LocalDateTime updateTime;
  private String description;
  private Byte status;
  private Integer gatewayId;
  private List<Integer> gatewayIds;
  private Byte bindType;
  private Integer bindId;
  private List<Integer> bindIds;
  private String code;
  private String uri;
  private String filters;
  private String predicates;
  private Integer priority;

  @Override
  public QueryWrapper<Route> toQueryWrapper() {
    QueryWrapper<Route> queryWrapper = new QueryWrapper<>();
      if (!CommonUtil.isEmpty(id)) {
      queryWrapper.eq("id", id);
      }
      if (!CommonUtil.isEmpty(ids)) {
      queryWrapper.in("id", ids);
      }
      if (!CommonUtil.isEmpty(name)) {
      queryWrapper.eq("name", name);
      }
      if (!CommonUtil.isEmpty(startCreateTime)) {
      queryWrapper.ge("create_time", startCreateTime);
      }
      if (!CommonUtil.isEmpty(endCreateTime)) {
      queryWrapper.le("create_time", endCreateTime);
      }
      if (!CommonUtil.isEmpty(createTime)) {
      queryWrapper.eq("create_time", createTime);
      }
      if (!CommonUtil.isEmpty(startUpdateTime)) {
      queryWrapper.ge("update_time", startUpdateTime);
      }
      if (!CommonUtil.isEmpty(endUpdateTime)) {
      queryWrapper.le("update_time", endUpdateTime);
      }
      if (!CommonUtil.isEmpty(updateTime)) {
      queryWrapper.eq("update_time", updateTime);
      }
      if (!CommonUtil.isEmpty(description)) {
      queryWrapper.eq("description", description);
      }
      if (!CommonUtil.isEmpty(status)) {
      queryWrapper.eq("status", status);
      }
      if (!CommonUtil.isEmpty(gatewayId)) {
      queryWrapper.eq("gateway_id", gatewayId);
      }
      if (!CommonUtil.isEmpty(gatewayIds)) {
      queryWrapper.in("gateway_id", gatewayIds);
      }
      if (!CommonUtil.isEmpty(bindType)) {
      queryWrapper.eq("bind_type", bindType);
      }
      if (!CommonUtil.isEmpty(bindId)) {
      queryWrapper.eq("bind_id", bindId);
      }
      if (!CommonUtil.isEmpty(bindIds)) {
      queryWrapper.in("bind_id", bindIds);
      }
      if (!CommonUtil.isEmpty(code)) {
      queryWrapper.eq("code", code);
      }
      if (!CommonUtil.isEmpty(uri)) {
      queryWrapper.eq("uri", uri);
      }
      if (!CommonUtil.isEmpty(filters)) {
      queryWrapper.eq("filters", filters);
      }
      if (!CommonUtil.isEmpty(predicates)) {
      queryWrapper.eq("predicates", predicates);
      }
      if (!CommonUtil.isEmpty(priority)) {
      queryWrapper.eq("order", priority);
      }
    return queryWrapper;
  }
}