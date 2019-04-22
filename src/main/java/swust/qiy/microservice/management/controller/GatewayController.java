package swust.qiy.microservice.management.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import swust.qiy.microservice.core.enums.ResultCodeEnum;
import swust.qiy.microservice.core.page.PageImpl;
import swust.qiy.microservice.core.result.Result;
import swust.qiy.microservice.core.result.ResultUtil;
import swust.qiy.microservice.core.util.CommonUtil;
import swust.qiy.microservice.management.controller.from.BaseForm;
import swust.qiy.microservice.management.controller.from.gateway.GatewaySaveForm;
import swust.qiy.microservice.management.controller.from.gateway.GatewayUpdateForm;
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

  @ApiOperation(value = "分页查询网关列表", httpMethod = "POST")
  @PostMapping("/page")
  @ResponseBody
  public Result<PageImpl<Gateway>> query(@RequestBody GatewayQuery query) {
    return gatewayService.findPage(query);
  }

  @ApiOperation(value = "分页查询网关列表", httpMethod = "POST")
  @PostMapping("/save")
  @ResponseBody
  public Result save(@RequestBody GatewaySaveForm form) {
    Gateway gateway = new Gateway();
    BeanUtils.copyProperties(form, gateway);
    return gatewayService.save(gateway);
  }

  @ApiOperation(value = "更新网关实例", httpMethod = "POST")
  @PostMapping("/update")
  @ResponseBody
  public Result update(@RequestBody GatewayUpdateForm form) {
    Gateway gateway = new Gateway();
    BeanUtils.copyProperties(form, gateway);
    return gatewayService.update(gateway);
  }

  @ApiOperation(value = "删除网管实例", httpMethod = "POST")
  @PostMapping("/delete")
  @ResponseBody
  public Result delete(@RequestBody BaseForm form) {
    if (CommonUtil.isEmpty(form.getIds())) {
      return ResultUtil.create(ResultCodeEnum.PARAM_ERROR);
    }
    return gatewayService.deleteByIds(form.getIds());
  }

  /**
   * 停止实例
   */
  @ApiOperation(value = "停止所有实例", httpMethod = "POST")
  @PostMapping("/stop")
  @ResponseBody
  public Result shutdown(@RequestParam("id") Integer id) {
    return gatewayService.stop(id);
  }

  /**
   * 启用实例
   * @param id
   * @return
   */
  @ApiOperation(value = "启用实例", httpMethod = "POST")
  @PostMapping("/enable")
  @ResponseBody
  public Result enable(@RequestParam("id") Integer id) {
    return gatewayService.enable(id);
  }
}
