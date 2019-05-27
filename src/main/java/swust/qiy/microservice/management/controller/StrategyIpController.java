package swust.qiy.microservice.management.controller;

import io.swagger.annotations.ApiOperation;
import java.util.Set;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import swust.qiy.microservice.core.enums.ResultCodeEnum;
import swust.qiy.microservice.core.page.PageImpl;
import swust.qiy.microservice.core.result.Result;
import swust.qiy.microservice.core.result.ResultAsset;
import swust.qiy.microservice.core.result.ResultUtil;
import swust.qiy.microservice.core.util.CommonUtil;
import swust.qiy.microservice.management.controller.from.BaseForm;
import swust.qiy.microservice.management.controller.from.route.strategy.StrategyIpSaveForm;
import swust.qiy.microservice.management.controller.from.route.strategy.StrategyIpUpdateForm;
import swust.qiy.microservice.management.entity.StrategyIp;
import swust.qiy.microservice.management.query.StrategyIpQuery;
import swust.qiy.microservice.management.service.GatewayService;
import swust.qiy.microservice.management.service.RouteService;
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
  @Autowired
  private RouteService routeService;
  @Resource
  private SetOperations<String, String> redisSetOperations;

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
    Result gres = gatewayService.checkId(form.getGatewayId());
    ResultAsset.isTrue(gres.isSuccess(), ResultCodeEnum.PARAM_ERROR, "网关不存在");
    Result rres = routeService.checkId(form.getRouteId());
    ResultAsset.isTrue(rres.isSuccess(), ResultCodeEnum.PARAM_ERROR, "路由不存在");
    StrategyIp strategyIp = new StrategyIp();
    BeanUtils.copyProperties(form, strategyIp);
    Result<Integer> res = strategyIpService.save(strategyIp);
    ResultAsset.isTrue(res.isSuccess(), res.getCode(), res.getMessage());
    if (StringUtils.isNotBlank(form.getIpList())) {
      String[] ips = form.getIpList().split(",");
      for (String ip : ips) {
        if (StringUtils.isNotBlank(ip)) {
          redisSetOperations.add(form.getRouteId() + "_" + form.getType(), ip);
        }
      }
    }
    return ResultUtil.success();
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
    Result<Integer> result = strategyIpService.save(strategyIp);
    ResultAsset.isTrue(result.isSuccess(), res.getCode(), res.getMessage());
    String key = strategyIp.getRouteId() + "_" + strategyIp.getType();
    //临时方案，最好不要直接删除
    redisSetOperations.getOperations().delete(key);
    if (StringUtils.isNotBlank(form.getIpList())) {
      String[] ips = form.getIpList().split(",");
      for (String ip : ips) {
        if (StringUtils.isNotBlank(ip)) {
          redisSetOperations.add(key, ip);
        }
      }
    }
    return ResultUtil.success();
  }

  @ApiOperation(value = "删除Ip策略", httpMethod = "POST")
  @PostMapping("/delete")
  @ResponseBody
  public Result delete(@RequestBody BaseForm form) {
    ResultAsset.notNull(form.getId(), ResultCodeEnum.PARAM_ERROR);
    return strategyIpService.deleteById(form.getId());
  }

  @PostMapping("/test")
  public void test() {
    redisSetOperations.add("test", "1");
    redisSetOperations.add("test", "2");
    Set test = redisSetOperations.members("test");
    System.out.println(test);
  }
}
