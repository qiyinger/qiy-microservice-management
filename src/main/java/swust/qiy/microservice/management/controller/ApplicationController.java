package swust.qiy.microservice.management.controller;

import io.swagger.annotations.ApiOperation;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
import swust.qiy.microservice.management.entity.Application;
import swust.qiy.microservice.management.query.ApplicationQuery;
import swust.qiy.microservice.management.service.ApplicationService;

/**
 * @author qiying
 */
@RequestMapping("/application")
@RestController
public class ApplicationController {

  @Autowired
  private ApplicationService applicationService;

  @ApiOperation(value = "分页查询应用信息", httpMethod = "POST")
  @PostMapping("/page")
  @ResponseBody
  public Result<PageImpl<Application>> query(@RequestBody ApplicationQuery query) {
    return applicationService.findPage(query);
  }

  @ApiOperation(value = "保存系统信息", httpMethod = "POST")
  @PostMapping("/save")
  @ResponseBody
  public Result save(@RequestBody Application application) {
    application.setCreateTime(LocalDateTime.now());
    application.setStatus((byte) 0);
    return applicationService.save(application);
  }

  @ApiOperation(value = "更新系统信息", httpMethod = "POST")
  @PostMapping("/update")
  @ResponseBody
  public Result update(@RequestBody Application application) {
    return applicationService.update(application);
  }

  @ApiOperation(value = "删除系统信息", httpMethod = "POST")
  @PostMapping("/delete")
  @ResponseBody
  public Result delete(@RequestBody BaseForm form) {
    if (CommonUtil.isEmpty(form.getIds())) {
      return ResultUtil.create(ResultCodeEnum.PARAM_ERROR);
    }
    return applicationService.deleteByIds(form.getIds());
  }
}
