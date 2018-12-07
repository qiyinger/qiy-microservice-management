package swust.qiy.microservice.management.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "`application`")
public class Application {
    /**
     * 唯一标识
     */
    @Id
    @Column(name = "`ID`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 应用编号
     */
    @Column(name = "`CODE`")
    private String code;

    /**
     * 应用名称
     */
    @Column(name = "`NAME`")
    private String name;

    /**
     * 创建时间
     */
    @Column(name = "`CREATE_TIME`")
    private LocalDateTime createTime;

    /**
     * 描述
     */
    @Column(name = "`DESCRIPTION`")
    private String description;

    /**
     * api数量
     */
    @Column(name = "`API_COUNT`")
    private Integer apiCount;

    /**
     * 所属系统标识
     */
    @Column(name = "`SYSTEM_ID`")
    private Integer systemId;

    /**
     * 逻辑删除标识, 0:未删除;1:已删除
     */
    @Column(name = "`IS_DELETED`")
    private Boolean isDeleted;

    /**
     * 是否启用, 0:未启用 1:已启用
     */
    @Column(name = "`status`")
    private Byte status;

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
     * 获取应用编号
     *
     * @return CODE - 应用编号
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置应用编号
     *
     * @param code 应用编号
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取应用名称
     *
     * @return NAME - 应用名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置应用名称
     *
     * @param name 应用名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取创建时间
     *
     * @return CREATE_TIME - 创建时间
     */
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(LocalDateTime createTime) {
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
     * 获取api数量
     *
     * @return API_COUNT - api数量
     */
    public Integer getApiCount() {
        return apiCount;
    }

    /**
     * 设置api数量
     *
     * @param apiCount api数量
     */
    public void setApiCount(Integer apiCount) {
        this.apiCount = apiCount;
    }

    /**
     * 获取所属系统标识
     *
     * @return SYSTEM_ID - 所属系统标识
     */
    public Integer getSystemId() {
        return systemId;
    }

    /**
     * 设置所属系统标识
     *
     * @param systemId 所属系统标识
     */
    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
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

    /**
     * 获取是否启用, 0:未启用 1:已启用
     *
     * @return status - 是否启用, 0:未启用 1:已启用
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置是否启用, 0:未启用 1:已启用
     *
     * @param status 是否启用, 0:未启用 1:已启用
     */
    public void setStatus(Byte status) {
        this.status = status;
    }
}