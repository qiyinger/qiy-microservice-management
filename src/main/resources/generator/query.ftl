package swust.qiy.microservice.management.query;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.Data;
import swust.qiy.microservice.core.query.BaseQuery;
import swust.qiy.microservice.core.util.CommonUtil;
import ${classFullName};

/**
 * @author qiying
 */
@Data
public class ${classSimpleName}Query extends BaseQuery<${classSimpleName}> {

<#list queryFields as field>
  private ${fields2type[field]!} ${field};
</#list>

  @Override
  public QueryWrapper<${classSimpleName}> toQueryWrapper() {
    QueryWrapper<${classSimpleName}> queryWrapper = new QueryWrapper<>();
  <#list queryFields as field>
      if (!CommonUtil.isEmpty(${field})) {
        <#if field?? && field?index_of("start") == 0>
        queryWrapper.ge("${fields2tableName[field]!}", ${field});
        <#elseif field?? && field?index_of("end") == 0>
        queryWrapper.le("${fields2tableName[field]!}", ${field});
        <#else>
        queryWrapper.eq("${fields2tableName[field]!}", ${field});
        </#if>
      }
  </#list>
    return queryWrapper;
  }
}