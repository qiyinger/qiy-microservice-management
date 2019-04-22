package swust.qiy.microservice.management.controller.vo;

import com.netflix.appinfo.InstanceInfo;
import java.util.Map;
import lombok.Data;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient.EurekaServiceInstance;

/**
 * @author qiying
 * @create 2019/3/26
 */
@Data
public class InstanceVO {

  /**
   * 实例id
   */
  private String instanceId;

  /**
   * 主机名
   */
  private String hostName;

  /**
   * 服务名
   */
  private String serviceName;

  /**
   * ip地址
   */
  private String ipAddr;

  /**
   * 启用状态
   */
  private InstanceInfo.InstanceStatus status;

  /**
   * 服务端口
   */
  private Integer port;

  /**
   * 服务主页
   */
  private String homePageUrl;

  /**
   * 最后操作时间
   */
  private Long lastUpdatedTimestamp;

  /**
   * 不知道, 英文不好
   */
  private Long lastDirtyTimestamp;

  /**
   * 操作类型
   */
  private String actionType;

  private Map<String, String> metadata;

  private String version;

  public InstanceVO(EurekaServiceInstance instance) {
    InstanceInfo instanceInfo = instance.getInstanceInfo();
    this.instanceId = instanceInfo.getInstanceId();
    this.hostName = instanceInfo.getHostName();
    this.ipAddr = instanceInfo.getIPAddr();
    this.status = instanceInfo.getStatus();
    this.port = instanceInfo.getPort();
    this.homePageUrl = instanceInfo.getHomePageUrl();
    this.lastUpdatedTimestamp = instanceInfo.getLastUpdatedTimestamp();
    this.lastDirtyTimestamp = instanceInfo.getLastDirtyTimestamp();
    this.metadata = instanceInfo.getMetadata();
    this.serviceName = instance.getServiceId();
    this.version = instance.getMetadata().get("qiy.service.version");
  }
}
