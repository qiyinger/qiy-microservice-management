package swust.qiy.microservice.management.configuration;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author qiying
 * @create 2019/1/23
 */
@Configuration
public class MyBatisPlusConfiguration {

  @Bean
  public ISqlInjector sqlInjector() {
    return new LogicSqlInjector();
  }

  @Bean
  public PaginationInterceptor paginationInterceptor() {
    PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
    paginationInterceptor.setDialectType(DbType.MYSQL.getDb());
    return paginationInterceptor;
  }

}
