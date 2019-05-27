package swust.qiy.microservice.management.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author qiying
 * @create 2019/5/4
 */
@Data
@AllArgsConstructor
public class ApplicationListVO {

  private Integer id;
  private String code;
  private String name;
  private Integer systemId;

}
