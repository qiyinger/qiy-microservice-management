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
import swust.qiy.microservice.management.entity.SystemInfo;
import swust.qiy.microservice.management.query.SystemInfoQuery;
import swust.qiy.microservice.management.service.SystemInfoService;

/**
 * @author qiying
 */
@RequestMapping("/systemInfo")
@RestController
public class SystemInfoController {

  @Autowired
  private SystemInfoService systemInfoService;

  @RequestMapping("/page")
  @ResponseBody
  public Result<PageImpl<SystemInfo>> query(@RequestBody SystemInfoQuery query) {
    return systemInfoService.findPage(query);
  }

  @RequestMapping("/save")
  @ResponseBody
  public Result save(@RequestBody SystemInfo systemInfo) {
    return systemInfoService.save(systemInfo);
  }

  @RequestMapping("/update")
  @ResponseBody
  public Result update(@RequestBody SystemInfo systemInfo) {
    return systemInfoService.update(systemInfo);
  }

  @RequestMapping("/delete")
  @ResponseBody
  public Result delete(@RequestBody BaseForm form) {
    if (CommonUtil.isEmpty(form.getIds())) {
      return ResultUtil.create(ResultCodeEnum.PARAM_ERROR);
    }
    return systemInfoService.deleteByIds(form.getIds());
  }
}
