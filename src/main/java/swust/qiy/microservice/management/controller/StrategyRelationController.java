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
import swust.qiy.microservice.management.entity.StrategyRelation;
import swust.qiy.microservice.management.query.StrategyRelationQuery;
import swust.qiy.microservice.management.service.StrategyRelationService;

/**
 * @author qiying
 */
@RequestMapping("/strategyRelation")
@RestController
public class StrategyRelationController {

  @Autowired
  private StrategyRelationService strategyRelationService;

  @RequestMapping("/page")
  @ResponseBody
  public Result<PageImpl<StrategyRelation>> query(@RequestBody StrategyRelationQuery query) {
    return strategyRelationService.findPage(query);
  }

  @RequestMapping("/save")
  @ResponseBody
  public Result save(@RequestBody StrategyRelation strategyRelation) {
    return strategyRelationService.save(strategyRelation);
  }

  @RequestMapping("/update")
  @ResponseBody
  public Result update(@RequestBody StrategyRelation strategyRelation) {
    return strategyRelationService.update(strategyRelation);
  }

  @RequestMapping("/delete")
  @ResponseBody
  public Result delete(@RequestBody BaseForm form) {
    if (CommonUtil.isEmpty(form.getIds())) {
      return ResultUtil.create(ResultCodeEnum.PARAM_ERROR);
    }
    return strategyRelationService.deleteByIds(form.getIds());
  }
}
