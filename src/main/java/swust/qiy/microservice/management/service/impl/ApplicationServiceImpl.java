package swust.qiy.microservice.management.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swust.qiy.microservice.core.enums.ResultCodeEnum;
import swust.qiy.microservice.core.query.Criteria;
import swust.qiy.microservice.core.result.Result;
import swust.qiy.microservice.core.service.impl.BaseServiceImpl;
import swust.qiy.microservice.management.dao.ApplicationDao;
import swust.qiy.microservice.management.entity.Application;
import swust.qiy.microservice.management.query.ApplicationQuery;
import swust.qiy.microservice.management.service.ApplicationService;

/**
 * @author qiying
 */
@Service
public class ApplicationServiceImpl extends BaseServiceImpl<Application> implements ApplicationService {

    @Autowired
    private ApplicationDao applicationDao;

    public Result<Application> save(Application application) {

        if (isExist(application)) {
            return new Result<>().fail(ResultCodeEnum.RECORD_EXIST);
        }
        return super.save(application);

    }

    public Result<Application> update(Application application) {

        if (isExist(application)) {
            return new Result<>().fail(ResultCodeEnum.RECORD_EXIST);
        }
        return super.update(application);

    }

    public boolean isExist(Application application) {
        long count = applicationDao.count(new Criteria<Application>()
                .equal(ApplicationQuery.ApplicationEnum.CODE, application.getCode()));
        return count != 0;
    }
}
