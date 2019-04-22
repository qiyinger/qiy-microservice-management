package swust.qiy.microservice.management.service.impl;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swust.qiy.microservice.core.constant.StatusConstant;
import swust.qiy.microservice.core.enums.ResultCodeEnum;
import swust.qiy.microservice.core.result.Result;
import swust.qiy.microservice.core.result.ResultUtil;
import swust.qiy.microservice.core.service.impl.BaseServiceImpl;
import swust.qiy.microservice.core.util.CommonUtil;
import swust.qiy.microservice.management.dao.SystemInfoDao;
import swust.qiy.microservice.management.entity.Application;
import swust.qiy.microservice.management.entity.SystemInfo;
import swust.qiy.microservice.management.service.ApplicationService;

/**
 * @author qiying
 */
@Service
public class ApplicationServiceImpl extends BaseServiceImpl<Application>
  implements ApplicationService {

  @Autowired
  private SystemInfoDao systemInfoDao;

  @Override
  public Result save(Application model) {
    if (CommonUtil.isEmpty(model.getSystemId())) {
      return ResultUtil.create(ResultCodeEnum.PARAM_ERROR, "系统Id不能为空");
    }
    SystemInfo systemInfo = systemInfoDao.selectById(model.getSystemId());
    if (CommonUtil.isEmpty(systemInfo)) {
      return ResultUtil.create(ResultCodeEnum.PARAM_ERROR, "系统Id错误");
    }
    if (CommonUtil.isEmpty(model.getCode())) {
      return ResultUtil.create(ResultCodeEnum.PARAM_ERROR, "应用编号不能为空");
    }
    model.setAllCode(systemInfo.getCode() + "-" + model.getCode());
    model.setStatus(StatusConstant.DISABLE);
    model.setCreateTime(LocalDateTime.now());
    return super.save(model);
  }
}
