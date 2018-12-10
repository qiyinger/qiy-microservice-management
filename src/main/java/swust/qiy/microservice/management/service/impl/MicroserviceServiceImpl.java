package swust.qiy.microservice.management.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swust.qiy.microservice.core.enums.ResultCodeEnum;
import swust.qiy.microservice.core.query.Criteria;
import swust.qiy.microservice.core.result.Result;
import swust.qiy.microservice.core.service.impl.BaseServiceImpl;
import swust.qiy.microservice.management.dao.ApplicationDao;
import swust.qiy.microservice.management.dao.MicroserviceDao;
import swust.qiy.microservice.management.dao.MicroserviceVersionDao;
import swust.qiy.microservice.management.entity.Microservice;
import swust.qiy.microservice.management.entity.MicroserviceVersion;
import swust.qiy.microservice.management.query.MicroserviceQuery;
import swust.qiy.microservice.management.query.MicroserviceVersionQuery;
import swust.qiy.microservice.management.service.MicroserviceService;

import java.time.LocalDateTime;

/**
 * @author qiying
 */
@Service
public class MicroserviceServiceImpl extends BaseServiceImpl<Microservice> implements MicroserviceService {


    @Autowired
    private MicroserviceDao microserviceDao;
    @Autowired
    private ApplicationDao applicationDao;
    @Autowired
    private MicroserviceVersionDao microserviceVersionDao;

    public Result<Microservice> save(Microservice microservice) {
        if (!isAppExist(microservice.getAppId())) {
            return new Result<>().fail(ResultCodeEnum.RECORD_NOT_EXIST, "应用不存在");
        }
        if (isExist(microservice)) {
            return new Result<>().fail(ResultCodeEnum.RECORD_EXIST);
        }
        microservice.setCreateTime(LocalDateTime.now());
        microservice.setIsDeleted(false);
        return super.save(microservice);
    }

    public Result<Microservice> update(Microservice microservice) {
        if (isExist(microservice)) {
            return new Result<>().fail(ResultCodeEnum.RECORD_EXIST);
        }
        return super.save(microservice);
    }

    public Result deleteByIds(String ids) {
        long count = microserviceVersionDao.count(new Criteria<MicroserviceVersion>()
                .in(MicroserviceVersionQuery.Enum.MICROSERVICE_ID, ids));
        if (count != 0) {
            return new Result().fail(ResultCodeEnum.DISABLE_DELETE);
        }
        return super.deleteByIds(ids);
    }

    private boolean isExist(Microservice microservice) {
        long count = microserviceDao.count(new Criteria<Microservice>()
                .equal(MicroserviceQuery.Enum.CODE, microservice.getCode()));
        return count != 0;
    }


    private boolean isAppExist(Integer appId) {
        return applicationDao.existsById(appId);
    }
}
