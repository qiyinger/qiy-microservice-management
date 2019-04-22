package swust.qiy.microservice.management.message;

import swust.qiy.microservice.sdk.mq.BaseMessage;

/**
 * @author qiying
 * @create 2019/4/20
 */
public class RouteMessage extends BaseMessage {

  public RouteMessage(String key, String body) {
    super("gateway", "route", key, body);
  }

}
