package swust.qiy.microservice.management.configuration;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import swust.qiy.microservice.management.MsgSender;

/**
 * @author qiying
 * @create 2019/4/15
 */
@Configuration
@Slf4j
public class MqConfiguration {

  @Bean
  public DefaultMQProducer defaultMQProducer() throws MQClientException {
    DefaultMQProducer mqProducer = new DefaultMQProducer("micro_producer");
    mqProducer.setNamesrvAddr("localhost:9876");
    mqProducer.setInstanceName("management" );
    mqProducer.setVipChannelEnabled(false);
    mqProducer.setRetryTimesWhenSendAsyncFailed(10);
    mqProducer.start();
    log.info("RocketMq defaultProducer Started.");
    return mqProducer;
  }

  @Bean
  @ConditionalOnBean(DefaultMQProducer.class)
  public MsgSender msgSender(DefaultMQProducer defaultMQProducer) {
    return new MsgSender(defaultMQProducer);
  }
}
