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
import swust.qiy.microservice.management.entity.Strategy;
import swust.qiy.microservice.management.query.StrategyQuery;
import swust.qiy.microservice.management.service.StrategyService;

/**
 * @author qiying
 */
@RequestMapping("/strategy")
@RestController
public class StrategyController {

  @Autowired
  private StrategyService strategyService;

  @RequestMapping("/page")
  @ResponseBody
  public Result<PageImpl<Strategy>> query(@RequestBody StrategyQuery query) {
    return strategyService.findPage(query);
  }

  @RequestMapping("/save")
  @ResponseBody
  public Result save(@RequestBody Strategy strategy) {
    return strategyService.save(strategy);
  }

  @RequestMapping("/update")
  @ResponseBody
  public Result update(@RequestBody Strategy strategy) {
    return strategyService.update(strategy);
  }

  @RequestMapping("/delete")
  @ResponseBody
  public Result delete(@RequestBody BaseForm form) {
    if (CommonUtil.isEmpty(form.getIds())) {
      return ResultUtil.create(ResultCodeEnum.PARAM_ERROR);
    }
    return strategyService.deleteByIds(form.getIds());
  }
}
