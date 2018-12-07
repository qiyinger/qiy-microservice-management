package swust.qiy.microservice.management.entity;

import javax.persistence.*;

@Entity
@Table(name = "`api`")
public class Api {
    /**
     * 唯一标识
     */
    @Id
    @Column(name = "`ID`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * API名称
     */
    @Column(name = "`NAME`")
    private String name;

    /**
     * 请求协议
     */
    @Column(name = "`PROTOCOL`")
    private String protocol;

    /**
     * HTTP Method
     */
    @Column(name = "`METHOD`")
    private String method;

    /**
     * 请求路径
     */
    @Column(name = "`PATH`")
    private String path;

    /**
     * 描述
     */
    @Column(name = "`DESCRIPTION`")
    private String description;

    /**
     * 类型:内网Intranet/外网Internet
     */
    @Column(name = "`TYPE`")
    private String type;

    /**
     * 是否发布, 0:未发布, 1:发布
     */
    @Column(name = "`STATUS`")
    private Byte status;

    /**
     * 是否失效, 0:有效, 1:失效
     */
    @Column(name = "`INVALID`")
    private Boolean invalid;

    /**
     * 微服务版本标识
     */
    @Column(name = "`SERVICE_VERSION_ID`")
    private Integer serviceVersionId;

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
    public String getType() {
        return type;
    }

    /**
     * 设置类型:内网Intranet/外网Internet
     *
     * @param type 类型:内网Intranet/外网Internet
     */
    public void setType(String type) {
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
}