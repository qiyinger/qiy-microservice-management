package swust.qiy.microservice.management.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "`system`")
public class System {
    /**
     * 唯一标识
     */
    @Id
    @Column(name = "`ID`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 业务系统编号
     */
    @Column(name = "`CODE`")
    private String code;

    /**
     * 业务系统名称
     */
    @Column(name = "`NAME`")
    private String name;

    /**
     * 是否启用, 0:未启用 1:已启用
     */
    @Column(name = "`STATUS`")
    private Byte status;

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
     * 订阅码
     */
    @Column(name = "`RSSKEY`")
    private String rsskey;

    /**
     * 所属用户
     */
    @Column(name = "`user_id`")
    private Integer userId;

    /**
     * 用户名
     */
    @Column(name = "`user_name`")
    private String userName;

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
     * 获取业务系统编号
     *
     * @return CODE - 业务系统编号
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置业务系统编号
     *
     * @param code 业务系统编号
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取业务系统名称
     *
     * @return NAME - 业务系统名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置业务系统名称
     *
     * @param name 业务系统名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取是否启用, 0:未启用 1:已启用
     *
     * @return STATUS - 是否启用, 0:未启用 1:已启用
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
     * 获取订阅码
     *
     * @return RSSKEY - 订阅码
     */
    public String getRsskey() {
        return rsskey;
    }

    /**
     * 设置订阅码
     *
     * @param rsskey 订阅码
     */
    public void setRsskey(String rsskey) {
        this.rsskey = rsskey;
    }

    /**
     * 获取所属用户
     *
     * @return user_id - 所属用户
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置所属用户
     *
     * @param userId 所属用户
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取用户名
     *
     * @return user_name - 用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名
     *
     * @param userName 用户名
     */
    public void setUserName(String userName) {
        this.userName = userName;
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