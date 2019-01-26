package swust.qiy.microservice.management.query;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.Data;
import swust.qiy.microservice.core.query.BaseQuery;
import swust.qiy.microservice.core.util.CommonUtil;
import swust.qiy.microservice.management.entity.Api;

/**
 * @author qiying
 */
@Data
public class ApiQuery extends BaseQuery<Api> {

  private Integer id;
  private String name;
  private String protocol;
  private String method;
  private String path;
  private String description;
  private Byte type;
  private Byte status;
  private Boolean invalid;
  private Integer serviceVersionId;
  private String header;
  private String parameters;
  private String returnInfo;
  private String typeObj;
  private String errorCode;

  @Override
  public QueryWrapper<Api> toQueryWrapper() {
    QueryWrapper<Api> queryWrapper = new QueryWrapper<>();
      if (!CommonUtil.isEmpty(id)) {
        queryWrapper.eq("id", id);
      }
      if (!CommonUtil.isEmpty(name)) {
        queryWrapper.eq("name", name);
      }
      if (!CommonUtil.isEmpty(protocol)) {
        queryWrapper.eq("protocol", protocol);
      }
      if (!CommonUtil.isEmpty(method)) {
        queryWrapper.eq("method", method);
      }
      if (!CommonUtil.isEmpty(path)) {
        queryWrapper.eq("path", path);
      }
      if (!CommonUtil.isEmpty(description)) {
        queryWrapper.eq("description", description);
      }
      if (!CommonUtil.isEmpty(type)) {
        queryWrapper.eq("type", type);
      }
      if (!CommonUtil.isEmpty(status)) {
        queryWrapper.eq("status", status);
      }
      if (!CommonUtil.isEmpty(invalid)) {
        queryWrapper.eq("invalid", invalid);
      }
      if (!CommonUtil.isEmpty(serviceVersionId)) {
        queryWrapper.eq("service_version_id", serviceVersionId);
      }
      if (!CommonUtil.isEmpty(header)) {
        queryWrapper.eq("header", header);
      }
      if (!CommonUtil.isEmpty(parameters)) {
        queryWrapper.eq("parameters", parameters);
      }
      if (!CommonUtil.isEmpty(returnInfo)) {
        queryWrapper.eq("return_info", returnInfo);
      }
      if (!CommonUtil.isEmpty(typeObj)) {
        queryWrapper.eq("type_obj", typeObj);
      }
      if (!CommonUtil.isEmpty(errorCode)) {
        queryWrapper.eq("error_code", errorCode);
      }
    return queryWrapper;
  }
}