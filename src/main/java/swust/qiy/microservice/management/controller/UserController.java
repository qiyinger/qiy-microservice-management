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
import swust.qiy.microservice.core.result.ResultUtil;
import swust.qiy.microservice.core.util.CommonUtil;
import swust.qiy.microservice.management.controller.from.BaseForm;
import swust.qiy.microservice.management.entity.User;
import swust.qiy.microservice.management.query.UserQuery;
import swust.qiy.microservice.management.service.UserService;

/**
 * @author qiying
 */
@RequestMapping("/user")
@RestController
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping("/page")
  @ResponseBody
  public Result<PageImpl<User>> query(@RequestBody UserQuery query) {
    return userService.findPage(query);
  }

  @PostMapping("/save")
  @ResponseBody
  public Result save(@RequestBody User user) {
    return userService.save(user);
  }

  @PostMapping("/update")
  @ResponseBody
  public Result update(@RequestBody User user) {
    return userService.update(user);
  }

  @PostMapping("/delete")
  @ResponseBody
  public Result delete(@RequestBody BaseForm form) {
    if (CommonUtil.isEmpty(form.getIds())) {
      return ResultUtil.create(ResultCodeEnum.PARAM_ERROR);
    }
    return userService.deleteByIds(form.getIds());
  }
}
