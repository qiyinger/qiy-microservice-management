package swust.qiy.microservice.management.controller;

import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient.EurekaServiceInstance;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import swust.qiy.microservice.core.enums.ResultCodeEnum;
import swust.qiy.microservice.core.page.PageImpl;
import swust.qiy.microservice.core.result.Result;
import swust.qiy.microservice.core.result.ResultUtil;
import swust.qiy.microservice.management.controller.from.api.ApiImportForm;
import swust.qiy.microservice.management.controller.from.instance.InstanceSeachForm;
import swust.qiy.microservice.management.controller.vo.InstanceVO;
import swust.qiy.microservice.management.entity.ApiInfo;
import swust.qiy.microservice.management.entity.Microservice;
import swust.qiy.microservice.management.entity.MicroserviceVersion;
import swust.qiy.microservice.management.query.ApiInfoQuery;
import swust.qiy.microservice.management.service.ApiInfoService;
import swust.qiy.microservice.management.service.MicroserviceService;
import swust.qiy.microservice.management.service.MicroserviceVersionService;

/**
 * @author qiying
 */
@RequestMapping("/apiInfo")
@RestController
public class ApiInfoController {

  @Autowired
  private ApiInfoService apiInfoService;
  @Autowired
  private MicroserviceVersionService microserviceVersionService;
  @Autowired
  private MicroserviceService microserviceService;
  @Resource
  private EurekaDiscoveryClient discoveryClient;

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

}
