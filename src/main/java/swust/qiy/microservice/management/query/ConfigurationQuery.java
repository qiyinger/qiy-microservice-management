package swust.qiy.microservice.management.query;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.List;
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
  private List<Integer> ids;
  private String apolloEnv;
  private String apolloAppId;
  private List<Integer> apolloAppIds;
  private String apolloClusterName;
  private String apolloNsName;
  private Integer serviceVersionId;
  private List<Integer> serviceVersionIds;

  @Override
  public QueryWrapper<Configuration> toQueryWrapper() {
    QueryWrapper<Configuration> queryWrapper = new QueryWrapper<>();
      if (!CommonUtil.isEmpty(id)) {
      queryWrapper.eq("id", id);
      }
      if (!CommonUtil.isEmpty(ids)) {
      queryWrapper.in("id", ids);
      }
      if (!CommonUtil.isEmpty(apolloEnv)) {
      queryWrapper.eq("apollo_env", apolloEnv);
      }
      if (!CommonUtil.isEmpty(apolloAppId)) {
      queryWrapper.eq("apollo_app_id", apolloAppId);
      }
      if (!CommonUtil.isEmpty(apolloAppIds)) {
      queryWrapper.in("apollo_app_id", apolloAppIds);
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
      if (!CommonUtil.isEmpty(serviceVersionIds)) {
      queryWrapper.in("service_version_id", serviceVersionIds);
      }
    return queryWrapper;
  }
}