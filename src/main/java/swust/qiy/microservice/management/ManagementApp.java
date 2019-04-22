package swust.qiy.microservice.management;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author qiying
 * @create 2018/11/9
 */
@EnableEurekaClient
@SpringBootApplication
@ComponentScan(basePackages = {"swust.qiy.microservice.core", "swust.qiy.microservice.management"})
@MapperScan("swust.qiy.microservice.management.dao")
public class ManagementApp {

  public static void main(String[] args) {
    SpringApplication.run(ManagementApp.class);
  }
}
