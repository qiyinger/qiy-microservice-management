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
import swust.qiy.microservice.management.entity.StrategyCall;
import swust.qiy.microservice.management.query.StrategyCallQuery;
import swust.qiy.microservice.management.service.StrategyCallService;

/**
 * @author qiying
 */
@RequestMapping("/strategyCall")
@RestController
public class StrategyCallController {

  @Autowired
  private StrategyCallService strategyCallService;

  @RequestMapping("/page")
  @ResponseBody
  public Result<PageImpl<StrategyCall>> query(@RequestBody StrategyCallQuery query) {
    return strategyCallService.findPage(query);
  }

  @RequestMapping("/save")
  @ResponseBody
  public Result save(@RequestBody StrategyCall strategyCall) {
    return strategyCallService.save(strategyCall);
  }

  @RequestMapping("/update")
  @ResponseBody
  public Result update(@RequestBody StrategyCall strategyCall) {
    return strategyCallService.update(strategyCall);
  }

  @RequestMapping("/delete")
  @ResponseBody
  public Result delete(@RequestBody BaseForm form) {
    if (CommonUtil.isEmpty(form.getIds())) {
      return ResultUtil.create(ResultCodeEnum.PARAM_ERROR);
    }
    return strategyCallService.deleteByIds(form.getIds());
  }
}