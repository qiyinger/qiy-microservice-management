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
import swust.qiy.microservice.management.entity.ApiInfo;
import swust.qiy.microservice.management.query.ApiInfoQuery;
import swust.qiy.microservice.management.service.ApiInfoService;

/**
 * @author qiying
 */
@RequestMapping("/apiInfo")
@RestController
public class ApiInfoController {

  @Autowired
  private ApiInfoService apiInfoService;

  @RequestMapping("/page")
  @ResponseBody
  public Result<PageImpl<ApiInfo>> query(@RequestBody ApiInfoQuery query) {
    return apiInfoService.findPage(query);
  }

  @RequestMapping("/save")
  @ResponseBody
  public Result save(@RequestBody ApiInfo apiInfo) {
    return apiInfoService.save(apiInfo);
  }

  @RequestMapping("/update")
  @ResponseBody
  public Result update(@RequestBody ApiInfo apiInfo) {
    return apiInfoService.update(apiInfo);
  }

  @RequestMapping("/delete")
  @ResponseBody
  public Result delete(@RequestBody BaseForm form) {
    if (CommonUtil.isEmpty(form.getIds())) {
      return ResultUtil.create(ResultCodeEnum.PARAM_ERROR);
    }
    return apiInfoService.deleteByIds(form.getIds());
  }
}
