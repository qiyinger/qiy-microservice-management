package swust.qiy.microservice.management.entity;

import javax.persistence.*;

@Entity
@Table(name = "`gateway`")
public class Gateway {
    /**
     * 唯一标识
     */
    @Id
    @Column(name = "`ID`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 网关编码注册中心上使用${CODE}作为服务名
     */
    @Column(name = "`CODE`")
    private String code;

    /**
     * 网关名称
     */
    @Column(name = "`NAME`")
    private String name;

    /**
     * 描述
     */
    @Column(name = "`DESCRIPTION`")
    private String description;

    /**
     * 状态:PAUSE、ON、OFF
     */
    @Column(name = "`STATUS`")
    private Byte status;

    /**
     * 类型:内网Intranet/外网Internet
     */
    @Column(name = "`TYPE`")
    private Byte type;

    /**
     * 系统标识
     */
    @Column(name = "`SYSTEM_ID`")
    private Integer systemId;

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
     * 获取网关编码注册中心上使用${CODE}作为服务名
     *
     * @return CODE - 网关编码注册中心上使用${CODE}作为服务名
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置网关编码注册中心上使用${CODE}作为服务名
     *
     * @param code 网关编码注册中心上使用${CODE}作为服务名
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取网关名称
     *
     * @return NAME - 网关名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置网关名称
     *
     * @param name 网关名称
     */
    public void setName(String name) {
        this.name = name;
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
     * 获取状态:PAUSE、ON、OFF
     *
     * @return STATUS - 状态:PAUSE、ON、OFF
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置状态:PAUSE、ON、OFF
     *
     * @param status 状态:PAUSE、ON、OFF
     */
    public void setStatus(Byte status) {
        this.status = status;
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
     * 获取系统标识
     *
     * @return SYSTEM_ID - 系统标识
     */
    public Integer getSystemId() {
        return systemId;
    }

    /**
     * 设置系统标识
     *
     * @param systemId 系统标识
     */
    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }
}