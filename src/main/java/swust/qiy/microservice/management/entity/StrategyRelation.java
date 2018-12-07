package swust.qiy.microservice.management.entity;

import javax.persistence.*;

@Entity
@Table(name = "`strategy_relation`")
public class StrategyRelation {
    /**
     * 唯一标识
     */
    @Id
    @Column(name = "`ID`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 策略标识
     */
    @Column(name = "`STRATEGY_ID`")
    private Integer strategyId;

    /**
     * 路由标识
     */
    @Column(name = "`ROUTE_ID`")
    private Integer routeId;

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

    /**
     * 获取路由标识
     *
     * @return ROUTE_ID - 路由标识
     */
    public Integer getRouteId() {
        return routeId;
    }

    /**
     * 设置路由标识
     *
     * @param routeId 路由标识
     */
    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }
}