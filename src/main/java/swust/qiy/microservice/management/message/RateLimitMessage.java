package swust.qiy.microservice.management.message;

import swust.qiy.microservice.sdk.mq.BaseMessage;

/**
 * @author qiying
 * @create 2019/4/20
 */
public class RateLimitMessage extends BaseMessage {


  public RateLimitMessage(String key, String body) {
    super("gateway", "rate_limit", key, body);
  }
}
