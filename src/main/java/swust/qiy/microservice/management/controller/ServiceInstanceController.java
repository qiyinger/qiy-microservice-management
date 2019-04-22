package swust.qiy.microservice.management.controller;

import com.netflix.appinfo.InstanceInfo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient.EurekaServiceInstance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import swust.qiy.microservice.core.enums.ResultCodeEnum;
import swust.qiy.microservice.core.result.Result;
import swust.qiy.microservice.core.result.ResultUtil;
import swust.qiy.microservice.core.util.HttpClientUtil;
import swust.qiy.microservice.management.controller.from.instance.InstanceShutdownForm;
import swust.qiy.microservice.management.controller.vo.InstanceVO;
import swust.qiy.microservice.management.entity.Microservice;
import swust.qiy.microservice.management.entity.MicroserviceVersion;
import swust.qiy.microservice.management.service.MicroserviceService;
import swust.qiy.microservice.management.service.MicroserviceVersionService;

/**
 * @author qiying
 * @create 2019/3/26
 */
@RestController
@RequestMapping("/service")
public class ServiceInstanceController {

  @Resource
  private EurekaDiscoveryClient discoveryClient;
  @Autowired
  private MicroserviceService microserviceService;
  @Autowired
  private MicroserviceVersionService microserviceVersionService;

  public static final String SHUTDOWN_PATH = "actuator/shutdown";


  /**
   * 获取实例列表
   */
  @ApiOperation(value = "获取实例列表", httpMethod = "GET")
  @GetMapping("/instance/list")
  @ResponseBody
  public Result getInstances(
    @ApiParam(required = true, value = "微服务版本ID") @RequestParam("versionId") Integer versionId) {
    MicroserviceVersion microserviceVersion = microserviceVersionService.findById(versionId)
      .getData();
    if (microserviceVersion == null) {
      return ResultUtil.create(ResultCodeEnum.RECORD_NOT_EXIST);
    }
    Microservice microservice = microserviceService
      .findById(microserviceVersion.getMicroserviceId()).getData();
    List<ServiceInstance> list = discoveryClient.getInstances(microservice.getCode());
    List<InstanceVO> vos = list.stream()
      .filter(instance -> microserviceVersion.getVersion()
        .equals(instance.getMetadata().get("qiy.service.version")))
      .map(serviceInstance -> new InstanceVO((EurekaServiceInstance) serviceInstance))
      .collect(Collectors.toList());

    return ResultUtil.success(vos);
  }

  /**
   * 停止实例
   */
  @PostMapping("/instance/shutdown")
  @ResponseBody
  public Result shutdown(@RequestBody InstanceShutdownForm form) {
    List<ServiceInstance> instanceList = discoveryClient.getInstances(form.getServiceName());
    if (CollectionUtils.isEmpty(instanceList)) {
      return ResultUtil.create(ResultCodeEnum.RECORD_NOT_EXIST);
    }
    for (ServiceInstance instance : instanceList) {
      InstanceInfo info = ((EurekaServiceInstance) instance).getInstanceInfo();
      if (info.getInstanceId().equals(form.getInstanceId())) {
        return HttpClientUtil.doPost(info.getHomePageUrl() + SHUTDOWN_PATH, "");
      }
    }
    return ResultUtil.create(ResultCodeEnum.RECORD_NOT_EXIST);
  }
}
