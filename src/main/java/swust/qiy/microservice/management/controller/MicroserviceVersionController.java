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
import swust.qiy.microservice.core.enums.ResultCodeEnum;
import swust.qiy.microservice.core.page.PageImpl;
import swust.qiy.microservice.core.result.Result;
import swust.qiy.microservice.core.result.ResultUtil;
import swust.qiy.microservice.core.util.CommonUtil;
import swust.qiy.microservice.management.controller.from.BaseForm;
import swust.qiy.microservice.management.controller.from.microservice.version.VersionSaveForm;
import swust.qiy.microservice.management.controller.from.microservice.version.VersionUpdateForm;
import swust.qiy.microservice.management.entity.MicroserviceVersion;
import swust.qiy.microservice.management.query.MicroserviceVersionQuery;
import swust.qiy.microservice.management.service.MicroserviceVersionService;

/**
 * @author qiying
 */
@RequestMapping("/microserviceVersion")
@RestController
public class MicroserviceVersionController {

  @Autowired
  private MicroserviceVersionService microserviceVersionService;

  /**
   * 查询微服务版本
   */
  @ApiOperation(value = "分页查询微服务版本列表", httpMethod = "POST")
  @PostMapping("/page")
  @ResponseBody
  public Result<PageImpl<MicroserviceVersion>> query(@RequestBody MicroserviceVersionQuery query) {
    return microserviceVersionService.findPage(query);
  }

  /**
   * 添加版本
   */
  @ApiOperation(value = "添加微服务版本", httpMethod = "POST")
  @PostMapping("/save")
  @ResponseBody
  public Result save(@RequestBody VersionSaveForm form) {
    MicroserviceVersion microserviceVersion = new MicroserviceVersion();
    BeanUtils.copyProperties(form, microserviceVersion);
    return microserviceVersionService.save(microserviceVersion);
  }

  /**
   * 更新版本
   */
  @ApiOperation(value = "更新微服务版本", httpMethod = "POST")
  @PostMapping("/update")
  @ResponseBody
  public Result update(@RequestBody VersionUpdateForm form) {
    MicroserviceVersion microserviceVersion = new MicroserviceVersion();
    BeanUtils.copyProperties(form, microserviceVersion);
    return microserviceVersionService.update(microserviceVersion);
  }

  /**
   * 删除版本
   */
  @ApiOperation(value = "删除微服务版本", httpMethod = "POST")
  @PostMapping("/delete")
  @ResponseBody
  public Result delete(@RequestBody BaseForm form) {
    if (CommonUtil.isEmpty(form.getIds())) {
      return ResultUtil.create(ResultCodeEnum.PARAM_ERROR);
    }
    return microserviceVersionService.deleteByIds(form.getIds());
  }

  /**
   * 上线
   */
  @ApiOperation(value = "上线微服务版本", httpMethod = "POST")
  @PostMapping("/online")
  @ResponseBody
  public Result online(
    @ApiParam(required = true, value = "微服务版本id") @RequestParam("versionId") Integer versionId) {
    return microserviceVersionService.online(versionId);
  }

  /**
   * 下线
   */
  @ApiOperation(value = "下线微服务版本", httpMethod = "POST")
  @PostMapping("/offline")
  @ResponseBody
  public Result offline(
    @ApiParam(required = true, value = "微服务版本id") @RequestParam("versionId") Integer versionId) {
    return microserviceVersionService.offline(versionId);
  }
}
