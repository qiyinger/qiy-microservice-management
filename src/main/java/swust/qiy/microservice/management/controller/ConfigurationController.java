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
import swust.qiy.microservice.management.entity.Configuration;
import swust.qiy.microservice.management.query.ConfigurationQuery;
import swust.qiy.microservice.management.service.ConfigurationService;

/**
 * @author qiying
 */
@RequestMapping("/configuration")
@RestController
public class ConfigurationController {

  @Autowired
  private ConfigurationService configurationService;

  @PostMapping("/page")
  @ResponseBody
  public Result<PageImpl<Configuration>> query(@RequestBody ConfigurationQuery query) {
    return configurationService.findPage(query);
  }

  @PostMapping("/save")
  @ResponseBody
  public Result save(@RequestBody Configuration configuration) {
    return configurationService.save(configuration);
  }

  @PostMapping("/update")
  @ResponseBody
  public Result update(@RequestBody Configuration configuration) {
    return configurationService.update(configuration);
  }

  @PostMapping("/delete")
  @ResponseBody
  public Result delete(@RequestBody BaseForm form) {
    if (CommonUtil.isEmpty(form.getIds())) {
      return ResultUtil.create(ResultCodeEnum.PARAM_ERROR);
    }
    return configurationService.deleteByIds(form.getIds());
  }
}
