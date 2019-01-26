package swust.qiy.microservice.management.query;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.Data;
import swust.qiy.microservice.core.query.BaseQuery;
import swust.qiy.microservice.core.util.CommonUtil;
import swust.qiy.microservice.management.entity.Strategy;

/**
 * @author qiying
 */
@Data
public class StrategyQuery extends BaseQuery<Strategy> {

  private Integer id;
  private String name;
  private String type;
  private String description;

  @Override
  public QueryWrapper<Strategy> toQueryWrapper() {
    QueryWrapper<Strategy> queryWrapper = new QueryWrapper<>();
      if (!CommonUtil.isEmpty(id)) {
        queryWrapper.eq("id", id);
      }
      if (!CommonUtil.isEmpty(name)) {
        queryWrapper.eq("name", name);
      }
      if (!CommonUtil.isEmpty(type)) {
        queryWrapper.eq("type", type);
      }
      if (!CommonUtil.isEmpty(description)) {
        queryWrapper.eq("description", description);
      }
    return queryWrapper;
  }
}