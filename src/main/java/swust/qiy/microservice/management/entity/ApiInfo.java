package swust.qiy.microservice.management.entity;


public class ApiInfo {

  /**
   * 唯一标识
   */
  private Integer id;

  /**
   * API名称
   */
  private String name;

  /**
   * 请求协议
   */
  private String protocol;

  /**
   * HTTP Method
   */
  private String method;

  /**
   * 请求路径
   */
  private String path;

  /**
   * 描述
   */
  private String description;

  /**
   * 类型:内网Intranet/外网Internet
   */
  private Byte type;

  /**
   * 是否发布, 0:未发布, 1:发布
   */
  private Byte status;

  /**
   * 是否失效, 0:有效, 1:失效
   */
  private Boolean invalid;

  /**
   * 微服务版本标识
   */
  private Integer serviceVersionId;

  /**
   * 请求头部
   */
  private String header;

  /**
   * 请求参数
   */
  private String parameters;

  /**
   * 返回信息
   */
  private String returnInfo;

  /**
   * 复杂类型对象
   */
  private String typeObj;

  /**
   * 错误码说明
   */
  private String errorCode;

  /**
   * 获取唯一标识
   *
   * @return ID - 唯一标识
   */
  public Integer getId() {
    return id;
  }

  /**
   * 设置唯一标识
   *
   * @param id 唯一标识
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * 获取API名称
   *
   * @return NAME - API名称
   */
  public String getName() {
    return name;
  }

  /**
   * 设置API名称
   *
   * @param name API名称
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * 获取请求协议
   *
   * @return PROTOCOL - 请求协议
   */
  public String getProtocol() {
    return protocol;
  }

  /**
   * 设置请求协议
   *
   * @param protocol 请求协议
   */
  public void setProtocol(String protocol) {
    this.protocol = protocol;
  }

  /**
   * 获取HTTP Method
   *
   * @return METHOD - HTTP Method
   */
  public String getMethod() {
    return method;
  }

  /**
   * 设置HTTP Method
   *
   * @param method HTTP Method
   */
  public void setMethod(String method) {
    this.method = method;
  }

  /**
   * 获取请求路径
   *
   * @return PATH - 请求路径
   */
  public String getPath() {
    return path;
  }

  /**
   * 设置请求路径
   *
   * @param path 请求路径
   */
  public void setPath(String path) {
    this.path = path;
  }

  /**
   * 获取描述
   *
   * @return DESCRIPTION - 描述
   */
  public String getDescription() {
    return description;
  }

  /**
   * 设置描述
   *
   * @param description 描述
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * 获取类型:内网Intranet/外网Internet
   *
   * @return TYPE - 类型:内网Intranet/外网Internet
   */
  public Byte getType() {
    return type;
  }

  /**
   * 设置类型:内网Intranet/外网Internet
   *
   * @param type 类型:内网Intranet/外网Internet
   */
  public void setType(Byte type) {
    this.type = type;
  }

  /**
   * 获取是否发布, 0:未发布, 1:发布
   *
   * @return STATUS - 是否发布, 0:未发布, 1:发布
   */
  public Byte getStatus() {
    return status;
  }

  /**
   * 设置是否发布, 0:未发布, 1:发布
   *
   * @param status 是否发布, 0:未发布, 1:发布
   */
  public void setStatus(Byte status) {
    this.status = status;
  }

  /**
   * 获取是否失效, 0:有效, 1:失效
   *
   * @return INVALID - 是否失效, 0:有效, 1:失效
   */
  public Boolean getInvalid() {
    return invalid;
  }

  /**
   * 设置是否失效, 0:有效, 1:失效
   *
   * @param invalid 是否失效, 0:有效, 1:失效
   */
  public void setInvalid(Boolean invalid) {
    this.invalid = invalid;
  }

  /**
   * 获取微服务版本标识
   *
   * @return SERVICE_VERSION_ID - 微服务版本标识
   */
  public Integer getServiceVersionId() {
    return serviceVersionId;
  }

  /**
   * 设置微服务版本标识
   *
   * @param serviceVersionId 微服务版本标识
   */
  public void setServiceVersionId(Integer serviceVersionId) {
    this.serviceVersionId = serviceVersionId;
  }

  /**
   * 获取请求头部
   *
   * @return HEADER - 请求头部
   */
  public String getHeader() {
    return header;
  }

  /**
   * 设置请求头部
   *
   * @param header 请求头部
   */
  public void setHeader(String header) {
    this.header = header;
  }

  /**
   * 获取请求参数
   *
   * @return PARAMETERS - 请求参数
   */
  public String getParameters() {
    return parameters;
  }

  /**
   * 设置请求参数
   *
   * @param parameters 请求参数
   */
  public void setParameters(String parameters) {
    this.parameters = parameters;
  }

  /**
   * 获取返回信息
   *
   * @return RETURN_INFO - 返回信息
   */
  public String getReturnInfo() {
    return returnInfo;
  }

  /**
   * 设置返回信息
   *
   * @param returnInfo 返回信息
   */
  public void setReturnInfo(String returnInfo) {
    this.returnInfo = returnInfo;
  }

  /**
   * 获取复杂类型对象
   *
   * @return TYPE_OBJ - 复杂类型对象
   */
  public String getTypeObj() {
    return typeObj;
  }

  /**
   * 设置复杂类型对象
   *
   * @param typeObj 复杂类型对象
   */
  public void setTypeObj(String typeObj) {
    this.typeObj = typeObj;
  }

  /**
   * 获取错误码说明
   *
   * @return ERROR_CODE - 错误码说明
   */
  public String getErrorCode() {
    return errorCode;
  }

  /**
   * 设置错误码说明
   *
   * @param errorCode 错误码说明
   */
  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }
}