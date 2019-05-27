package swust.qiy.microservice.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import swust.qiy.microservice.core.enums.ResultCodeEnum;
import swust.qiy.microservice.core.result.Result;
import swust.qiy.microservice.core.result.ResultAsset;
import swust.qiy.microservice.core.result.ResultUtil;
import swust.qiy.microservice.management.controller.from.instance.InstanceSeachForm;
import swust.qiy.microservice.management.entity.Microservice;
import swust.qiy.microservice.management.entity.MicroserviceVersion;
import swust.qiy.microservice.management.service.MicroserviceService;
import swust.qiy.microservice.management.service.MicroserviceVersionService;

/**
 * @author qiying
 * @create 2019/5/10
 */
@RestController
@RequestMapping("/apm")
public class ApmController {

  @Autowired
  private MicroserviceVersionService microserviceVersionService;
  @Autowired
  private MicroserviceService microserviceService;

  @Value("${skywalking.webapp.url}")
  private String skywalkingUrl;

  @PostMapping("/dashboard/url")
  @ResponseBody
  public Result<String> getDashboardUrl(@RequestBody InstanceSeachForm form) {
    ResultAsset.notNull(form.getVersionId(), ResultCodeEnum.PARAM_ERROR, "微服务版本Id不能为空");
    MicroserviceVersion microserviceVersion = microserviceVersionService.findById(form.getVersionId())
      .getData();
    ResultAsset.notNull(microserviceVersion, ResultCodeEnum.RECORD_NOT_EXIST, "微服务版本Id错误");
    Microservice microservice = microserviceService
      .findById(microserviceVersion.getMicroserviceId()).getData();
    return ResultUtil
      .success(skywalkingUrl + "service/" + microservice.getCode() + "-" + microserviceVersion.getVersion());
  }

  @PostMapping("/trace/url")
  @ResponseBody
  public Result<String> getTraceUrl(@RequestBody InstanceSeachForm form) {
    ResultAsset.notNull(form.getVersionId(), ResultCodeEnum.PARAM_ERROR, "微服务版本Id不能为空");
    MicroserviceVersion microserviceVersion = microserviceVersionService.findById(form.getVersionId())
      .getData();
    ResultAsset.notNull(microserviceVersion, ResultCodeEnum.RECORD_NOT_EXIST, "微服务版本Id错误");
    Microservice microservice = microserviceService
      .findById(microserviceVersion.getMicroserviceId()).getData();
    return ResultUtil
      .success(skywalkingUrl + "traces/" + microservice.getCode() + "-" + microserviceVersion.getVersion());
  }

}
