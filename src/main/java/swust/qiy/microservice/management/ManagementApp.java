package swust.qiy.microservice.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author qiying
 * @create 2018/11/9
 */
@EnableEurekaClient
@SpringBootApplication
public class ManagementApp {

    public static void main(String[] args) {
        SpringApplication.run(ManagementApp.class);
    }
}
