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
import swust.qiy.microservice.management.entity.StrategyIp;
import swust.qiy.microservice.management.query.StrategyIpQuery;
import swust.qiy.microservice.management.service.StrategyIpService;

/**
 * @author qiying
 */
@RequestMapping("/strategyIp")
@RestController
public class StrategyIpController {

  @Autowired
  private StrategyIpService strategyIpService;

  @RequestMapping("/page")
  @ResponseBody
  public Result<PageImpl<StrategyIp>> query(@RequestBody StrategyIpQuery query) {
    return strategyIpService.findPage(query);
  }

  @RequestMapping("/save")
  @ResponseBody
  public Result save(@RequestBody StrategyIp strategyIp) {
    return strategyIpService.save(strategyIp);
  }

  @RequestMapping("/update")
  @ResponseBody
  public Result update(@RequestBody StrategyIp strategyIp) {
    return strategyIpService.update(strategyIp);
  }

  @RequestMapping("/delete")
  @ResponseBody
  public Result delete(@RequestBody BaseForm form) {
    if (CommonUtil.isEmpty(form.getIds())) {
      return ResultUtil.create(ResultCodeEnum.PARAM_ERROR);
    }
    return strategyIpService.deleteByIds(form.getIds());
  }
}
