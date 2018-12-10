package swust.qiy.microservice.management.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import swust.qiy.microservice.core.enums.ResultCodeEnum;
import swust.qiy.microservice.core.query.Criteria;
import swust.qiy.microservice.core.result.Result;
import swust.qiy.microservice.management.entity.MicroserviceVersion;
import swust.qiy.microservice.management.query.MicroserviceVersionQuery;
import swust.qiy.microservice.management.service.MicroserviceVersionService;

/**
 * @author qiying
 * @create 2018/12/9
 */
@RequestMapping("/microservice/version")
@RestController
public class MicroserviceVersionController {

    @Autowired
    private MicroserviceVersionService microserviceVersionService;

    /**
     * 条件查询系统
     *
     * @param query
     * @return
     */
    @PostMapping(value = "/list")
    @ResponseBody
    public Result list(@RequestBody MicroserviceVersionQuery query) {
        Criteria<MicroserviceVersion> criteria = new Criteria<MicroserviceVersion>()
                .equal(MicroserviceVersionQuery.Enum.VERSION, query.getVersion())
                .equal(MicroserviceVersionQuery.Enum.ONLINE_STATUS, query.getOnlineStatus())
                .gte(MicroserviceVersionQuery.Enum.CREATE_TIME, query.getStartTime())
                .lte(MicroserviceVersionQuery.Enum.CREATE_TIME, query.getEndTime())
                .equal(MicroserviceVersionQuery.Enum.MICROSERVICE_ID, query.getMicroserviceId());
        return microserviceVersionService.findAll(criteria, query.getPage());
    }

    /**
     * 保存一个系统
     *
     * @param microserviceVersion
     * @return
     */
    @PostMapping("/save")
    @ResponseBody
    public Result save(@RequestBody MicroserviceVersion microserviceVersion) {
        if (StringUtils.isEmpty(microserviceVersion.getVersion())) {
            return new Result().fail(ResultCodeEnum.PARAM_ERROR, "微服务版本不能为空");
        }
        if (microserviceVersion.getMicroserviceId() == null) {
            return new Result().fail(ResultCodeEnum.PARAM_ERROR, "所属微服务不能为空");
        }
        return microserviceVersionService.save(microserviceVersion);
    }

    /**
     * 更新系统
     *
     * @param microserviceVersion
     * @return
     */
    @PostMapping("/update")
    @ResponseBody
    public Result update(@RequestBody MicroserviceVersion microserviceVersion) {
        return microserviceVersionService.update(microserviceVersion);
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
        microserviceVersionService.deleteByIds(ids);
        return new Result().success();
    }

}
