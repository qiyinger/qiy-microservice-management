package swust.qiy.microservice.management.controller;

import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import swust.qiy.microservice.core.constant.StatusConstant;
import swust.qiy.microservice.core.enums.ResultCodeEnum;
import swust.qiy.microservice.core.page.PageImpl;
import swust.qiy.microservice.core.result.Result;
import swust.qiy.microservice.core.result.ResultUtil;
import swust.qiy.microservice.core.util.CommonUtil;
import swust.qiy.microservice.management.controller.from.BaseForm;
import swust.qiy.microservice.management.controller.from.route.RouteStrategySaveForm;
import swust.qiy.microservice.management.controller.from.route.RouteStrategyUpdateForm;
import swust.qiy.microservice.management.entity.RouteStrategy;
import swust.qiy.microservice.management.query.RouteStrategyQuery;
import swust.qiy.microservice.management.service.RouteService;
import swust.qiy.microservice.management.service.RouteStrategyService;

/**
 * @author qiying
 */
@RequestMapping("/routeStrategy")
@RestController
public class RouteStrategyController {

  @Autowired
  private RouteStrategyService routeStrategyService;
  @Autowired
  private RouteService routeService;

  @PostMapping("/page")
  @ResponseBody
  public Result<PageImpl<RouteStrategy>> query(@RequestBody RouteStrategyQuery query) {
    return routeStrategyService.findPage(query);
  }

  @PostMapping("/call/save")
  @ResponseBody
  public Result saveCall(@RequestBody RouteStrategySaveForm form) {
    return routeStrategyService
      .save(form.getRouteId(), form.getStrategyIds(), StatusConstant.STRATEGY_CALL);
  }

  @PostMapping("/ip/save")
  @ResponseBody
  public Result saveIp(@RequestBody RouteStrategySaveForm form) {
    return routeStrategyService
      .save(form.getRouteId(), form.getStrategyIds(), StatusConstant.STRATEGY_IP);
  }

}
