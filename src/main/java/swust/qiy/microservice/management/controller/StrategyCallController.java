package swust.qiy.microservice.management.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import swust.qiy.microservice.core.enums.ResultCodeEnum;
import swust.qiy.microservice.core.enums.TimeUnitEnum;
import swust.qiy.microservice.core.page.PageImpl;
import swust.qiy.microservice.core.result.Result;
import swust.qiy.microservice.core.result.ResultUtil;
import swust.qiy.microservice.core.util.CommonUtil;
import swust.qiy.microservice.management.controller.from.BaseForm;
import swust.qiy.microservice.management.controller.from.route.strategy.StrategyCallSaveForm;
import swust.qiy.microservice.management.controller.from.route.strategy.StrategyCallUpdateForm;
import swust.qiy.microservice.management.dao.GatewayDao;
import swust.qiy.microservice.management.dao.StrategyCallDao;
import swust.qiy.microservice.management.entity.StrategyCall;
import swust.qiy.microservice.management.query.StrategyCallQuery;
import swust.qiy.microservice.management.service.GatewayService;
import swust.qiy.microservice.management.service.StrategyCallService;

/**
 * @author qiying
 */
@RequestMapping("/strategyCall")
@RestController
public class StrategyCallController {

  @Autowired
  private StrategyCallService strategyCallService;
  @Autowired
  private GatewayService gatewayService;

  @ApiOperation(value = "分页查询调用策略", httpMethod = "POST")
  @PostMapping("/page")
  @ResponseBody
  public Result<PageImpl<StrategyCall>> query(@RequestBody StrategyCallQuery query) {
    return strategyCallService.findPage(query);
  }

  @ApiOperation(value = "保存调用策略", httpMethod = "POST")
  @PostMapping("/save")
  @ResponseBody
  public Result save(@RequestBody StrategyCallSaveForm form) {
    if (TimeUnitEnum.valueOf(form.getTimeUnit()) == null) {
      return ResultUtil.create(ResultCodeEnum.PARAM_ERROR, "时间单位错误");
    }
    Result res = gatewayService.checkId(form.getGatewayId());
    if (!res.isSuccess()) {
      return res;
    }
    StrategyCall strategyCall = new StrategyCall();
    BeanUtils.copyProperties(form, strategyCall);
    return strategyCallService.save(strategyCall);
  }

  @ApiOperation(value = "更新调用策略", httpMethod = "POST")
  @PostMapping("/update")
  @ResponseBody
  public Result update(@RequestBody StrategyCallUpdateForm form) {
    Result res = strategyCallService.checkId(form.getId());
    if (!res.isSuccess()) {
      return res;
    }
    StrategyCall strategyCall = (StrategyCall) res.getData();
    BeanUtils.copyProperties(form, strategyCall);
    return strategyCallService.update(strategyCall);
  }

  @ApiOperation(value = "删除调用策略", httpMethod = "POST")
  @PostMapping("/delete")
  @ResponseBody
  public Result delete(@RequestBody BaseForm form) {
    if (CommonUtil.isEmpty(form.getIds())) {
      return ResultUtil.create(ResultCodeEnum.PARAM_ERROR);
    }
    return strategyCallService.deleteByIds(form.getIds());
  }
}
