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
import swust.qiy.microservice.management.entity.RouteStrategyCall;
import swust.qiy.microservice.management.query.RouteStrategyCallQuery;
import swust.qiy.microservice.management.service.RouteStrategyCallService;

/**
 * @author qiying
 */
@RequestMapping("/routeStrategyCall")
@RestController
public class RouteStrategyCallController {

  @Autowired
  private RouteStrategyCallService routeStrategyCallService;

  @RequestMapping("/page")
  @ResponseBody
  public Result<PageImpl<RouteStrategyCall>> query(@RequestBody RouteStrategyCallQuery query) {
    return routeStrategyCallService.findPage(query);
  }

  @RequestMapping("/save")
  @ResponseBody
  public Result save(@RequestBody RouteStrategyCall routeStrategyCall) {
    return routeStrategyCallService.save(routeStrategyCall);
  }

  @RequestMapping("/update")
  @ResponseBody
  public Result update(@RequestBody RouteStrategyCall routeStrategyCall) {
    return routeStrategyCallService.update(routeStrategyCall);
  }

  @RequestMapping("/delete")
  @ResponseBody
  public Result delete(@RequestBody BaseForm form) {
    if (CommonUtil.isEmpty(form.getIds())) {
      return ResultUtil.create(ResultCodeEnum.PARAM_ERROR);
    }
    return routeStrategyCallService.deleteByIds(form.getIds());
  }
}
