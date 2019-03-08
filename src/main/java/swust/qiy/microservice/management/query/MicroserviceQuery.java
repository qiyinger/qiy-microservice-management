package swust.qiy.microservice.management.query;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;
import swust.qiy.microservice.core.query.BaseQuery;
import swust.qiy.microservice.core.util.CommonUtil;
import swust.qiy.microservice.management.entity.Microservice;

/**
 * @author qiying
 */
@Data
public class MicroserviceQuery extends BaseQuery<Microservice> {

  private Integer id;
  private List<Integer> ids;
  private String code;
  private String name;
  private Integer appId;
  private List<Integer> appIds;
  private LocalDateTime startCreateTime;
  private LocalDateTime endCreateTime;
  private LocalDateTime createTime;
  private String description;
  private Boolean isDeleted;

  @Override
  public QueryWrapper<Microservice> toQueryWrapper() {
    QueryWrapper<Microservice> queryWrapper = new QueryWrapper<>();
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
      if (!CommonUtil.isEmpty(appId)) {
      queryWrapper.eq("app_id", appId);
      }
      if (!CommonUtil.isEmpty(appIds)) {
        queryWrapper.in("app_id", appIds);
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
      if (!CommonUtil.isEmpty(isDeleted)) {
      queryWrapper.eq("is_deleted", isDeleted);
      }
    return queryWrapper;
  }
}