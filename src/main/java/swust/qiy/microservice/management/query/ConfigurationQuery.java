package swust.qiy.microservice.management.query;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.Data;
import swust.qiy.microservice.core.query.BaseQuery;
import swust.qiy.microservice.core.util.CommonUtil;
import swust.qiy.microservice.management.entity.Configuration;

/**
 * @author qiying
 */
@Data
public class ConfigurationQuery extends BaseQuery<Configuration> {

  private Integer id;
  private String apolloEnv;
  private String apolloAppId;
  private String apolloClusterName;
  private String apolloNsName;
  private Integer serviceVersionId;

  @Override
  public QueryWrapper<Configuration> toQueryWrapper() {
    QueryWrapper<Configuration> queryWrapper = new QueryWrapper<>();
      if (!CommonUtil.isEmpty(id)) {
        queryWrapper.eq("id", id);
      }
      if (!CommonUtil.isEmpty(apolloEnv)) {
        queryWrapper.eq("apollo_env", apolloEnv);
      }
      if (!CommonUtil.isEmpty(apolloAppId)) {
        queryWrapper.eq("apollo_app_id", apolloAppId);
      }
      if (!CommonUtil.isEmpty(apolloClusterName)) {
        queryWrapper.eq("apollo_cluster_name", apolloClusterName);
      }
      if (!CommonUtil.isEmpty(apolloNsName)) {
        queryWrapper.eq("apollo_ns_name", apolloNsName);
      }
      if (!CommonUtil.isEmpty(serviceVersionId)) {
        queryWrapper.eq("service_version_id", serviceVersionId);
      }
    return queryWrapper;
  }
}