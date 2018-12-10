package swust.qiy.microservice.management.query;

import swust.qiy.microservice.core.enums.QueryEnum;
import swust.qiy.microservice.core.query.BaseQuery;
import swust.qiy.microservice.management.entity.Api;

/**
 * @author qiying
 * @create 2018/12/10
 */
public class ApiQuery extends BaseQuery<Api> {

    /**
     * 唯一标识
     */
    private Integer id;

    private String name;

    /**
     * 请求协议
     */
    private String protocol;

    /**
     * 请求路径
     */
    private String path;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Boolean getInvalid() {
        return invalid;
    }

    public void setInvalid(Boolean invalid) {
        this.invalid = invalid;
    }

    public Integer getServiceVersionId() {
        return serviceVersionId;
    }

    public void setServiceVersionId(Integer serviceVersionId) {
        this.serviceVersionId = serviceVersionId;
    }

    public enum Enum implements QueryEnum<Api> {
        ID("id"),
        NAME("name"),
        PROTOCOL("protocol"),
        PATH("path"),
        TYPE("type"),
        STATUS("status"),
        INVALID("invalid"),
        SERVICE_VERSION_ID("service_version_id");

        private String fieldName;

        Enum(String fieldName) {
            this.fieldName = fieldName;
        }

        @Override
        public String getFieldName() {
            return null;
        }
    }

}
