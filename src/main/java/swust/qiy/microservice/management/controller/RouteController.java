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

  @RequestMapping("/page")
  @ResponseBody
  public Result<PageImpl<Route>> query(@RequestBody RouteQuery query) {
    return routeService.findPage(query);
  }

  @RequestMapping("/save")
  @ResponseBody
  public Result save(@RequestBody Route route) {
    return routeService.save(route);
  }

  @RequestMapping("/update")
  @ResponseBody
  public Result update(@RequestBody Route route) {
    return routeService.update(route);
  }

  @RequestMapping("/delete")
  @ResponseBody
  public Result delete(@RequestBody BaseForm form) {
    if (CommonUtil.isEmpty(form.getIds())) {
      return ResultUtil.create(ResultCodeEnum.PARAM_ERROR);
    }
    return routeService.deleteByIds(form.getIds());
  }
}
