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
import swust.qiy.microservice.management.entity.Api;
import swust.qiy.microservice.management.query.ApiQuery;
import swust.qiy.microservice.management.service.ApiService;

/**
 * @author qiying
 */
@RequestMapping("/api")
@RestController
public class ApiController {

  @Autowired
  private ApiService apiService;

  @RequestMapping("/page")
  @ResponseBody
  public Result<PageImpl<Api>> query(@RequestBody ApiQuery query) {
    return apiService.findPage(query);
  }

  @RequestMapping("/save")
  @ResponseBody
  public Result save(@RequestBody Api api) {
    return apiService.save(api);
  }

  @RequestMapping("/update")
  @ResponseBody
  public Result update(@RequestBody Api api) {
    return apiService.update(api);
  }

  @RequestMapping("/delete")
  @ResponseBody
  public Result delete(@RequestBody BaseForm form) {
    if (CommonUtil.isEmpty(form.getIds())) {
      return ResultUtil.create(ResultCodeEnum.PARAM_ERROR);
    }
    return apiService.deleteByIds(form.getIds());
  }
}
