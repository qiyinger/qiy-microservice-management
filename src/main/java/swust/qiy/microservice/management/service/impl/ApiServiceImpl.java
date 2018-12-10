package swust.qiy.microservice.management.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swust.qiy.microservice.core.constant.StatusConstant;
import swust.qiy.microservice.core.enums.ResultCodeEnum;
import swust.qiy.microservice.core.query.Criteria;
import swust.qiy.microservice.core.result.Result;
import swust.qiy.microservice.core.service.impl.BaseServiceImpl;
import swust.qiy.microservice.management.dao.ApiDao;
import swust.qiy.microservice.management.dao.MicroserviceVersionDao;
import swust.qiy.microservice.management.entity.Api;
import swust.qiy.microservice.management.entity.MicroserviceVersion;
import swust.qiy.microservice.management.query.ApiQuery;
import swust.qiy.microservice.management.service.ApiService;

/**
 * @author qiying
 */
@Service
public class ApiServiceImpl extends BaseServiceImpl<Api> implements ApiService {

    @Autowired
    private ApiDao apiDao;
    @Autowired
    private MicroserviceVersionDao microserviceVersionDao;

    public Result<Api> save(Api api) {
        if (!isVersionExist(api.getServiceVersionId())) {
            return new Result().fail(ResultCodeEnum.RECORD_NOT_EXIST);
        }
        if (isExist(api)) {
            return new Result().fail(ResultCodeEnum.RECORD_EXIST);
        }
        api.setInvalid(false);
        api.setStatus(StatusConstant.DISABLE);
        return super.save(api);
    }

    public Result<Api> update(Api api) {
        if (isExist(api)) {
            return new Result<>().fail(ResultCodeEnum.RECORD_EXIST);
        }
        return super.update(api);
    }

    private boolean isVersionExist(Integer versionId) {
        return microserviceVersionDao.existsById(versionId);
    }

    private boolean isExist(Api api) {
        long count = apiDao.count(new Criteria<Api>()
                .equal(ApiQuery.Enum.NAME, api.getName()));
        return count != 0;
    }
}
