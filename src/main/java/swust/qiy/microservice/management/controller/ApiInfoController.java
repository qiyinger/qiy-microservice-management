package swust.qiy.microservice.management.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import swust.qiy.microservice.core.enums.ResultCodeEnum;
import swust.qiy.microservice.core.page.PageImpl;
import swust.qiy.microservice.core.result.Result;
import swust.qiy.microservice.core.result.ResultUtil;
import swust.qiy.microservice.core.util.CommonUtil;
import swust.qiy.microservice.management.controller.from.BaseForm;
import swust.qiy.microservice.management.controller.from.api.ApiImportForm;
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

  @ApiOperation(value = "分页查询Api信息", httpMethod = "POST")
  @PostMapping("/page")
  @ResponseBody
  public Result<PageImpl<ApiInfo>> query(@RequestBody ApiInfoQuery query) {
    return apiInfoService.findPage(query);
  }

  @ApiOperation(value = "从swagger导入api信息", httpMethod = "POST")
  @PostMapping("/import")
  @ResponseBody
  public Result importApi(@RequestBody ApiImportForm form) {
    return apiInfoService.importApi(form.getUrl(), form.getServiceVersionId());
  }

  /**
   * 上线
   */
  @ApiOperation(value = "上线api接口", httpMethod = "POST")
  @RequestMapping("/online")
  @ResponseBody
  public Result online(@RequestParam("id") Integer id) {
    return apiInfoService.online(id);
  }

  /**
   * 下线
   */
  @ApiOperation(value = "下线api接口", httpMethod = "POST")
  @RequestMapping("/offline")
  @ResponseBody
  public Result offline(@RequestParam("id") Integer id) {
    return apiInfoService.offline(id);
  }
}
