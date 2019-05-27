package swust.qiy.microservice.management.query;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;
import swust.qiy.microservice.core.query.BaseQuery;
import swust.qiy.microservice.core.util.CommonUtil;
import swust.qiy.microservice.management.entity.MicroserviceVersion;

/**
 * @author qiying
 */
@Data
public class MicroserviceVersionQuery extends BaseQuery<MicroserviceVersion> {

  private Integer id;
  private List<Integer> ids;
  private String version;
  private Boolean online;
  private LocalDateTime startCreateTime;
  private LocalDateTime endCreateTime;
  private LocalDateTime createTime;
  private String description;
  private Integer microserviceId;
  private List<Integer> microserviceIds;
  private Boolean configurated;
  private Boolean publish;
  private Boolean isDeleted;

  @Override
  public QueryWrapper<MicroserviceVersion> toQueryWrapper() {
    QueryWrapper<MicroserviceVersion> queryWrapper = new QueryWrapper<>();
      if (!CommonUtil.isEmpty(id)) {
      queryWrapper.eq("id", id);
      }
      if (!CommonUtil.isEmpty(ids)) {
      queryWrapper.in("id", ids);
      }
      if (!CommonUtil.isEmpty(version)) {
      queryWrapper.eq("version", version);
      }
      if (!CommonUtil.isEmpty(online)) {
      queryWrapper.eq("online", online);
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
      if (!CommonUtil.isEmpty(microserviceId)) {
      queryWrapper.eq("microservice_id", microserviceId);
      }
      if (!CommonUtil.isEmpty(microserviceIds)) {
      queryWrapper.in("microservice_id", microserviceIds);
      }
      if (!CommonUtil.isEmpty(configurated)) {
      queryWrapper.eq("configurated", configurated);
      }
      if (!CommonUtil.isEmpty(publish)) {
      queryWrapper.eq("publish", publish);
      }
      if (!CommonUtil.isEmpty(isDeleted)) {
      queryWrapper.eq("is_deleted", isDeleted);
      }
    return queryWrapper;
  }
}