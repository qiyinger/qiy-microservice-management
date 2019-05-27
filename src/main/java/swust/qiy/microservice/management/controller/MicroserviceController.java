package swust.qiy.microservice.management.controller;

import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
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
import swust.qiy.microservice.management.controller.from.microservice.MicroserviceSaveForm;
import swust.qiy.microservice.management.controller.from.microservice.MicroserviceUpdateForm;
import swust.qiy.microservice.management.entity.Microservice;
import swust.qiy.microservice.management.entity.MicroserviceVersion;
import swust.qiy.microservice.management.query.MicroserviceQuery;
import swust.qiy.microservice.management.service.MicroserviceService;
import swust.qiy.microservice.management.vo.MicroserviceListVO;

/**
 * @author qiying
 */
@RequestMapping("/microservice")
@RestController
public class MicroserviceController {

  public static final String DEFAULT_VERSION = "V1";

  @Autowired
  private MicroserviceService microserviceService;

  @PostMapping("/selectList")
  @ResponseBody
  public Result<List<MicroserviceListVO>> selectList(@RequestBody MicroserviceQuery query) {
    Result<List<Microservice>> result = microserviceService.findList(query);
    if (!result.isSuccess()) {
      return ResultUtil.create(result.getCode(), result.getMessage());
    }
    if (CollectionUtils.isNotEmpty(result.getData())) {
      List<MicroserviceListVO> systemListVOS = result.getData().stream()
        .map(res -> new MicroserviceListVO(res.getId(), res.getCode(), res.getName(),
          res.getAppId()))
        .collect(Collectors.toList());
      return ResultUtil.success(systemListVOS);
    }
    return ResultUtil.success();
  }

  /**
   * 查询
   */
  @ApiOperation(value = "分页查询微服务列表", httpMethod = "POST")
  @PostMapping("/page")
  @ResponseBody
  public Result<PageImpl<Microservice>> query(@RequestBody MicroserviceQuery query) {
    return microserviceService.findPage(query);
  }

  @ApiOperation(value = "保存微服务信息", httpMethod = "POST")
  @PostMapping("/save")
  @ResponseBody
  public Result save(@RequestBody MicroserviceSaveForm form) {
    Microservice microservice = new Microservice();
    BeanUtils.copyProperties(form, microservice);
    // 创建微服务时同时创建一个默认版本V1
    MicroserviceVersion version = new MicroserviceVersion();
    if (StringUtils.isBlank(form.getVersion())) {
      form.setVersion(DEFAULT_VERSION);
    }
    version.setVersion(form.getVersion());
    version.setDescription(form.getDescription());
    return microserviceService.save(microservice, version);
  }

  /**
   * 更新微服务
   */
  @ApiOperation(value = "修改微服务信息", httpMethod = "POST")
  @PostMapping("/update")
  @ResponseBody
  public Result update(@RequestBody MicroserviceUpdateForm form) {
    Microservice microservice = new Microservice();
    BeanUtils.copyProperties(form, microservice);
    return microserviceService.update(microservice);
  }

  public Result delete(@RequestBody BaseForm form) {
    ResultAsset.notNull(form.getId(), ResultCodeEnum.PARAM_ERROR);
    return microserviceService.deleteById(form.getId());
  }


}
