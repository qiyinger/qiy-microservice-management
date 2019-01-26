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
import swust.qiy.microservice.management.entity.MicroserviceVersion;
import swust.qiy.microservice.management.query.MicroserviceVersionQuery;
import swust.qiy.microservice.management.service.MicroserviceVersionService;

/**
 * @author qiying
 */
@RequestMapping("/microserviceVersion")
@RestController
public class MicroserviceVersionController {

  @Autowired
  private MicroserviceVersionService microserviceVersionService;

  @RequestMapping("/page")
  @ResponseBody
  public Result<PageImpl<MicroserviceVersion>> query(@RequestBody MicroserviceVersionQuery query) {
    return microserviceVersionService.findPage(query);
  }

  @RequestMapping("/save")
  @ResponseBody
  public Result save(@RequestBody MicroserviceVersion microserviceVersion) {
    return microserviceVersionService.save(microserviceVersion);
  }

  @RequestMapping("/update")
  @ResponseBody
  public Result update(@RequestBody MicroserviceVersion microserviceVersion) {
    return microserviceVersionService.update(microserviceVersion);
  }

  @RequestMapping("/delete")
  @ResponseBody
  public Result delete(@RequestBody BaseForm form) {
    if (CommonUtil.isEmpty(form.getIds())) {
      return ResultUtil.create(ResultCodeEnum.PARAM_ERROR);
    }
    return microserviceVersionService.deleteByIds(form.getIds());
  }
}
