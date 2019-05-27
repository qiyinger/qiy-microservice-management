package swust.qiy.microservice.management.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
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
import swust.qiy.microservice.management.controller.from.systemInfo.SystemSaveForm;
import swust.qiy.microservice.management.controller.from.systemInfo.SystemUpdateForm;
import swust.qiy.microservice.management.dao.SystemInfoDao;
import swust.qiy.microservice.management.entity.SystemInfo;
import swust.qiy.microservice.management.query.SystemInfoQuery;
import swust.qiy.microservice.management.service.SystemInfoService;
import swust.qiy.microservice.management.vo.SystemListVO;

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

  @PostMapping("/selectList")
  @ResponseBody
  public Result<List<SystemListVO>> selectList(@RequestBody SystemInfoQuery query) {
    Result<List<SystemInfo>> result = systemInfoService.findList(query);
    if (!result.isSuccess()) {
      return ResultUtil.create(result.getCode(), result.getMessage());
    }
    if (CollectionUtils.isNotEmpty(result.getData())) {
      List<SystemListVO> systemListVOS = result.getData().stream()
        .map(res -> new SystemListVO(res.getId(), res.getCode(), res.getName()))
        .collect(Collectors.toList());
      return ResultUtil.success(systemListVOS);
    }
    return ResultUtil.success();
  }

  @PostMapping("/page")
  @ResponseBody
  public Result<PageImpl<SystemInfo>> query(@RequestBody SystemInfoQuery query) {
    return systemInfoService.findPage(query);
  }

  @PostMapping("/save")
  @ResponseBody
  public Result save(@RequestBody SystemSaveForm form) {
    SystemInfo systemInfo = new SystemInfo();
    BeanUtils.copyProperties(form, systemInfo);
    return systemInfoService.save(systemInfo);
  }

  @PostMapping("/update")
  @ResponseBody
  public Result update(@RequestBody SystemUpdateForm form) {
    SystemInfo systemInfo = new SystemInfo();
    BeanUtils.copyProperties(form, systemInfo);
    return systemInfoService.update(systemInfo);
  }

  @PostMapping("/delete")
  @ResponseBody
  public Result delete(@RequestBody BaseForm form) {
    ResultAsset.notNull(form.getId(), ResultCodeEnum.PARAM_ERROR);
    return systemInfoService.deleteById(form.getId());
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
