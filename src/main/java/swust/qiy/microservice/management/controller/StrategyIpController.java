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
import swust.qiy.microservice.core.page.PageImpl;
import swust.qiy.microservice.core.result.Result;
import swust.qiy.microservice.core.result.ResultUtil;
import swust.qiy.microservice.core.util.CommonUtil;
import swust.qiy.microservice.management.controller.from.BaseForm;
import swust.qiy.microservice.management.controller.from.route.strategy.StrategyIpSaveForm;
import swust.qiy.microservice.management.controller.from.route.strategy.StrategyIpUpdateForm;
import swust.qiy.microservice.management.entity.StrategyIp;
import swust.qiy.microservice.management.query.StrategyIpQuery;
import swust.qiy.microservice.management.service.GatewayService;
import swust.qiy.microservice.management.service.StrategyIpService;

/**
 * @author qiying
 */
@RequestMapping("/strategyIp")
@RestController
public class StrategyIpController {

  @Autowired
  private StrategyIpService strategyIpService;
  @Autowired
  private GatewayService gatewayService;

  @ApiOperation(value = "分页查询Ip策略", httpMethod = "POST")
  @PostMapping("/page")
  @ResponseBody
  public Result<PageImpl<StrategyIp>> query(@RequestBody StrategyIpQuery query) {
    return strategyIpService.findPage(query);
  }

  @ApiOperation(value = "保存Ip策略", httpMethod = "POST")
  @PostMapping("/save")
  @ResponseBody
  public Result save(@RequestBody StrategyIpSaveForm form) {
    Result res = gatewayService.checkId(form.getGatewayId());
    if (!res.isSuccess()) {
      return res;
    }
    StrategyIp strategyIp = new StrategyIp();
    BeanUtils.copyProperties(form, strategyIp);
    return strategyIpService.save(strategyIp);
  }

  @ApiOperation(value = "更新Ip策略", httpMethod = "POST")
  @PostMapping("/update")
  @ResponseBody
  public Result update(@RequestBody StrategyIpUpdateForm form) {
    Result res = strategyIpService.checkId(form.getId());
    if (!res.isSuccess()) {
      return res;
    }
    StrategyIp strategyIp = (StrategyIp) res.getData();
    BeanUtils.copyProperties(form, strategyIp);
    return strategyIpService.update(strategyIp);
  }

  @ApiOperation(value = "删除Ip策略", httpMethod = "POST")
  @PostMapping("/delete")
  @ResponseBody
  public Result delete(@RequestBody BaseForm form) {
    if (CommonUtil.isEmpty(form.getIds())) {
      return ResultUtil.create(ResultCodeEnum.PARAM_ERROR);
    }
    return strategyIpService.deleteByIds(form.getIds());
  }
}
