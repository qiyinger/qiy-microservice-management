package swust.qiy.microservice.management.service.impl;

import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swust.qiy.microservice.core.constant.StatusConstant;
import swust.qiy.microservice.core.dao.BaseDao;
import swust.qiy.microservice.core.enums.ResultCodeEnum;
import swust.qiy.microservice.core.result.Result;
import swust.qiy.microservice.core.result.ResultUtil;
import swust.qiy.microservice.core.service.impl.BaseServiceImpl;
import swust.qiy.microservice.management.dao.ApplicationDao;
import swust.qiy.microservice.management.dao.MicroserviceDao;
import swust.qiy.microservice.management.dao.RouteDao;
import swust.qiy.microservice.management.dao.SystemInfoDao;
import swust.qiy.microservice.management.entity.Route;
import swust.qiy.microservice.management.message.RouteMessage;
import swust.qiy.microservice.management.service.RouteService;
import swust.qiy.microservice.sdk.mq.MsgSender;

/**
 * @author qiying
 */
@Service
@Slf4j
public class RouteServiceImpl extends BaseServiceImpl<Route> implements RouteService {

  @Autowired
  private SystemInfoDao systemInfoDao;
  @Autowired
  private ApplicationDao applicationDao;
  @Autowired
  private MicroserviceDao microserviceDao;
  @Autowired
  private RouteDao routeDao;
  @Autowired
  private MsgSender msgSender;

  @Override
  public Result<Integer> save(Route model, boolean isPublish) {
    Result result = checkId(getBindDao(model.getBindType()), model.getId());
    if (!result.isSuccess()) {
      return result;
    }
    model.setCreateTime(LocalDateTime.now());
    model.setUpdateTime(LocalDateTime.now());
    Result<Integer> res = super.save(model);
    if (!res.isSuccess()) {
      return res;
    }
    if (isPublish) {
      try {
        msgSender.sendMsg(new RouteMessage(model.getCode(), "PUBLISH"));
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return ResultUtil.success();
  }

  @Override
  public Result publish(Integer id) {
    Result result = checkId(routeDao, id);
    if (!result.isSuccess()) {
      return result;
    }
    Route route = (Route) result.getData();
    // 设置为正在启动
    route.setStatus(StatusConstant.PUBLISH_STARTING);
    try {
      msgSender.sendMsg(new RouteMessage(route.getCode(), "PUBLISH"));
    } catch (Exception e) {
      log.error(e.getMessage());
      return ResultUtil.create(ResultCodeEnum.SYSTEM_ERROR, e.getMessage());
    }
    return super.update(route);
  }

  @Override
  public Result stop(Integer id) {
    Result result = checkId(routeDao, id);
    if (!result.isSuccess()) {
      return result;
    }
    Route route = (Route) result.getData();
    // 只能停止已启动的路由
    if (route.getStatus() != StatusConstant.PUBLISHED) {
      return ResultUtil.create(ResultCodeEnum.INVALID_OPERATION, "路由未启动, 无法停止");
    }
    try {
      msgSender.sendMsg(new RouteMessage(route.getCode(), "STOP"));
    } catch (Exception e) {
      log.error(e.getMessage());
      return ResultUtil.create(ResultCodeEnum.SYSTEM_ERROR, e.getMessage());
    }
    route.setStatus(StatusConstant.PUBLISH_STOPING);
    return super.update(route);
  }

  @Override
  public Result reload(Integer gatewayId) {
    try {
      msgSender.sendMsg(new RouteMessage("ALL", "RELOAD"));
    } catch (Exception e) {
      log.error(e.getMessage());
      return ResultUtil.create(ResultCodeEnum.SYSTEM_ERROR, e.getMessage());
    }
    routeDao.updateAllStatus(gatewayId, StatusConstant.PUBLISH_STARTING);
    return ResultUtil.success();
  }

  private BaseDao getBindDao(byte bindType) {
    BaseDao baseDao;
    if (StatusConstant.ROUTE_MICROSERVICE == bindType) {
      baseDao = microserviceDao;
    } else if (StatusConstant.ROUTE_APPLICATION == bindType) {
      baseDao = applicationDao;
    } else {
      baseDao = systemInfoDao;
    }
    return baseDao;
  }

  @Override
  public Result<Integer> update(Route model, boolean isPublish) {
    Result result = checkId(routeDao, model.getId());
    if (!result.isSuccess()) {
      return result;
    }
    Route route = (Route) result.getData();
    BeanUtils.copyProperties(model, route);
    route.setUpdateTime(LocalDateTime.now());
    Result<Integer> res = super.update(route);
    if (!res.isSuccess() || !isPublish) {
      return res;
    }
    // 如果是动态刷新修改, 必须是路由停止或者运行状态
    if (route.getStatus() == StatusConstant.PUBLISH_STARTING
      || route.getStatus() == StatusConstant.PUBLISH_STOPING) {
      return ResultUtil.create(ResultCodeEnum.INVALID_OPERATION, "路由正在启动, 请稍后重试");
    }
    try {
      msgSender.sendMsg(new RouteMessage(route.getCode(), "UPDATE"));
      route.setStatus(StatusConstant.PUBLISH_STARTING);
    } catch (Exception e) {
      log.error(e.getMessage());
      return ResultUtil.create(ResultCodeEnum.SYSTEM_ERROR, e.getMessage());
    }
    return super.update(route);
  }


  @Override
  public Result deleteById(int id) {
    Result result = checkId(routeDao, id);
    if (!result.isSuccess()) {
      return result;
    }
    Route route = (Route) result.getData();
    if (route.getStatus() != StatusConstant.PUBLISH_PENDING) {
      return ResultUtil.create(ResultCodeEnum.INVALID_OPERATION, "请停止路由再删除");
    }
    return super.deleteById(id);
  }

}
