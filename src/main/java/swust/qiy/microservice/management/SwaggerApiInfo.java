package swust.qiy.microservice.management;

import io.swagger.models.HttpMethod;
import io.swagger.models.Operation;
import lombok.Data;

/**
 * @author qiying
 * @create 2019/4/1
 */
@Data
public class SwaggerApiInfo {

  private String path;
  private HttpMethod httpMethod;
  private Operation operation;

}
