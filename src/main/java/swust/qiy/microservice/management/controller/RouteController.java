package swust.qiy.microservice.management.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import swust.qiy.microservice.core.enums.ResultCodeEnum;
import swust.qiy.microservice.core.page.PageImpl;
import swust.qiy.microservice.core.result.Result;
import swust.qiy.microservice.core.result.ResultAsset;
import swust.qiy.microservice.core.result.ResultUtil;
import swust.qiy.microservice.management.controller.from.route.RouteSaveForm;
import swust.qiy.microservice.management.controller.from.route.RouteUpdateForm;
import swust.qiy.microservice.management.dao.RouteDao;
import swust.qiy.microservice.management.entity.Route;
import swust.qiy.microservice.management.query.RouteQuery;
import swust.qiy.microservice.management.service.RouteService;
import swust.qiy.microservice.management.vo.RouteVO;

/**
 * @author qiying
 */
@RequestMapping("/route")
@RestController
public class RouteController {

  @Autowired
  private RouteService routeService;
  @Resource
  private RouteDao routeDao;

  @PostMapping("/{id}")
  public Result<RouteVO> getRouteById(@PathVariable("id") Integer id) {
    Route route = routeDao.selectById(id);
    ResultAsset.notNull(route, ResultCodeEnum.RECORD_NOT_EXIST, "路由Id错误");
    return ResultUtil.success(new RouteVO(route));
  }

  @ApiOperation(value = "分页查询路由信息", httpMethod = "POST")
  @PostMapping("/page")
  @ResponseBody
  public Result<PageImpl<RouteVO>> query(@RequestBody RouteQuery query) {
    Result<PageImpl<Route>> res = routeService.findPage(query);
    ResultAsset.isTrue(res.isSuccess(), ResultCodeEnum.SYSTEM_ERROR, res.getMessage());
    PageImpl<Route> page = res.getData();
    List<RouteVO> routeVOS = page.getRecords().stream().map(route -> new RouteVO(route))
      .collect(Collectors.toList());
    PageImpl<RouteVO> routeVOPage = new PageImpl<>();
    BeanUtils.copyProperties(page, routeVOPage, "records");
    return ResultUtil.success(routeVOPage.setRecords(routeVOS));
  }

  @ApiOperation(value = "保存路由信息", httpMethod = "POST")
  @PostMapping("/save")
  @ResponseBody
  public Result save(@RequestBody RouteSaveForm form) {
    Route route = new Route();
    BeanUtils.copyProperties(form, route, "filters", "predicates");
    setFiltersOrPredicates(route, form.getFilters(), true);
    setFiltersOrPredicates(route, form.getFilters(), false);
    return routeService.save(route,form.getPublish());
  }

  @ApiOperation(value = "更新filters", httpMethod = "POST")
  @PostMapping("/filters/update")
  @ResponseBody
  public Result updateFilters(@RequestBody RouteUpdateForm form) {
    Result result = routeService.checkId(routeDao, form.getId());
    if (!result.isSuccess()) {
      return result;
    }
    Route route = (Route) result.getData();
    setFiltersOrPredicates(route, form.getFilters(), true);
    return routeService.update(route, form.getPublish());
  }

  @ApiOperation(value = "更新predicates", httpMethod = "POST")
  @PostMapping("/predicates/update")
  @ResponseBody
  public Result updatePredicate(@RequestBody RouteUpdateForm form) {
    Result result = routeService.checkId(routeDao, form.getId());
    if (!result.isSuccess()) {
      return result;
    }
    Route route = (Route) result.getData();
    setFiltersOrPredicates(route, form.getPredicates(), false);
    return routeService.update(route, form.getPublish());
  }

  public void setFiltersOrPredicates(Route route, List<String> list, boolean isFilters) {
    String str = "";
    if (CollectionUtils.isNotEmpty(list)) {
      str = list.stream().filter(StringUtils::isNotBlank)
        .collect(Collectors.joining(";"));
    }
    if (isFilters) {
      route.setFilters(str);
    } else {
      route.setPredicates(str);
    }
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
}
