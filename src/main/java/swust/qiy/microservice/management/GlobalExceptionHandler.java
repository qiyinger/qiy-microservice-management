package swust.qiy.microservice.management;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import swust.qiy.microservice.core.enums.ResultCodeEnum;
import swust.qiy.microservice.core.exception.ResultIllegalException;
import swust.qiy.microservice.core.result.Result;
import swust.qiy.microservice.core.result.ResultUtil;

/**
 * Created by www1 on 18/2/22. <p/> 返回json请参考 https://mp.weixin.qq.com/s?__biz=MzAxODcyNjEzNQ==&mid=2247484089&idx=2&sn=69c9778c702534e78093756946356635&chksm=9bd0af21aca72637ec9d3975223725461f4f02dedb35b0c55ca64d3a6fe792e8070dfa8b78e0&scene=21#wechat_redirect.
 */
@RestControllerAdvice("swust.qiy.microservice.management.controller")
public class GlobalExceptionHandler {

  private static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

  /**
   * 业务异常处理.
   *
   * @param exeception 异常.
   */
  @ExceptionHandler(ResultIllegalException.class)
  @ResponseBody
  public Result resultExeceptionHandler(ResultIllegalException exeception) {
    logger.warn("ResultIllegalExeception {} {}", exeception.getCode(), exeception.getMessage());
    return ResultUtil.create(exeception.getCode(), exeception.getMessage());
  }


  @ExceptionHandler(Exception.class)
  @ResponseBody
  public Result defaultErrorHandler(HttpServletRequest req, Exception ex) {
    logger.error("unknow exception", ex);
    return ResultUtil.create(ResultCodeEnum.UNKNOWN);
  }


}
