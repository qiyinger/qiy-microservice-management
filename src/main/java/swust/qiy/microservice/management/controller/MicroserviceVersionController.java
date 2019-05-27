package swust.qiy.microservice.management.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.collections4.CollectionUtils;
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
import swust.qiy.microservice.management.controller.from.instance.InstanceSeachForm;
import swust.qiy.microservice.management.controller.from.microservice.version.VersionSaveForm;
import swust.qiy.microservice.management.controller.from.microservice.version.VersionUpdateForm;
import swust.qiy.microservice.management.entity.MicroserviceVersion;
import swust.qiy.microservice.management.query.MicroserviceVersionQuery;
import swust.qiy.microservice.management.service.MicroserviceVersionService;
import swust.qiy.microservice.management.vo.MicroVersionListVO;

/**
 * @author qiying
 */
@RequestMapping("/microserviceVersion")
@RestController
public class MicroserviceVersionController {

  @Autowired
  private MicroserviceVersionService microserviceVersionService;

  @PostMapping("/selectList")
  @ResponseBody
  public Result<List<MicroVersionListVO>> selectList(@RequestBody MicroserviceVersionQuery query) {
    Result<List<MicroserviceVersion>> result = microserviceVersionService.findList(query);
    if (!result.isSuccess()) {
      return ResultUtil.create(result.getCode(), result.getMessage());
    }
    if (CollectionUtils.isNotEmpty(result.getData())) {
      List<MicroVersionListVO> systemListVOS = result.getData().stream()
        .map(res -> new MicroVersionListVO(res.getId(), res.getVersion(), res.getMicroserviceId()))
        .collect(Collectors.toList());
      return ResultUtil.success(systemListVOS);
    }
    return ResultUtil.success();
  }

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
    ResultAsset.notNull(form.getId(), ResultCodeEnum.PARAM_ERROR);
    return microserviceVersionService.deleteById(form.getId());
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

  @ApiOperation(value = "发布微服务版本", httpMethod = "POST")
  @PostMapping("/publish")
  @ResponseBody
  public Result publish(@RequestBody InstanceSeachForm form) {
    ResultAsset.notNull(form.getVersionId(), ResultCodeEnum.PARAM_ERROR, "微服务版本Id不能为空");
    return microserviceVersionService.publish(form.getVersionId());
  }

  @ApiOperation(value = "发布微服务版本", httpMethod = "POST")
  @PostMapping("/unpublish")
  @ResponseBody
  public Result unpublish(@RequestBody InstanceSeachForm form) {
    ResultAsset.notNull(form.getVersionId(), ResultCodeEnum.PARAM_ERROR, "微服务版本Id不能为空");
    return microserviceVersionService.unpublish(form.getVersionId());
  }


}
