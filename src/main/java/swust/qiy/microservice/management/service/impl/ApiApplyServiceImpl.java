package swust.qiy.microservice.management.service.impl;

import com.baomidou.mybatisplus.extension.api.R;
import java.time.LocalDateTime;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Service;
import swust.qiy.microservice.core.constant.StatusConstant;
import swust.qiy.microservice.core.enums.ResultCodeEnum;
import swust.qiy.microservice.core.result.Result;
import swust.qiy.microservice.core.result.ResultAsset;
import swust.qiy.microservice.core.result.ResultUtil;
import swust.qiy.microservice.core.service.impl.BaseServiceImpl;
import swust.qiy.microservice.management.dao.ApiApplyDao;
import swust.qiy.microservice.management.dao.ApiInfoDao;
import swust.qiy.microservice.management.dao.MicroserviceVersionDao;
import swust.qiy.microservice.management.dao.SystemInfoDao;
import swust.qiy.microservice.management.entity.ApiApply;
import swust.qiy.microservice.management.entity.ApiInfo;
import swust.qiy.microservice.management.entity.MicroserviceVersion;
import swust.qiy.microservice.management.entity.SystemInfo;
import swust.qiy.microservice.management.service.ApiApplyService;

/**
 * @author qiying
 */
@Service
public class ApiApplyServiceImpl extends BaseServiceImpl<ApiApply> implements ApiApplyService {

  @Resource
  private ApiInfoDao apiInfoDao;
  @Resource
  private MicroserviceVersionDao microserviceVersionDao;
  @Resource
  private ApiApplyDao apiApplyDao;
  @Resource
  private SetOperations<String, String> redisSetOperations;
  @Resource
  private SystemInfoDao systemInfoDao;

  @Override
  public Result<Integer> save(ApiApply model) {
    ApiInfo info = apiInfoDao.selectById(model.getAsId());
    ResultAsset.notNull(info, ResultCodeEnum.RECORD_NOT_EXIST, "接口Id错误");
    SystemInfo systemInfo = systemInfoDao.selectById(model.getSystemId());
    ResultAsset.notNull(systemInfo, ResultCodeEnum.RECORD_NOT_EXIST, "系统Id错误");
    model.setType(StatusConstant.API_TYPE);
    model.setApplyTime(LocalDateTime.now());
    model.setModifyTime(LocalDateTime.now());
    return super.save(model);
  }

  @Override
  public Result pass(Integer id) {
    ApiApply apiApply = apiApplyDao.selectById(id);
    ResultAsset.notNull(apiApply, ResultCodeEnum.RECORD_NOT_EXIST);
    ResultAsset.isTrue(StatusConstant.CHECK_PENDING == apiApply.getStatus(),
      ResultCodeEnum.INVALID_OPERATION);
    apiApply.setStatus(StatusConstant.CHECK_PASS);
    this.update(apiApply);
    SystemInfo systemInfo = systemInfoDao.selectById(apiApply.getSystemId());
    ApiInfo apiInfo = apiInfoDao.selectById(apiApply.getAsId());
    redisSetOperations.add(systemInfo.getRsskey(), apiInfo.getPath());
    return ResultUtil.success();
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
