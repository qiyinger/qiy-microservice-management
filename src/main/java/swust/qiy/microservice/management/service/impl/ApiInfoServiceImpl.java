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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swust.qiy.microservice.core.constant.StatusConstant;
import swust.qiy.microservice.core.enums.ResultCodeEnum;
import swust.qiy.microservice.core.result.Result;
import swust.qiy.microservice.core.result.ResultUtil;
import swust.qiy.microservice.core.service.impl.BaseServiceImpl;
import swust.qiy.microservice.core.util.HttpClientUtil;
import swust.qiy.microservice.core.util.StringUtil;
import swust.qiy.microservice.management.dao.ApiInfoDao;
import swust.qiy.microservice.management.dao.MicroserviceVersionDao;
import swust.qiy.microservice.management.entity.ApiInfo;
import swust.qiy.microservice.management.entity.MicroserviceVersion;
import swust.qiy.microservice.management.service.ApiInfoService;

/**
 * @author qiying
 */
@Service
public class ApiInfoServiceImpl extends BaseServiceImpl<ApiInfo> implements ApiInfoService {

  @Autowired
  private ApiInfoDao apiInfoDao;
  @Autowired
  private MicroserviceVersionDao microserviceVersionDao;
  private HttpClientUtil httpClientUtil = new HttpClientUtil();

  private String PROTOCOL = "Http";


  @Override
  public Result<Integer> importApi(String url, Integer serviceVersionId) {
    MicroserviceVersion version = microserviceVersionDao.selectById(serviceVersionId);
    if (version == null) {
      return ResultUtil.create(ResultCodeEnum.RECORD_NOT_EXIST);
    }
    String content = httpClientUtil.doGet(url);
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

  private ApiInfo createApiInfo(Operation operation, String methodObjName,
    MicroserviceVersion version,
    String fullPath, Swagger swagger) {
    ApiInfo api = new ApiInfo();
    api.setServiceVersionId(version.getId());
    api.setMicroserviceId(version.getMicroserviceId());
    api.setStatus(StatusConstant.DISABLE);
    api.setProtocol(PROTOCOL);
    api.setPath(fullPath);
    api.setName(operation.getSummary());
    api.setDescription(operation.getDescription());
    api.setMethod(methodObjName);
    api.setType(StatusConstant.INTRANET);

    return api;
  }

  @Override
  public Result online(Integer id) {
    ApiInfo apiInfo = apiInfoDao.selectById(id);
    if (StatusConstant.PENDING_STARTED != apiInfo.getStatus()) {
      return ResultUtil.create(ResultCodeEnum.INVALID_OPERATION);
    }
    apiInfo.setStatus(StatusConstant.STARTED);
    return super.update(apiInfo);
  }

  @Override
  public Result offline(Integer id) {
    ApiInfo apiInfo = apiInfoDao.selectById(id);
    if (StatusConstant.STARTED != apiInfo.getStatus()) {
      return ResultUtil.create(ResultCodeEnum.INVALID_OPERATION);
    }
    apiInfo.setStatus(StatusConstant.PENDING_STARTED);
    return super.update(apiInfo);
  }
}
