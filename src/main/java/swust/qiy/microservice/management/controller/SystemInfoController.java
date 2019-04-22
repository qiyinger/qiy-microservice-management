package swust.qiy.microservice.management.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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
import swust.qiy.microservice.management.dao.SystemInfoDao;
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
  @Autowired
  private SystemInfoDao systemInfoDao;

  @PostMapping("/page")
  @ResponseBody
  public Result<PageImpl<SystemInfo>> query(@RequestBody SystemInfoQuery query) {
    return systemInfoService.findPage(query);
  }

  @PostMapping("/save")
  @ResponseBody
  public Result save(@RequestBody SystemInfo systemInfo) {
    return systemInfoService.save(systemInfo);
  }

  @PostMapping("/update")
  @ResponseBody
  public Result update(@RequestBody SystemInfo systemInfo) {
    return systemInfoService.update(systemInfo);
  }

  @PostMapping("/delete")
  @ResponseBody
  public Result delete(@RequestBody BaseForm form) {
    if (CommonUtil.isEmpty(form.getIds())) {
      return ResultUtil.create(ResultCodeEnum.PARAM_ERROR);
    }
    return systemInfoService.deleteByIds(form.getIds());
  }

  @PostMapping("/batch")
  @ResponseBody
  public Result test() {
    SystemInfo systemInfo = new SystemInfo();
    systemInfo.setCode("testest");
    systemInfo.setName("批量测试");
    systemInfo.setCreateTime(LocalDateTime.now());
    List<SystemInfo> list = new ArrayList<>();
    list.add(systemInfo);
    systemInfoDao.saveOrUpdateBatch(list);
    return new Result();
  }
}
