package swust.qiy.microservice.management.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import swust.qiy.microservice.core.enums.ResultCodeEnum;
import swust.qiy.microservice.core.query.Criteria;
import swust.qiy.microservice.core.result.Result;
import swust.qiy.microservice.management.entity.Application;
import swust.qiy.microservice.management.query.ApplicationQuery;
import swust.qiy.microservice.management.service.ApplicationService;
import swust.qiy.microservice.management.service.MicroserviceService;

/**
 * @author qiying
 * @create 2018/12/7
 */
@RequestMapping("/application")
@RestController
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    /**
     * 条件查询系统
     *
     * @param query
     * @return
     */
    @PostMapping(value = "/list")
    @ResponseBody
    public Result list(@RequestBody ApplicationQuery query) {
        Criteria<Application> criteria = new Criteria<Application>()
                .equal(ApplicationQuery.ApplicationEnum.CODE, query.getCode())
                .like(ApplicationQuery.ApplicationEnum.NAME, query.getName())
                .gte(ApplicationQuery.ApplicationEnum.CREATE_TIME, query.getStartTime())
                .lte(ApplicationQuery.ApplicationEnum.CREATE_TIME, query.getEndTime())
                .equal(ApplicationQuery.ApplicationEnum.STATUS, query.getStatus())
                .equal(ApplicationQuery.ApplicationEnum.SYSTEM_ID, query.getSystemId());
        return applicationService.findAll(criteria, query.getPage());
    }

    /**
     * 保存一个系统
     *
     * @param application
     * @return
     */
    @PostMapping("/save")
    @ResponseBody
    public Result save(@RequestBody Application application) {
        if (StringUtils.isEmpty(application.getCode())) {
            return new Result().fail(ResultCodeEnum.PARAM_ERROR, "应用编码不能为空");
        }
        if (StringUtils.isEmpty(application.getName())) {
            return new Result().fail(ResultCodeEnum.PARAM_ERROR, "应用名称不能为空");
        }
        if (application.getSystemId() == null) {
            return new Result().fail(ResultCodeEnum.PARAM_ERROR, "所属系统不能为空");
        }
        return applicationService.save(application);
    }

    /**
     * 更新系统
     *
     * @param application
     * @return
     */
    @PostMapping("/update")
    @ResponseBody
    public Result update(@RequestBody Application application) {
        if (application.getId() == null) {
            return new Result().fail(ResultCodeEnum.PARAM_ERROR, "所属系统不能为空");
        }
        return applicationService.update(application);
    }

}
