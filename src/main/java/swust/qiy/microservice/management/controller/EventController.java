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
import swust.qiy.microservice.management.entity.Event;
import swust.qiy.microservice.management.query.EventQuery;
import swust.qiy.microservice.management.service.EventService;

/**
 * @author qiying
 */
@RequestMapping("/event")
@RestController
public class EventController {

  @Autowired
  private EventService eventService;

  @RequestMapping("/page")
  @ResponseBody
  public Result<PageImpl<Event>> query(@RequestBody EventQuery query) {
    return eventService.findPage(query);
  }

  @RequestMapping("/save")
  @ResponseBody
  public Result save(@RequestBody Event event) {
    return eventService.save(event);
  }

  @RequestMapping("/update")
  @ResponseBody
  public Result update(@RequestBody Event event) {
    return eventService.update(event);
  }

  @RequestMapping("/delete")
  @ResponseBody
  public Result delete(@RequestBody BaseForm form) {
    if (CommonUtil.isEmpty(form.getIds())) {
      return ResultUtil.create(ResultCodeEnum.PARAM_ERROR);
    }
    return eventService.deleteByIds(form.getIds());
  }
}
