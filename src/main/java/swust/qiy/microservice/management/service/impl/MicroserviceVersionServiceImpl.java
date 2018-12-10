package swust.qiy.microservice.management.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swust.qiy.microservice.core.constant.StatusConstant;
import swust.qiy.microservice.core.enums.ResultCodeEnum;
import swust.qiy.microservice.core.query.Criteria;
import swust.qiy.microservice.core.result.Result;
import swust.qiy.microservice.core.service.impl.BaseServiceImpl;
import swust.qiy.microservice.management.dao.MicroserviceDao;
import swust.qiy.microservice.management.dao.MicroserviceVersionDao;
import swust.qiy.microservice.management.entity.MicroserviceVersion;
import swust.qiy.microservice.management.query.MicroserviceVersionQuery;
import swust.qiy.microservice.management.service.MicroserviceVersionService;

/**
 * @author qiying
 */
@Service
public class MicroserviceVersionServiceImpl extends BaseServiceImpl<MicroserviceVersion> implements MicroserviceVersionService {

    @Autowired
    private MicroserviceVersionDao microserviceVersionDao;
    @Autowired
    private MicroserviceDao microserviceDao;

    public Result<MicroserviceVersion> save(MicroserviceVersion microserviceVersion) {
        if (!isMicroserviceExist(microserviceVersion.getMicroserviceId())) {
            return new Result<>().fail(ResultCodeEnum.RECORD_NOT_EXIST, "微服务不存在");
        }
        if (isExist(microserviceVersion)) {
            return new Result<>().fail(ResultCodeEnum.RECORD_EXIST);
        }
        return super.save(microserviceVersion);
    }

    public Result<MicroserviceVersion> update(MicroserviceVersion microserviceVersion) {
        if (isExist(microserviceVersion)) {
            return new Result<>().fail(ResultCodeEnum.RECORD_EXIST);
        }
        return super.update(microserviceVersion);
    }

    public Result deleteByIds(String ids) {
        long count = microserviceVersionDao.count(new Criteria<MicroserviceVersion>()
                .equal(MicroserviceVersionQuery.Enum.ONLINE_STATUS, StatusConstant.ENABLE));
        if (count != 0) {
            return new Result().fail(ResultCodeEnum.INVALID_OPERATION);
        }
        return super.deleteByIds(ids);
    }

    private boolean isExist(MicroserviceVersion microserviceVersion) {
        long count = microserviceVersionDao.count(new Criteria<MicroserviceVersion>()
                .equal(MicroserviceVersionQuery.Enum.MICROSERVICE_ID, microserviceVersion.getMicroserviceId())
                .equal(MicroserviceVersionQuery.Enum.VERSION, microserviceVersion.getVersion()));
        return count != 0;
    }

    private boolean isMicroserviceExist(Integer microId) {
        return microserviceDao.existsById(microId);
    }
}
