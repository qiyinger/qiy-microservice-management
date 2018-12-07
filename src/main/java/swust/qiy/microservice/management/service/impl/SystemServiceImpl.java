package swust.qiy.microservice.management.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swust.qiy.microservice.core.enums.ResultCodeEnum;
import swust.qiy.microservice.core.query.Criteria;
import swust.qiy.microservice.core.result.Result;
import swust.qiy.microservice.core.service.impl.BaseServiceImpl;
import swust.qiy.microservice.management.dao.SystemDao;
import swust.qiy.microservice.management.entity.System;
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

    public Result<System> save(System system) {

        system.setStatus(DISABLE);
        system.setCreateTime(LocalDateTime.now());

        if (isExist(system)) {
            return new Result<>().fail(ResultCodeEnum.RECORD_EXIST);
        }
        return super.save(system);
    }

    public Result<System> update(System system) {

        if (isExist(system)) {
            return new Result<>().fail(ResultCodeEnum.RECORD_EXIST);
        }
        return super.update(system);
    }

    private boolean isExist(System system) {
        long count = systemDao.count(new Criteria<System>()
                .equal(SystemQuery.SystemEnum.CODE, system.getCode()));
        return count != 0;
    }

}
