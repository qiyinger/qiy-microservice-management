package swust.qiy.microservice.management.service.impl;

import java.time.LocalDateTime;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swust.qiy.microservice.core.constant.StatusConstant;
import swust.qiy.microservice.core.enums.ResultCodeEnum;
import swust.qiy.microservice.core.result.Result;
import swust.qiy.microservice.core.result.ResultAsset;
import swust.qiy.microservice.core.result.ResultUtil;
import swust.qiy.microservice.core.service.impl.BaseServiceImpl;
import swust.qiy.microservice.management.MsgSender;
import swust.qiy.microservice.management.dao.ApplicationDao;
import swust.qiy.microservice.management.dao.MicroserviceDao;
import swust.qiy.microservice.management.dao.RouteDao;
import swust.qiy.microservice.management.dao.SystemInfoDao;
import swust.qiy.microservice.management.entity.Microservice;
import swust.qiy.microservice.management.entity.Route;
import swust.qiy.microservice.management.message.RouteMessage;
import swust.qiy.microservice.management.service.RouteService;

/**
 * @author qiying
 */
@Service
@Slf4j
public class RouteServiceImpl extends BaseServiceImpl<Route> implements RouteService {

  @Resource
  private SystemInfoDao systemInfoDao;
  @Resource
  private ApplicationDao applicationDao;
  @Resource
  private MicroserviceDao microserviceDao;
  @Resource
  private RouteDao routeDao;
  @Autowired
  private MsgSender msgSender;

  @Override
  public Result<Integer> save(Route model, boolean isPublish) {
    ResultAsset.notEmpty(model.getCode(), ResultCodeEnum.PARAM_ERROR, "路由参数不能为空");
    ResultAsset.notEmpty(model.getName(), ResultCodeEnum.PARAM_ERROR, "路由名称不能为空");
    ResultAsset.notNull(model.getBindServiceId(), ResultCodeEnum.PARAM_ERROR, "微服务Id不能为空");
    Microservice microservice = microserviceDao.selectById(model.getBindServiceId());
    ResultAsset.notNull(microservice, ResultCodeEnum.RECORD_NOT_EXIST, "微服务Id错误");
    model.setUri("lb://" + microservice.getCode());
    model.setCreateTime(LocalDateTime.now());
    model.setUpdateTime(LocalDateTime.now());
    Result<Integer> res = super.save(model);
    if (!res.isSuccess()) {
      return res;
    }
    if (isPublish) {
      return publish(model);
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
    return publish(route);
  }

  private Result publish(Route route) {
    ResultAsset.isTrue(route.getPublish() == StatusConstant.PUBLISHED
        || route.getPublish() == StatusConstant.PUBLISH_PENDING,
      ResultCodeEnum.INVALID_OPERATION, "路由正在发布或停止，请稍等");

    route.setPublish(StatusConstant.PUBLISH_STARTING);
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
    Route route = routeDao.selectById(id);
    ResultAsset.notNull(route, ResultCodeEnum.RECORD_NOT_EXIST);
    return stop(route);
  }

  private Result stop(Route route) {
    ResultAsset.isTrue(route.getPublish() == StatusConstant.PUBLISHED,
        ResultCodeEnum.INVALID_OPERATION, "路由未启动, 无法停止");
    try {
      msgSender.sendMsg(new RouteMessage(route.getCode(), "STOP"));
    } catch (Exception e) {
      log.error(e.getMessage());
      return ResultUtil.create(ResultCodeEnum.SYSTEM_ERROR, e.getMessage());
    }
    route.setPublish(StatusConstant.PUBLISH_STOPING);
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

  @Override
  public Result<Integer> update(Route model, boolean isPublish) {
    ResultAsset.notNull(model.getId(), ResultCodeEnum.PARAM_ERROR, "路由Id不能为空");
    Route route = routeDao.selectById(model.getId());
    ResultAsset.notNull(route, ResultCodeEnum.RECORD_NOT_EXIST, "路由Id错误");
    BeanUtils.copyProperties(model, route);
    route.setUpdateTime(LocalDateTime.now());
    Result<Integer> res = super.update(route);
    if (!res.isSuccess() || !isPublish) {
      return res;
    }
    return publish(route);
  }


  @Override
  public Result deleteById(int id) {
    Route route = routeDao.selectById(id);
    ResultAsset.notNull(route, ResultCodeEnum.RECORD_NOT_EXIST, "路由Id错误");
    if (route.getPublish() != StatusConstant.PUBLISH_PENDING) {
      return ResultUtil.create(ResultCodeEnum.INVALID_OPERATION, "请停止路由再删除");
    }
    return super.deleteById(id);
  }


}
