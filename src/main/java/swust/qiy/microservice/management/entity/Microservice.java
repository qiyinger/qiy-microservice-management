package swust.qiy.microservice.management.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "`microservice`")
public class Microservice {
    /**
     * 唯一标识
     */
    @Id
    @Column(name = "`ID`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 微服务编号
     */
    @Column(name = "`CODE`")
    private String code;

    /**
     * 微服务名称
     */
    @Column(name = "`NAME`")
    private String name;

    /**
     * 所属应用标识
     */
    @Column(name = "`APP_ID`")
    private Integer appId;

    /**
     * 创建时间
     */
    @Column(name = "`CREATE_TIME`")
    private Date createTime;

    /**
     * 描述
     */
    @Column(name = "`DESCRIPTION`")
    private String description;

    /**
     * 逻辑删除标识, 0:未删除;1:已删除
     */
    @Column(name = "`IS_DELETED`")
    private Boolean isDeleted;

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
     * 获取微服务编号
     *
     * @return CODE - 微服务编号
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置微服务编号
     *
     * @param code 微服务编号
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取微服务名称
     *
     * @return NAME - 微服务名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置微服务名称
     *
     * @param name 微服务名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取所属应用标识
     *
     * @return APP_ID - 所属应用标识
     */
    public Integer getAppId() {
        return appId;
    }

    /**
     * 设置所属应用标识
     *
     * @param appId 所属应用标识
     */
    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    /**
     * 获取创建时间
     *
     * @return CREATE_TIME - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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
     * 获取逻辑删除标识, 0:未删除;1:已删除
     *
     * @return IS_DELETED - 逻辑删除标识, 0:未删除;1:已删除
     */
    public Boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * 设置逻辑删除标识, 0:未删除;1:已删除
     *
     * @param isDeleted 逻辑删除标识, 0:未删除;1:已删除
     */
    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
}