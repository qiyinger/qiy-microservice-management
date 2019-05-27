package swust.qiy.microservice.management.service.impl;

import io.swagger.models.HttpMethod;
import io.swagger.models.Operation;
import io.swagger.models.Path;
import io.swagger.models.Swagger;
import io.swagger.parser.Swagger20Parser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient.EurekaServiceInstance;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import swust.qiy.microservice.core.enums.ResultCodeEnum;
import swust.qiy.microservice.core.result.Result;
import swust.qiy.microservice.core.result.ResultAsset;
import swust.qiy.microservice.core.result.ResultUtil;
import swust.qiy.microservice.core.service.impl.BaseServiceImpl;
import swust.qiy.microservice.core.util.HttpClientUtil;
import swust.qiy.microservice.core.util.StringUtil;
import swust.qiy.microservice.management.controller.from.instance.InstanceSeachForm;
import swust.qiy.microservice.management.controller.vo.InstanceVO;
import swust.qiy.microservice.management.dao.ApiInfoDao;
import swust.qiy.microservice.management.dao.MicroserviceDao;
import swust.qiy.microservice.management.dao.MicroserviceVersionDao;
import swust.qiy.microservice.management.entity.ApiInfo;
import swust.qiy.microservice.management.entity.Microservice;
import swust.qiy.microservice.management.entity.MicroserviceVersion;
import swust.qiy.microservice.management.service.ApiInfoService;

/**
 * @author qiying
 */
@Service
public class ApiInfoServiceImpl extends BaseServiceImpl<ApiInfo> implements ApiInfoService {

  @Resource
  private ApiInfoDao apiInfoDao;
  @Resource
  private MicroserviceVersionDao microserviceVersionDao;
  @Resource
  private MicroserviceDao microserviceDao;
  @Resource
  private EurekaDiscoveryClient discoveryClient;

  private HttpClientUtil httpClientUtil = new HttpClientUtil();

  private String PROTOCOL = "Http";


  @Override
  public Result<Integer> importApi(String url, Integer serviceVersionId) {
    MicroserviceVersion version = microserviceVersionDao.selectById(serviceVersionId);
    ResultAsset.notNull(version, ResultCodeEnum.RECORD_NOT_EXIST, "版本Id错误");
    if (StringUtils.isBlank(url)) {
      url = getUrl(version);
    }
    String content = HttpClientUtil.doGet(url);
    Swagger swagger = null;
    try {
      swagger = new Swagger20Parser().parse(content);
    } catch (IOException e) {
      e.printStackTrace();
    }
    String basePath = swagger.getBasePath();
    List<ApiInfo> apiInfos = new ArrayList<>();
    Set<Entry<String, Path>> paths = swagger.getPaths().entrySet();
    for (Entry<String, Path> path : paths) {
      Set<Entry<HttpMethod, Operation>> operations = path.getValue().getOperationMap().entrySet();
      for (Entry<HttpMethod, Operation> operation : operations) {
        ApiInfo apiInfo = createApiInfo(operation.getValue(), operation.getKey().name(), version,
          StringUtil.trimUrlSuffix(basePath, false) + path.getKey(), swagger);
        apiInfos.add(apiInfo);
      }
    }
    return this.saveOrUpdateBatch(apiInfos);

  }

  private String getUrl(MicroserviceVersion version) {
    Microservice microservice = microserviceDao.selectById(version.getMicroserviceId());
    List<ServiceInstance> list = discoveryClient.getInstances(microservice.getCode());
    List<InstanceVO> vos = list.stream()
      .filter(instance -> version.getVersion()
        .equals(instance.getMetadata().get("qiy.service.version")))
      .map(serviceInstance -> new InstanceVO((EurekaServiceInstance) serviceInstance))
      .collect(Collectors.toList());
    ResultAsset.notEmpty(vos, ResultCodeEnum.RECORD_EXIST, "该版本没有实例运行");
    return vos.get(0).getHomePageUrl() + "swagger-ui.html";
  }

  private ApiInfo createApiInfo(Operation operation, String methodObjName,
    MicroserviceVersion version,
    String fullPath, Swagger swagger) {
    ApiInfo api = new ApiInfo();
    api.setServiceVersionId(version.getId());
    api.setMicroserviceId(version.getMicroserviceId());
    api.setInvalid(false);
    api.setProtocol(PROTOCOL);
    api.setPath(fullPath);
    api.setName(operation.getSummary());
    api.setDescription(operation.getDescription());
    api.setMethod(methodObjName);
    return api;
  }
}
