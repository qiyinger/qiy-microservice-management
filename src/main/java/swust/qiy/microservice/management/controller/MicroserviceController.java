package swust.qiy.microservice.management.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import swust.qiy.microservice.core.enums.ResultCodeEnum;
import swust.qiy.microservice.core.query.Criteria;
import swust.qiy.microservice.core.result.Result;
import swust.qiy.microservice.management.entity.Microservice;
import swust.qiy.microservice.management.query.MicroserviceQuery;
import swust.qiy.microservice.management.service.MicroserviceService;

/**
 * @author qiying
 * @create 2018/12/7
 */
@RequestMapping("/microservice")
@RestController
public class MicroserviceController {

    @Autowired
    private MicroserviceService microserviceService;

    /**
     * 条件查询系统
     *
     * @param query
     * @return
     */
    @PostMapping(value = "/list")
    @ResponseBody
    public Result list(@RequestBody MicroserviceQuery query) {
        Criteria<Microservice> criteria = new Criteria<Microservice>()
                .equal(MicroserviceQuery.MicroserviceEnum.CODE, query.getCode())
                .like(MicroserviceQuery.MicroserviceEnum.NAME, query.getName())
                .gte(MicroserviceQuery.MicroserviceEnum.CREATE_TIME, query.getStartTime())
                .lte(MicroserviceQuery.MicroserviceEnum.CREATE_TIME, query.getEndTime())
                .equal(MicroserviceQuery.MicroserviceEnum.APP_ID, query.getAppId());
        return microserviceService.findAll(criteria, query.getPage());
    }

    /**
     * 保存一个系统
     *
     * @param microservice
     * @return
     */
    @PostMapping("/save")
    @ResponseBody
    public Result save(@RequestBody Microservice microservice) {
        if (StringUtils.isEmpty(microservice.getCode())) {
            return new Result().fail(ResultCodeEnum.PARAM_ERROR, "微服务编码不能为空");
        }
        if (StringUtils.isEmpty(microservice.getName())) {
            return new Result().fail(ResultCodeEnum.PARAM_ERROR, "微服务名称不能为空");
        }
        if (microservice.getAppId() == null) {
            return new Result().fail(ResultCodeEnum.PARAM_ERROR, "所属应用不能为空");
        }
        return microserviceService.save(microservice);
    }

    /**
     * 更新系统
     *
     * @param microservice
     * @return
     */
    @PostMapping("/update")
    @ResponseBody
    public Result update(@RequestBody Microservice microservice) {
        return microserviceService.update(microservice);
    }

    /**
     * 删除
     *
     * @param ids
     * @return
     */
    @PostMapping(value = "/delete")
    @ResponseBody
    public Result delete(@RequestParam String ids) {
        microserviceService.deleteByIds(ids);
        return new Result().success();
    }

}
