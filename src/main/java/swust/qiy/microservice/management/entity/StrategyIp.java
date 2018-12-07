package swust.qiy.microservice.management.entity;

import javax.persistence.*;

@Entity
@Table(name = "`strategy_ip`")
public class StrategyIp {
    /**
     * 唯一标识
     */
    @Id
    @Column(name = "`ID`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 控制类型:黑名单black/白名单white
     */
    @Column(name = "`TYPE`")
    private String type;

    /**
     * ip列表
     */
    @Column(name = "`IP_LIST`")
    private String ipList;

    /**
     * 微服务列表
     */
    @Column(name = "`SERVICE_LIST`")
    private String serviceList;

    /**
     * 策略标识
     */
    @Column(name = "`STRATEGY_ID`")
    private Integer strategyId;

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
     * 获取控制类型:黑名单black/白名单white
     *
     * @return TYPE - 控制类型:黑名单black/白名单white
     */
    public String getType() {
        return type;
    }

    /**
     * 设置控制类型:黑名单black/白名单white
     *
     * @param type 控制类型:黑名单black/白名单white
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取ip列表
     *
     * @return IP_LIST - ip列表
     */
    public String getIpList() {
        return ipList;
    }

    /**
     * 设置ip列表
     *
     * @param ipList ip列表
     */
    public void setIpList(String ipList) {
        this.ipList = ipList;
    }

    /**
     * 获取微服务列表
     *
     * @return SERVICE_LIST - 微服务列表
     */
    public String getServiceList() {
        return serviceList;
    }

    /**
     * 设置微服务列表
     *
     * @param serviceList 微服务列表
     */
    public void setServiceList(String serviceList) {
        this.serviceList = serviceList;
    }

    /**
     * 获取策略标识
     *
     * @return STRATEGY_ID - 策略标识
     */
    public Integer getStrategyId() {
        return strategyId;
    }

    /**
     * 设置策略标识
     *
     * @param strategyId 策略标识
     */
    public void setStrategyId(Integer strategyId) {
        this.strategyId = strategyId;
    }
}