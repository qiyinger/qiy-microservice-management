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
import swust.qiy.microservice.management.entity.ApiApply;
import swust.qiy.microservice.management.query.ApiApplyQuery;
import swust.qiy.microservice.management.service.ApiApplyService;

/**
 * @author qiying
 */
@RequestMapping("/apiApply")
@RestController
public class ApiApplyController {

  @Autowired
  private ApiApplyService apiApplyService;

  @RequestMapping("/page")
  @ResponseBody
  public Result<PageImpl<ApiApply>> query(@RequestBody ApiApplyQuery query) {
    return apiApplyService.findPage(query);
  }

  @RequestMapping("/save")
  @ResponseBody
  public Result save(@RequestBody ApiApply apiApply) {
    return apiApplyService.save(apiApply);
  }

  @RequestMapping("/update")
  @ResponseBody
  public Result update(@RequestBody ApiApply apiApply) {
    return apiApplyService.update(apiApply);
  }

  @RequestMapping("/delete")
  @ResponseBody
  public Result delete(@RequestBody BaseForm form) {
    if (CommonUtil.isEmpty(form.getIds())) {
      return ResultUtil.create(ResultCodeEnum.PARAM_ERROR);
    }
    return apiApplyService.deleteByIds(form.getIds());
  }
}
