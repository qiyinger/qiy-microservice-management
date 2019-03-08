package swust.qiy.microservice.management.query;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;
import swust.qiy.microservice.core.query.BaseQuery;
import swust.qiy.microservice.core.util.CommonUtil;
import swust.qiy.microservice.management.entity.SystemInfo;

/**
 * @author qiying
 */
@Data
public class SystemInfoQuery extends BaseQuery<SystemInfo> {

  private Integer id;
  private List<Integer> ids;
  private String code;
  private String name;
  private Byte status;
  private LocalDateTime startCreateTime;
  private LocalDateTime endCreateTime;
  private LocalDateTime createTime;
  private String description;
  private String rsskey;
  private Integer userId;
  private List<Integer> userIds;
  private String userName;
  private Boolean isDeleted;

  @Override
  public QueryWrapper<SystemInfo> toQueryWrapper() {
    QueryWrapper<SystemInfo> queryWrapper = new QueryWrapper<>();
      if (!CommonUtil.isEmpty(id)) {
      queryWrapper.eq("id", id);
      }
      if (!CommonUtil.isEmpty(ids)) {
      queryWrapper.in("id", ids);
      }
      if (!CommonUtil.isEmpty(code)) {
      queryWrapper.eq("code", code);
      }
      if (!CommonUtil.isEmpty(name)) {
      queryWrapper.eq("name", name);
      }
      if (!CommonUtil.isEmpty(status)) {
      queryWrapper.eq("status", status);
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
      if (!CommonUtil.isEmpty(description)) {
      queryWrapper.eq("description", description);
      }
      if (!CommonUtil.isEmpty(rsskey)) {
      queryWrapper.eq("rsskey", rsskey);
      }
      if (!CommonUtil.isEmpty(userId)) {
      queryWrapper.eq("user_id", userId);
      }
      if (!CommonUtil.isEmpty(userIds)) {
        queryWrapper.in("user_id", userIds);
      }
      if (!CommonUtil.isEmpty(userName)) {
      queryWrapper.eq("user_name", userName);
      }
      if (!CommonUtil.isEmpty(isDeleted)) {
      queryWrapper.eq("is_deleted", isDeleted);
      }
    return queryWrapper;
  }
}