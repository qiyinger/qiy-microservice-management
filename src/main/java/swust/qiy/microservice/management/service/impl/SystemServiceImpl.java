package swust.qiy.microservice.management.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swust.qiy.microservice.core.enums.ResultCodeEnum;
import swust.qiy.microservice.core.query.Criteria;
import swust.qiy.microservice.core.result.Result;
import swust.qiy.microservice.core.service.impl.BaseServiceImpl;
import swust.qiy.microservice.management.dao.ApplicationDao;
import swust.qiy.microservice.management.dao.SystemDao;
import swust.qiy.microservice.management.entity.Application;
import swust.qiy.microservice.management.entity.System;
import swust.qiy.microservice.management.query.ApplicationQuery;
import swust.qiy.microservice.management.query.SystemQuery;
import swust.qiy.microservice.management.service.SystemService;

import java.time.LocalDateTime;

import static swust.qiy.microservice.core.constant.StatusConstant.DISABLE;

/**
 * @author qiying
 */
@Service
public class SystemServiceImpl extends BaseServiceImpl<System> implements SystemService {

    @Autowired
    private SystemDao systemDao;

    @Autowired
    private ApplicationDao applicationDao;

    public Result<System> save(System system) {

        if (isExist(system)) {
            return new Result<>().fail(ResultCodeEnum.RECORD_EXIST);
        }
        system.setCreateTime(LocalDateTime.now());
        system.setStatus(DISABLE);
        system.setIsDeleted(false);
        return super.save(system);
    }

    public Result<System> update(System system) {

        if (isExist(system)) {
            return new Result<>().fail(ResultCodeEnum.RECORD_EXIST);
        }
        return super.update(system);
    }

    public Result deleteByIds(String ids) {

        long count = applicationDao.count(new Criteria<Application>()
                .in(ApplicationQuery.Enum.SYSTEM_ID, ids));
        if (count != 0) {
            return new Result().fail(ResultCodeEnum.DISABLE_DELETE);
        }
        return super.deleteByIds(ids);

    }

    private boolean isExist(System system) {
        long count = systemDao.count(new Criteria<System>()
                .equal(SystemQuery.Enum.CODE, system.getCode()));
        return count != 0;
    }

}
