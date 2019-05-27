package swust.qiy.microservice.management.controller;

import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import swust.qiy.microservice.core.enums.ResultCodeEnum;
import swust.qiy.microservice.core.page.PageImpl;
import swust.qiy.microservice.core.result.Result;
import swust.qiy.microservice.core.result.ResultAsset;
import swust.qiy.microservice.core.result.ResultUtil;
import swust.qiy.microservice.core.util.CommonUtil;
import swust.qiy.microservice.management.controller.from.BaseForm;
import swust.qiy.microservice.management.controller.from.gateway.GatewaySaveForm;
import swust.qiy.microservice.management.controller.from.gateway.GatewayUpdateForm;
import swust.qiy.microservice.management.controller.vo.GatewayVO;
import swust.qiy.microservice.management.dao.GatewayDao;
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
  @Resource
  private GatewayDao gatewayDao;

  @PostMapping("/{id}")
  public Result<GatewayVO> getRouteById(@PathVariable("id") Integer id) {
    Gateway gateway = gatewayDao.selectById(id);
    if (gateway == null) {
      return ResultUtil.create(ResultCodeEnum.RECORD_NOT_EXIST);
    }
    return ResultUtil.success(new GatewayVO(gateway));
  }

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
    ResultAsset.notNull(form.getId(), ResultCodeEnum.PARAM_ERROR, "Id不能为空");
    return gatewayService.deleteById(form.getId());
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
