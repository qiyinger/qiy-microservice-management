package swust.qiy.microservice.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import swust.qiy.microservice.core.enums.ResultCodeEnum;
import swust.qiy.microservice.core.page.PageImpl;
import swust.qiy.microservice.core.result.Result;
import swust.qiy.microservice.core.result.ResultUtil;
import swust.qiy.microservice.core.util.CommonUtil;
import swust.qiy.microservice.management.controller.from.BaseForm;
import swust.qiy.microservice.management.entity.RouteStrategyIp;
import swust.qiy.microservice.management.query.RouteStrategyIpQuery;
import swust.qiy.microservice.management.service.RouteStrategyIpService;

/**
 * @author qiying
 */
@RequestMapping("/routeStrategyIp")
@RestController
public class RouteStrategyIpController {

  @Autowired
  private RouteStrategyIpService routeStrategyIpService;

  @RequestMapping("/page")
  @ResponseBody
  public Result<PageImpl<RouteStrategyIp>> query(@RequestBody RouteStrategyIpQuery query) {
    return routeStrategyIpService.findPage(query);
  }

  @RequestMapping("/save")
  @ResponseBody
  public Result save(@RequestBody RouteStrategyIp routeStrategyIp) {
    return routeStrategyIpService.save(routeStrategyIp);
  }

  @RequestMapping("/update")
  @ResponseBody
  public Result update(@RequestBody RouteStrategyIp routeStrategyIp) {
    return routeStrategyIpService.update(routeStrategyIp);
  }

  @RequestMapping("/delete")
  @ResponseBody
  public Result delete(@RequestBody BaseForm form) {
    if (CommonUtil.isEmpty(form.getIds())) {
      return ResultUtil.create(ResultCodeEnum.PARAM_ERROR);
    }
    return routeStrategyIpService.deleteByIds(form.getIds());
  }
}
