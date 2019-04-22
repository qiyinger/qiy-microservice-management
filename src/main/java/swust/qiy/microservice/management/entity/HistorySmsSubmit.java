package swust.qiy.microservice.management.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

/**
 * @author qiying
 * @create 2019/4/12
 */
@TableName("ads_yp_user_region_sms_stat_daily")
@Getter
@Setter
public class HistorySmsSubmit {

  private Long id;

  /**
   * 格式为yyyyMMdd
   */
  private String day;

  /**
   * 用户id，如不按用户统计则为0
   */
  private long sid;

  /**
   * 父账号 id
   */
  private long pid;

  /**
   * 发送区域
   */
  private String area;

  /**
   * 供应商返回状态报告为成功的数量-计费条数
   */
  private long sucAmount = 0;


  /**
   * 供应商返回状态报告为失败的数量-计费条数
   */
  private long failAmount = 0;


  /**
   * 云片处理失败的条数：黑名单过滤，通道路由失败，系统未知异常-计费条数
   */
  private long failWithoutPayAmount = 0;
  /**
   * 未收到供应商返回的状态报告的短信数量-计费条数
   */
  private long unknownAmount = 0;

  /**
   * 用户提交到云片的总条数-计费条数
   *
   * totalAmount=sucAmount+failAmount+unknownAmount+failWithoutPayAmount
   */
  private long totalAmount = 0;


  /**
   * 供应商返回状态报告为成功的数量-提交条数
   */
  private long sucSubmit = 0;


  /**
   * 供应商返回状态报告为失败的数量-提交条数
   */
  private long failSubmit = 0;


  /**
   * 云片处理失败的条数：黑名单过滤，通道路由失败，系统未知异常-提交条数
   */
  private long failWithoutPaySubmit = 0;
  /**
   * 未收到供应商返回的状态报告的短信数量-提交条数
   */
  private long unknownSubmit = 0;

  /**
   * 用户提交到云片的总条数-提交条数
   *
   * totalSubmit=sucSubmit+failSubmit+unknownSubmit+failWithoutPaySubmit
   */
  private long totalSubmit = 0;

  private String sign;

}
