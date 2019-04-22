package swust.qiy.microservice.management.configuration;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import swust.qiy.microservice.core.mybatis.injector.BatchInjector;

/**
 * @author qiying
 * @create 2019/1/23
 */
@Configuration
public class MyBatisPlusConfiguration {

  @Bean
  public ISqlInjector batchInjector() {
    return new BatchInjector();
  }

  @Bean
  public PaginationInterceptor paginationInterceptor() {
    PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
    paginationInterceptor.setDialectType(DbType.MYSQL.getDb());
    return paginationInterceptor;
  }

}
