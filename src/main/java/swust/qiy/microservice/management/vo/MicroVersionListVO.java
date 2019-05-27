package swust.qiy.microservice.management.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author qiying
 * @create 2019/5/5
 */
@Data
@AllArgsConstructor
public class MicroVersionListVO {
  private Integer id;
  private String version;
  private Integer microserviceId;

}
