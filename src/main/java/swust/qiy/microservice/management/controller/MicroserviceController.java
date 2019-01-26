package swust.qiy.microservice.management.controller;

import java.time.LocalDateTime;
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
import swust.qiy.microservice.management.entity.Microservice;
import swust.qiy.microservice.management.query.MicroserviceQuery;
import swust.qiy.microservice.management.service.MicroserviceService;

/**
 * @author qiying
 */
@RequestMapping("/microservice")
@RestController
public class MicroserviceController {

  @Autowired
  private MicroserviceService microserviceService;

  @RequestMapping("/page")
  @ResponseBody
  public Result<PageImpl<Microservice>> query(@RequestBody MicroserviceQuery query) {
    return microserviceService.findPage(query);
  }

  @RequestMapping("/save")
  @ResponseBody
  public Result save(@RequestBody Microservice microservice) {
    return microserviceService.save(microservice);
  }

  @RequestMapping("/update")
  @ResponseBody
  public Result update(@RequestBody Microservice microservice) {
    return microserviceService.update(microservice);
  }

  @RequestMapping("/delete")
  @ResponseBody
  public Result delete(@RequestBody BaseForm form) {
    if (CommonUtil.isEmpty(form.getIds())) {
      return ResultUtil.create(ResultCodeEnum.PARAM_ERROR);
    }
    return microserviceService.deleteByIds(form.getIds());
  }
}
