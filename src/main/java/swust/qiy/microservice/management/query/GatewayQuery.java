package swust.qiy.microservice.management.query;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.Data;
import swust.qiy.microservice.core.query.BaseQuery;
import swust.qiy.microservice.core.util.CommonUtil;
import swust.qiy.microservice.management.entity.Gateway;

/**
 * @author qiying
 */
@Data
public class GatewayQuery extends BaseQuery<Gateway> {

  private Integer id;
  private String code;
  private String name;
  private String description;
  private Byte status;
  private Byte type;
  private Integer systemId;

  @Override
  public QueryWrapper<Gateway> toQueryWrapper() {
    QueryWrapper<Gateway> queryWrapper = new QueryWrapper<>();
      if (!CommonUtil.isEmpty(id)) {
        queryWrapper.eq("id", id);
      }
      if (!CommonUtil.isEmpty(code)) {
        queryWrapper.eq("code", code);
      }
      if (!CommonUtil.isEmpty(name)) {
        queryWrapper.eq("name", name);
      }
      if (!CommonUtil.isEmpty(description)) {
        queryWrapper.eq("description", description);
      }
      if (!CommonUtil.isEmpty(status)) {
        queryWrapper.eq("status", status);
      }
      if (!CommonUtil.isEmpty(type)) {
        queryWrapper.eq("type", type);
      }
      if (!CommonUtil.isEmpty(systemId)) {
        queryWrapper.eq("system_id", systemId);
      }
    return queryWrapper;
  }
}