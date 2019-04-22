package swust.qiy.microservice.management.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swust.qiy.microservice.core.constant.StatusConstant;
import swust.qiy.microservice.core.result.Result;
import swust.qiy.microservice.core.result.ResultUtil;
import swust.qiy.microservice.core.service.impl.BaseServiceImpl;
import swust.qiy.microservice.management.dao.RouteDao;
import swust.qiy.microservice.management.dao.RouteStrategyDao;
import swust.qiy.microservice.management.dao.StrategyCallDao;
import swust.qiy.microservice.management.dao.StrategyIpDao;
import swust.qiy.microservice.management.entity.Route;
import swust.qiy.microservice.management.entity.RouteStrategy;
import swust.qiy.microservice.management.message.RateLimitMessage;
import swust.qiy.microservice.management.service.RouteStrategyService;
import swust.qiy.microservice.sdk.mq.MsgSender;

/**
 * @author qiying
 */
@Service
public class RouteStrategyServiceImpl extends BaseServiceImpl<RouteStrategy> implements
  RouteStrategyService {

  @Autowired
  private StrategyIpDao strategyIpDao;
  @Autowired
  private StrategyCallDao strategyCallDao;
  @Autowired
  private RouteStrategyDao routeStrategyDao;
  @Autowired
  private RouteDao routeDao;
  @Autowired
  private MsgSender msgSender;

  @Override
  public Result save(Integer routeId, List<Integer> strategyIds, Byte type) {
    Result result = checkId(routeDao, routeId);
    if (!result.isSuccess()) {
      return result;
    }
    Route routeInfo = (Route) result.getData();
    List<RouteStrategy> needSaveList = strategyIds.stream()
      .map(strategyId -> new RouteStrategy(routeId, strategyId, StatusConstant.STRATEGY_CALL))
      .collect(Collectors.toList());
    routeStrategyDao.saveOrUpdateBatch(needSaveList);
    if (routeInfo.getStatus() == StatusConstant.PUBLISHED
      || routeInfo.getStatus() == StatusConstant.PUBLISH_STARTING) {
      try {
        msgSender.sendMsg(new RateLimitMessage(routeInfo.getId().toString(), "RELOAD"));
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return ResultUtil.success();

  }
}
