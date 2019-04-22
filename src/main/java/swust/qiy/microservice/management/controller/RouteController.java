package swust.qiy.microservice.management.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import swust.qiy.microservice.core.page.PageImpl;
import swust.qiy.microservice.core.result.Result;
import swust.qiy.microservice.management.controller.from.route.RouteSaveForm;
import swust.qiy.microservice.management.controller.from.route.RouteUpdateForm;
import swust.qiy.microservice.management.entity.Route;
import swust.qiy.microservice.management.query.RouteQuery;
import swust.qiy.microservice.management.service.RouteService;

/**
 * @author qiying
 */
@RequestMapping("/route")
@RestController
public class RouteController {

  @Autowired
  private RouteService routeService;

  @ApiOperation(value = "分页查询路由信息", httpMethod = "POST")
  @PostMapping("/page")
  @ResponseBody
  public Result<PageImpl<Route>> query(@RequestBody RouteQuery query) {
    return routeService.findPage(query);
  }

  @ApiOperation(value = "保存路由信息", httpMethod = "POST")
  @PostMapping("/save")
  @ResponseBody
  public Result save(@RequestBody RouteSaveForm form) {
    Route route = new Route();
    BeanUtils.copyProperties(form, route);
    return routeService.save(route,form.getPublish());
  }

  @ApiOperation(value = "修改路由信息", httpMethod = "POST")
  @PostMapping("/update")
  @ResponseBody
  public Result update(@RequestBody RouteUpdateForm form) {
    Route route = new Route();
    BeanUtils.copyProperties(form, route);
    return routeService.update(route, form.getPublish());
  }

  @ApiOperation(value = "删除路由信息", httpMethod = "POST")
  @PostMapping("/delete")
  @ResponseBody
  public Result delete(@ApiParam(required = true, value = "路由id") @RequestParam Integer id) {
    return routeService.deleteById(id);
  }

  @ApiOperation(value = "发布路由", httpMethod = "POST")
  @PostMapping("/publish")
  @ResponseBody
  public Result start(@ApiParam(required = true, value = "路由id") @RequestParam Integer id) {
    return routeService.publish(id);
  }

  @ApiOperation(value = "停止路由", httpMethod = "POST")
  @PostMapping("/stop")
  @ResponseBody
  public Result stop(@ApiParam(required = true, value = "路由id") @RequestParam Integer id) {
    return routeService.stop(id);
  }

  @ApiOperation(value = "重新加载所有路由", httpMethod = "POST")
  @PostMapping("/reload")
  @ResponseBody
  public Result reload(@ApiParam(required = true, value = "网关id") @RequestParam Integer gatewayId) {
    return routeService.reload(gatewayId);
  }

  @ApiOperation(value = "重新加载路由策略", httpMethod = "POST")
  @PostMapping("/reload/strategy")
  @ResponseBody
  public Result updateRouteStrategy(@RequestParam("id") Integer id) {
    return routeService.updateRouteStrategy(id);
  }
}
