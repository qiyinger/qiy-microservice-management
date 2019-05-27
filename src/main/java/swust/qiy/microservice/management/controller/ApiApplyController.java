package swust.qiy.microservice.management.controller;

import io.swagger.annotations.Api;
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
import swust.qiy.microservice.core.enums.ResultCodeEnum;
import swust.qiy.microservice.core.page.PageImpl;
import swust.qiy.microservice.core.result.Result;
import swust.qiy.microservice.core.result.ResultAsset;
import swust.qiy.microservice.core.result.ResultUtil;
import swust.qiy.microservice.core.util.CommonUtil;
import swust.qiy.microservice.management.controller.from.BaseForm;
import swust.qiy.microservice.management.controller.from.api.apply.ApiApplyForm;
import swust.qiy.microservice.management.entity.ApiApply;
import swust.qiy.microservice.management.query.ApiApplyQuery;
import swust.qiy.microservice.management.service.ApiApplyService;

/**
 * @author qiying
 */
@Api(value = "/apiApply", description = "Api申请接口")
@RequestMapping("/apiApply")
@RestController
public class ApiApplyController {

  @Autowired
  private ApiApplyService apiApplyService;

  @ApiOperation(value = "分页查询Api申请列表", httpMethod = "POST")
  @PostMapping("/page")
  @ResponseBody
  public Result<PageImpl<ApiApply>> query(@RequestBody ApiApplyQuery query) {
    return apiApplyService.findPage(query);
  }

  @ApiOperation(value = "申请一个Api/微服务", httpMethod = "POST")
  @PostMapping("/apply")
  @ResponseBody
  public Result save(@RequestBody ApiApplyForm form) {
    ApiApply apiApply = new ApiApply();
    BeanUtils.copyProperties(form, apiApply);
    return apiApplyService.save(apiApply);
  }

  @ApiOperation(value = "删除申请Api", httpMethod = "POST")
  @PostMapping("/delete")
  @ResponseBody
  public Result delete(@RequestBody BaseForm form) {
    ResultAsset.notNull(form.getId(), ResultCodeEnum.PARAM_ERROR);
    return apiApplyService.deleteById(form.getId());
  }

  @ApiOperation(value = "通过申请", httpMethod = "POST")
  @PostMapping("/pass")
  @ResponseBody
  public Result pass(@ApiParam("申请记录id") @RequestParam("id") Integer id) {
    return apiApplyService.pass(id);
  }

  @ApiOperation(value = "拒接申请", httpMethod = "POST")
  @PostMapping("/refuse")
  @ResponseBody
  public Result refuse(@ApiParam("申请记录id") @RequestParam("id") Integer id) {
    return apiApplyService.refuse(id);
  }
}
