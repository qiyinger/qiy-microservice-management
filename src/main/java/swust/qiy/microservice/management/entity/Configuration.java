package swust.qiy.microservice.management.entity;

import javax.persistence.*;

@Entity
@Table(name = "`configuration`")
public class Configuration {
    /**
     * 唯一标识
     */
    @Id
    @Column(name = "`ID`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Apollo环境
     */
    @Column(name = "`APOLLO_ENV`")
    private String apolloEnv;

    /**
     * Apollo的应用ID，即微服务Code
     */
    @Column(name = "`APOLLO_APP_ID`")
    private String apolloAppId;

    /**
     * Apollo集群名称
     */
    @Column(name = "`APOLLO_CLUSTER_NAME`")
    private String apolloClusterName;

    /**
     * Apollo名称空间名称
     */
    @Column(name = "`APOLLO_NS_NAME`")
    private String apolloNsName;

    /**
     * 所属微服务标识
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
     * 获取Apollo环境
     *
     * @return APOLLO_ENV - Apollo环境
     */
    public String getApolloEnv() {
        return apolloEnv;
    }

    /**
     * 设置Apollo环境
     *
     * @param apolloEnv Apollo环境
     */
    public void setApolloEnv(String apolloEnv) {
        this.apolloEnv = apolloEnv;
    }

    /**
     * 获取Apollo的应用ID，即微服务Code
     *
     * @return APOLLO_APP_ID - Apollo的应用ID，即微服务Code
     */
    public String getApolloAppId() {
        return apolloAppId;
    }

    /**
     * 设置Apollo的应用ID，即微服务Code
     *
     * @param apolloAppId Apollo的应用ID，即微服务Code
     */
    public void setApolloAppId(String apolloAppId) {
        this.apolloAppId = apolloAppId;
    }

    /**
     * 获取Apollo集群名称
     *
     * @return APOLLO_CLUSTER_NAME - Apollo集群名称
     */
    public String getApolloClusterName() {
        return apolloClusterName;
    }

    /**
     * 设置Apollo集群名称
     *
     * @param apolloClusterName Apollo集群名称
     */
    public void setApolloClusterName(String apolloClusterName) {
        this.apolloClusterName = apolloClusterName;
    }

    /**
     * 获取Apollo名称空间名称
     *
     * @return APOLLO_NS_NAME - Apollo名称空间名称
     */
    public String getApolloNsName() {
        return apolloNsName;
    }

    /**
     * 设置Apollo名称空间名称
     *
     * @param apolloNsName Apollo名称空间名称
     */
    public void setApolloNsName(String apolloNsName) {
        this.apolloNsName = apolloNsName;
    }

    /**
     * 获取所属微服务标识
     *
     * @return SERVICE_VERSION_ID - 所属微服务标识
     */
    public Integer getServiceVersionId() {
        return serviceVersionId;
    }

    /**
     * 设置所属微服务标识
     *
     * @param serviceVersionId 所属微服务标识
     */
    public void setServiceVersionId(Integer serviceVersionId) {
        this.serviceVersionId = serviceVersionId;
    }
}