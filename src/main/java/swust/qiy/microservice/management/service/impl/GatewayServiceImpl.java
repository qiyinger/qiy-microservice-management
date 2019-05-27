package swust.qiy.microservice.management.service.impl;

import static swust.qiy.microservice.management.controller.ServiceInstanceController.SHUTDOWN_PATH;

import com.netflix.appinfo.InstanceInfo;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient.EurekaServiceInstance;
import org.springframework.stereotype.Service;
import swust.qiy.microservice.core.constant.StatusConstant;
import swust.qiy.microservice.core.enums.ResultCodeEnum;
import swust.qiy.microservice.core.result.Result;
import swust.qiy.microservice.core.result.ResultUtil;
import swust.qiy.microservice.core.service.impl.BaseServiceImpl;
import swust.qiy.microservice.core.util.HttpClientUtil;
import swust.qiy.microservice.management.dao.GatewayDao;
import swust.qiy.microservice.management.dao.SystemInfoDao;
import swust.qiy.microservice.management.entity.Gateway;
import swust.qiy.microservice.management.entity.SystemInfo;
import swust.qiy.microservice.management.service.GatewayService;

/**
 * @author qiying
 */
@Service
public class GatewayServiceImpl extends BaseServiceImpl<Gateway> implements GatewayService {

  @Resource
  private EurekaDiscoveryClient discoveryClient;

  @Resource
  private SystemInfoDao systemInfoDao;
  @Resource
  private GatewayDao gatewayDao;


  @Override
  public Result<Integer> save(Gateway model) {
    Result result = checkId(systemInfoDao, model.getSystemId());
    if (!result.isSuccess()) {
      return result;
    }
    SystemInfo systemInfo = (SystemInfo) result.getData();
    model.setAllCode(systemInfo.getCode() + "-" + model.getCode());
    return super.save(model);
  }

  @Override
  public Result<Integer> update(Gateway model) {
    Result result = checkId(gatewayDao, model.getId());
    if (!result.isSuccess()) {
      return result;
    }
    Gateway gateway = (Gateway) result.getData();
    SystemInfo systemInfo = systemInfoDao.selectById(gateway.getId());
    gateway.setAllCode(systemInfo.getCode() + "-" + gateway.getCode());
    BeanUtils.copyProperties(model, gateway);
    return super.update(gateway);
  }

  @Override
  public Result enable(Integer gatewayId) {
    Result res = checkId(gatewayDao, gatewayId);
    if (!res.isSuccess()) {
      return res;
    }
    Gateway gateway = (Gateway) res.getData();
    if (gateway.getStatus() == StatusConstant.ENABLE) {
      return ResultUtil.create(ResultCodeEnum.INVALID_OPERATION, "网关已启用");
    }
    gateway.setStatus(StatusConstant.ENABLE);
    return this.update(gateway);
  }

  @Override
  public Result stop(Integer gatewayId) {
    Result res = checkId(gatewayDao, gatewayId);
    if (!res.isSuccess()) {
      return res;
    }
    Gateway gateway = (Gateway) res.getData();
    List<ServiceInstance> instanceList = discoveryClient.getInstances(gateway.getCode());
    if (CollectionUtils.isEmpty(instanceList)) {
      return ResultUtil.create(ResultCodeEnum.RECORD_NOT_EXIST, "没有可用的网关实例, 请启动网关");
    }
    for (ServiceInstance instance : instanceList) {
      InstanceInfo info = ((EurekaServiceInstance) instance).getInstanceInfo();
      HttpClientUtil.doPost(info.getHomePageUrl() + SHUTDOWN_PATH, "");
    }
    return ResultUtil.success();
  }
}
