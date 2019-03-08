package swust.qiy.microservice.management.query;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.List;
import lombok.Data;
import swust.qiy.microservice.core.query.BaseQuery;
import swust.qiy.microservice.core.util.CommonUtil;
import swust.qiy.microservice.management.entity.PlatformConfig;

/**
 * @author qiying
 */
@Data
public class PlatformConfigQuery extends BaseQuery<PlatformConfig> {

  private Integer id;
  private List<Integer> ids;
  private String configKey;
  private String configValue;
  private String configName;

  @Override
  public QueryWrapper<PlatformConfig> toQueryWrapper() {
    QueryWrapper<PlatformConfig> queryWrapper = new QueryWrapper<>();
      if (!CommonUtil.isEmpty(id)) {
      queryWrapper.eq("id", id);
      }
      if (!CommonUtil.isEmpty(ids)) {
      queryWrapper.in("id", ids);
      }
      if (!CommonUtil.isEmpty(configKey)) {
      queryWrapper.eq("config_key", configKey);
      }
      if (!CommonUtil.isEmpty(configValue)) {
      queryWrapper.eq("config_value", configValue);
      }
      if (!CommonUtil.isEmpty(configName)) {
      queryWrapper.eq("config_name", configName);
      }
    return queryWrapper;
  }
}