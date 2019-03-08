package swust.qiy.microservice.management.query;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;
import swust.qiy.microservice.core.query.BaseQuery;
import swust.qiy.microservice.core.util.CommonUtil;
import swust.qiy.microservice.management.entity.Event;

/**
 * @author qiying
 */
@Data
public class EventQuery extends BaseQuery<Event> {

  private Integer id;
  private List<Integer> ids;
  private Byte type;
  private Byte eventType;
  private LocalDateTime startTime;
  private LocalDateTime endTime;
  private LocalDateTime time;
  private String affects;
  private String source;

  @Override
  public QueryWrapper<Event> toQueryWrapper() {
    QueryWrapper<Event> queryWrapper = new QueryWrapper<>();
      if (!CommonUtil.isEmpty(id)) {
      queryWrapper.eq("id", id);
      }
      if (!CommonUtil.isEmpty(ids)) {
      queryWrapper.in("id", ids);
      }
      if (!CommonUtil.isEmpty(type)) {
      queryWrapper.eq("type", type);
      }
      if (!CommonUtil.isEmpty(eventType)) {
      queryWrapper.eq("event_type", eventType);
      }
      if (!CommonUtil.isEmpty(startTime)) {
      queryWrapper.ge("time", startTime);
      }
      if (!CommonUtil.isEmpty(endTime)) {
      queryWrapper.le("time", endTime);
      }
      if (!CommonUtil.isEmpty(time)) {
      queryWrapper.eq("time", time);
      }
      if (!CommonUtil.isEmpty(affects)) {
      queryWrapper.eq("affects", affects);
      }
      if (!CommonUtil.isEmpty(source)) {
      queryWrapper.eq("source", source);
      }
    return queryWrapper;
  }
}