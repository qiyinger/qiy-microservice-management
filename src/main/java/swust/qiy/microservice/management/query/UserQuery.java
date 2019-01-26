package swust.qiy.microservice.management.query;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.Data;
import swust.qiy.microservice.core.query.BaseQuery;
import swust.qiy.microservice.core.util.CommonUtil;
import swust.qiy.microservice.management.entity.User;

/**
 * @author qiying
 */
@Data
public class UserQuery extends BaseQuery<User> {

  private Integer id;
  private String name;
  private String password;
  private Integer roleId;

  @Override
  public QueryWrapper<User> toQueryWrapper() {
    QueryWrapper<User> queryWrapper = new QueryWrapper<>();
      if (!CommonUtil.isEmpty(id)) {
        queryWrapper.eq("id", id);
      }
      if (!CommonUtil.isEmpty(name)) {
        queryWrapper.eq("name", name);
      }
      if (!CommonUtil.isEmpty(password)) {
        queryWrapper.eq("password", password);
      }
      if (!CommonUtil.isEmpty(roleId)) {
        queryWrapper.eq("role_id", roleId);
      }
    return queryWrapper;
  }
}