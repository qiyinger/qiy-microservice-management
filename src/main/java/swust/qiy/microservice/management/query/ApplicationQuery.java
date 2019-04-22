package swust.qiy.microservice.management.query;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;
import swust.qiy.microservice.core.query.BaseQuery;
import swust.qiy.microservice.core.util.CommonUtil;
import swust.qiy.microservice.management.entity.Application;

/**
 * @author qiying
 */
@Data
public class ApplicationQuery extends BaseQuery<Application> {

  private Integer id;
  private List<Integer> ids;
  private String code;
  private String allCode;
  private String name;
  private LocalDateTime startCreateTime;
  private LocalDateTime endCreateTime;
  private LocalDateTime createTime;
  private String description;
  private Integer apiCount;
  private Integer systemId;
  private List<Integer> systemIds;
  private Boolean isDeleted;
  private Byte status;
  private Integer userId;
  private List<Integer> userIds;

  @Override
  public QueryWrapper<Application> toQueryWrapper() {
    QueryWrapper<Application> queryWrapper = new QueryWrapper<>();
      if (!CommonUtil.isEmpty(id)) {
      queryWrapper.eq("id", id);
      }
      if (!CommonUtil.isEmpty(ids)) {
      queryWrapper.in("id", ids);
      }
      if (!CommonUtil.isEmpty(code)) {
      queryWrapper.eq("code", code);
      }
      if (!CommonUtil.isEmpty(allCode)) {
      queryWrapper.eq("all_code", allCode);
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
      if (!CommonUtil.isEmpty(description)) {
      queryWrapper.eq("description", description);
      }
      if (!CommonUtil.isEmpty(apiCount)) {
      queryWrapper.eq("api_count", apiCount);
      }
      if (!CommonUtil.isEmpty(systemId)) {
      queryWrapper.eq("system_id", systemId);
      }
      if (!CommonUtil.isEmpty(systemIds)) {
      queryWrapper.in("system_id", systemIds);
      }
      if (!CommonUtil.isEmpty(isDeleted)) {
      queryWrapper.eq("is_deleted", isDeleted);
      }
      if (!CommonUtil.isEmpty(status)) {
      queryWrapper.eq("status", status);
      }
      if (!CommonUtil.isEmpty(userId)) {
      queryWrapper.eq("user_id", userId);
      }
      if (!CommonUtil.isEmpty(userIds)) {
      queryWrapper.in("user_id", userIds);
      }
    return queryWrapper;
  }
}