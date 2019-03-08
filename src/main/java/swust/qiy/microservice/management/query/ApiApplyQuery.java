package swust.qiy.microservice.management.query;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;
import swust.qiy.microservice.core.query.BaseQuery;
import swust.qiy.microservice.core.util.CommonUtil;
import swust.qiy.microservice.management.entity.ApiApply;

/**
 * @author qiying
 */
@Data
public class ApiApplyQuery extends BaseQuery<ApiApply> {

  private Integer id;
  private List<Integer> ids;
  private String applicant;
  private Byte status;
  private Byte type;
  private LocalDateTime startApplyTime;
  private LocalDateTime endApplyTime;
  private LocalDateTime applyTime;
  private String description;
  private String auditorName;
  private Integer asId;
  private List<Integer> asIds;
  private LocalDateTime startModifyTime;
  private LocalDateTime endModifyTime;
  private LocalDateTime modifyTime;

  @Override
  public QueryWrapper<ApiApply> toQueryWrapper() {
    QueryWrapper<ApiApply> queryWrapper = new QueryWrapper<>();
    if (!CommonUtil.isEmpty(id)) {
      queryWrapper.eq("id", id);
    }
    if (!CommonUtil.isEmpty(ids)) {
      queryWrapper.in("id", ids);
    }
    if (!CommonUtil.isEmpty(applicant)) {
      queryWrapper.eq("applicant", applicant);
    }
    if (!CommonUtil.isEmpty(status)) {
      queryWrapper.eq("status", status);
    }
    if (!CommonUtil.isEmpty(type)) {
      queryWrapper.eq("type", type);
    }
    if (!CommonUtil.isEmpty(startApplyTime)) {
      queryWrapper.ge("apply_time", startApplyTime);
    }
    if (!CommonUtil.isEmpty(endApplyTime)) {
      queryWrapper.le("apply_time", endApplyTime);
    }
    if (!CommonUtil.isEmpty(applyTime)) {
      queryWrapper.eq("apply_time", applyTime);
    }
    if (!CommonUtil.isEmpty(description)) {
      queryWrapper.eq("description", description);
    }
    if (!CommonUtil.isEmpty(auditorName)) {
      queryWrapper.eq("auditor_name", auditorName);
    }
    if (!CommonUtil.isEmpty(asId)) {
      queryWrapper.eq("as_id", asId);
    }
    if (!CommonUtil.isEmpty(asIds)) {
      queryWrapper.in("as_id", asIds);
    }
    if (!CommonUtil.isEmpty(startModifyTime)) {
      queryWrapper.ge("modify_time", startModifyTime);
    }
    if (!CommonUtil.isEmpty(endModifyTime)) {
      queryWrapper.le("modify_time", endModifyTime);
    }
    if (!CommonUtil.isEmpty(modifyTime)) {
      queryWrapper.eq("modify_time", modifyTime);
    }
    return queryWrapper;
  }
}