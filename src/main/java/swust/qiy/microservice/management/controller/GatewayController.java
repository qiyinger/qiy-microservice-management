package swust.qiy.microservice.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import swust.qiy.microservice.core.enums.ResultCodeEnum;
import swust.qiy.microservice.core.page.PageImpl;
import swust.qiy.microservice.core.result.Result;
import swust.qiy.microservice.core.result.ResultUtil;
import swust.qiy.microservice.core.util.CommonUtil;
import swust.qiy.microservice.management.controller.from.BaseForm;
import swust.qiy.microservice.management.entity.Gateway;
import swust.qiy.microservice.management.query.GatewayQuery;
import swust.qiy.microservice.management.service.GatewayService;

/**
 * @author qiying
 */
@RequestMapping("/gateway")
@RestController
public class GatewayController {

  @Autowired
  private GatewayService gatewayService;

  @RequestMapping("/page")
  @ResponseBody
  public Result<PageImpl<Gateway>> query(@RequestBody GatewayQuery query) {
    return gatewayService.findPage(query);
  }

  @RequestMapping("/save")
  @ResponseBody
  public Result save(@RequestBody Gateway gateway) {
    return gatewayService.save(gateway);
  }

  @RequestMapping("/update")
  @ResponseBody
  public Result update(@RequestBody Gateway gateway) {
    return gatewayService.update(gateway);
  }

  @RequestMapping("/delete")
  @ResponseBody
  public Result delete(@RequestBody BaseForm form) {
    if (CommonUtil.isEmpty(form.getIds())) {
      return ResultUtil.create(ResultCodeEnum.PARAM_ERROR);
    }
    return gatewayService.deleteByIds(form.getIds());
  }
}
