package swust.qiy.microservice.management.query;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.Data;
import swust.qiy.microservice.core.query.BaseQuery;
import swust.qiy.microservice.core.util.CommonUtil;
import swust.qiy.microservice.management.entity.UserRole;

/**
 * @author qiying
 */
@Data
public class UserRoleQuery extends BaseQuery<UserRole> {

  private Integer id;
  private String code;
  private String name;

  @Override
  public QueryWrapper<UserRole> toQueryWrapper() {
    QueryWrapper<UserRole> queryWrapper = new QueryWrapper<>();
      if (!CommonUtil.isEmpty(id)) {
        queryWrapper.eq("id", id);
      }
      if (!CommonUtil.isEmpty(code)) {
        queryWrapper.eq("code", code);
      }
      if (!CommonUtil.isEmpty(name)) {
        queryWrapper.eq("name", name);
      }
    return queryWrapper;
  }
}