package swust.qiy.microservice.management.controller;

import io.swagger.annotations.ApiOperation;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import swust.qiy.microservice.core.enums.ResultCodeEnum;
import swust.qiy.microservice.core.page.PageImpl;
import swust.qiy.microservice.core.result.Result;
import swust.qiy.microservice.core.result.ResultAsset;
import swust.qiy.microservice.core.result.ResultUtil;
import swust.qiy.microservice.core.util.CommonUtil;
import swust.qiy.microservice.management.controller.from.BaseForm;
import swust.qiy.microservice.management.entity.Application;
import swust.qiy.microservice.management.query.ApplicationQuery;
import swust.qiy.microservice.management.service.ApplicationService;
import swust.qiy.microservice.management.vo.ApplicationListVO;

/**
 * @author qiying
 */
@RequestMapping("/application")
@RestController
public class ApplicationController {

  @Autowired
  private ApplicationService applicationService;


  @PostMapping("/selectList")
  @ResponseBody
  public Result<List<ApplicationListVO>> selectList(@RequestBody ApplicationQuery query) {
    Result<List<Application>> result = applicationService.findList(query);
    if (!result.isSuccess()) {
      return ResultUtil.create(result.getCode(), result.getMessage());
    }
    if (CollectionUtils.isNotEmpty(result.getData())) {
      List<ApplicationListVO> systemListVOS = result.getData().stream()
        .map(res -> new ApplicationListVO(res.getId(), res.getCode(), res.getName(),
          res.getSystemId()))
        .collect(Collectors.toList());
      return ResultUtil.success(systemListVOS);
    }
    return ResultUtil.success();
  }
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
    ResultAsset.notNull(form.getId(), ResultCodeEnum.PARAM_ERROR);
    return applicationService.deleteById(form.getId());
  }
}
