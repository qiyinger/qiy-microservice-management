package swust.qiy.microservice.management.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swust.qiy.microservice.core.constant.StatusConstant;
import swust.qiy.microservice.core.enums.ResultCodeEnum;
import swust.qiy.microservice.core.query.Criteria;
import swust.qiy.microservice.core.result.Result;
import swust.qiy.microservice.core.service.impl.BaseServiceImpl;
import swust.qiy.microservice.management.dao.ApplicationDao;
import swust.qiy.microservice.management.dao.MicroserviceDao;
import swust.qiy.microservice.management.dao.SystemDao;
import swust.qiy.microservice.management.entity.Application;
import swust.qiy.microservice.management.entity.Microservice;
import swust.qiy.microservice.management.query.ApplicationQuery;
import swust.qiy.microservice.management.query.MicroserviceQuery;
import swust.qiy.microservice.management.service.ApplicationService;

import java.time.LocalDateTime;

/**
 * @author qiying
 */
@Service
public class ApplicationServiceImpl extends BaseServiceImpl<Application> implements ApplicationService {

    @Autowired
    private MicroserviceDao microserviceDao;
    @Autowired
    private ApplicationDao applicationDao;
    @Autowired
    private SystemDao systemDao;

    public Result<Application> save(Application application) {
        if (!isSystemExist(application.getSystemId())) {
            return new Result().fail(ResultCodeEnum.RECORD_NOT_EXIST, "系统不存在");
        }
        if (isExist(application)) {
            return new Result().fail(ResultCodeEnum.RECORD_EXIST);
        }
        application.setCreateTime(LocalDateTime.now());
        application.setIsDeleted(false);
        application.setStatus(StatusConstant.DISABLE);
        return super.save(application);
    }

    public Result<Application> update(Application application) {
        if (isExist(application)) {
            return new Result<>().fail(ResultCodeEnum.RECORD_EXIST);
        }
        return super.update(application);
    }

    public Result deleteByIds(String ids) {
        long count = microserviceDao.count(new Criteria<Microservice>()
                .in(MicroserviceQuery.Enum.APP_ID, ids));
        if (count != 0) {
            return new Result().fail(ResultCodeEnum.DISABLE_DELETE);
        }
        return super.deleteByIds(ids);
    }

    public boolean isSystemExist(int systemId) {
        return systemDao.existsById(systemId);
    }

    public boolean isExist(Application application) {
        long count = applicationDao.count(new Criteria<Application>()
                .equal(ApplicationQuery.Enum.CODE, application.getCode()));
        return count != 0;
    }
}
