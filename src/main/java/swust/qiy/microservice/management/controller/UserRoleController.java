package swust.qiy.microservice.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
import swust.qiy.microservice.management.entity.UserRole;
import swust.qiy.microservice.management.query.UserRoleQuery;
import swust.qiy.microservice.management.service.UserRoleService;

/**
 * @author qiying
 */
@RequestMapping("/userRole")
@RestController
public class UserRoleController {

  @Autowired
  private UserRoleService userRoleService;

  @PostMapping("/page")
  @ResponseBody
  public Result<PageImpl<UserRole>> query(@RequestBody UserRoleQuery query) {
    return userRoleService.findPage(query);
  }

  @PostMapping("/save")
  @ResponseBody
  public Result save(@RequestBody UserRole userRole) {
    return userRoleService.save(userRole);
  }

  @PostMapping("/update")
  @ResponseBody
  public Result update(@RequestBody UserRole userRole) {
    return userRoleService.update(userRole);
  }

  @PostMapping("/delete")
  @ResponseBody
  public Result delete(@RequestBody BaseForm form) {
    ResultAsset.notNull(form.getId(), ResultCodeEnum.PARAM_ERROR);
    return userRoleService.deleteById(form.getId());
  }
}
