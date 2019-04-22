package swust.qiy.microservice.management.service.impl;

import io.swagger.annotations.ApiOperation;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swust.qiy.microservice.core.constant.StatusConstant;
import swust.qiy.microservice.core.enums.ResultCodeEnum;
import swust.qiy.microservice.core.result.Result;
import swust.qiy.microservice.core.result.ResultUtil;
import swust.qiy.microservice.core.service.impl.BaseServiceImpl;
import swust.qiy.microservice.management.dao.ApiApplyDao;
import swust.qiy.microservice.management.dao.ApiInfoDao;
import swust.qiy.microservice.management.dao.MicroserviceVersionDao;
import swust.qiy.microservice.management.entity.ApiApply;
import swust.qiy.microservice.management.entity.ApiInfo;
import swust.qiy.microservice.management.entity.Microservice;
import swust.qiy.microservice.management.entity.MicroserviceVersion;
import swust.qiy.microservice.management.service.ApiApplyService;

/**
 * @author qiying
 */
@Service
public class ApiApplyServiceImpl extends BaseServiceImpl<ApiApply> implements ApiApplyService {

  @Autowired
  private ApiInfoDao apiInfoDao;
  @Autowired
  private MicroserviceVersionDao microserviceVersionDao;
  @Autowired
  private ApiApplyDao apiApplyDao;

  @Override
  public Result<Integer> save(ApiApply model) {
    if (StatusConstant.API_TYPE == model.getType()) {
      ApiInfo info = apiInfoDao.selectById(model.getAsId());
      if (info == null) {
        return ResultUtil.create(ResultCodeEnum.RECORD_NOT_EXIST);
      }
    } else {
      MicroserviceVersion version = microserviceVersionDao.selectById(model.getAsId());
      if (version == null) {
        return ResultUtil.create(ResultCodeEnum.RECORD_NOT_EXIST);
      }
    }
    model.setApplyTime(LocalDateTime.now());
    model.setModifyTime(LocalDateTime.now());
    return super.save(model);
  }

  @Override
  public Result pass(Integer id) {
    ApiApply apiApply = apiApplyDao.selectById(id);
    if (apiApply == null) {
      return ResultUtil.create(ResultCodeEnum.RECORD_NOT_EXIST);
    }
    if (StatusConstant.CHECK_PENDING != apiApply.getStatus()) {
      return ResultUtil.create(ResultCodeEnum.INVALID_OPERATION);
    }
    apiApply.setStatus(StatusConstant.CHECK_PASS);
    return this.update(apiApply);
  }

  @Override
  public Result refuse(Integer id) {
    ApiApply apiApply = apiApplyDao.selectById(id);
    if (apiApply == null) {
      return ResultUtil.create(ResultCodeEnum.RECORD_NOT_EXIST);
    }
    if (StatusConstant.CHECK_PENDING != apiApply.getStatus()) {
      return ResultUtil.create(ResultCodeEnum.INVALID_OPERATION);
    }
    apiApply.setStatus(StatusConstant.CHECK_REFUSE);
    return this.update(apiApply);
  }
}
