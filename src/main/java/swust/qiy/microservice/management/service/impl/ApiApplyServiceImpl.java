package swust.qiy.microservice.management.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swust.qiy.microservice.core.constant.StatusConstant;
import swust.qiy.microservice.core.enums.ResultCodeEnum;
import swust.qiy.microservice.core.result.Result;
import swust.qiy.microservice.core.service.impl.BaseServiceImpl;
import swust.qiy.microservice.management.dao.ApiApplyDao;
import swust.qiy.microservice.management.dao.ApiDao;
import swust.qiy.microservice.management.dao.MicroserviceDao;
import swust.qiy.microservice.management.entity.ApiApply;
import swust.qiy.microservice.management.service.ApiApplyService;

/**
 * @author qiying
 */
@Service
public class ApiApplyServiceImpl extends BaseServiceImpl<ApiApply> implements ApiApplyService {

    @Autowired
    private ApiApplyDao apiApplyDao;
    @Autowired
    private MicroserviceDao microserviceDao;
    @Autowired
    private ApiDao apiDao;

    public Result<ApiApply> save(ApiApply apiApply) {
        if (apiApply.getType() == StatusConstant.MICRO_TYPE) {
            if (!microserviceDao.existsById(apiApply.getAsId())) {
                return new Result<>().fail(ResultCodeEnum.RECORD_NOT_EXIST, "微服务不存在");
            }
        } else if (apiApply.getType() == StatusConstant.API_TYPE) {
            if (apiDao.existsById(apiApply.getAsId())) {
                return new Result<>().fail(ResultCodeEnum.RECORD_NOT_EXIST, "Api不存在");
            }
        }
        return super.save(apiApply);
    }

    public Result<ApiApply> update(ApiApply apiApply) {
        return super.update(apiApply);
    }


}
