package swust.qiy.microservice.management.query;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.time.LocalDateTime;
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
  private String version;
  private Integer numOfInst;
  private Byte onlineStatus;
  private LocalDateTime startCreateTime;
  private LocalDateTime endCreateTime;
  private LocalDateTime createTime;
  private String description;
  private Integer microserviceId;
  private Boolean isDeleted;

  @Override
  public QueryWrapper<MicroserviceVersion> toQueryWrapper() {
    QueryWrapper<MicroserviceVersion> queryWrapper = new QueryWrapper<>();
      if (!CommonUtil.isEmpty(id)) {
        queryWrapper.eq("id", id);
      }
      if (!CommonUtil.isEmpty(version)) {
        queryWrapper.eq("version", version);
      }
      if (!CommonUtil.isEmpty(numOfInst)) {
        queryWrapper.eq("num_of_inst", numOfInst);
      }
      if (!CommonUtil.isEmpty(onlineStatus)) {
        queryWrapper.eq("online_status", onlineStatus);
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
      if (!CommonUtil.isEmpty(isDeleted)) {
        queryWrapper.eq("is_deleted", isDeleted);
      }
    return queryWrapper;
  }
}