package swust.qiy.microservice.management.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import swust.qiy.microservice.core.enums.ResultCodeEnum;
import swust.qiy.microservice.core.query.Criteria;
import swust.qiy.microservice.core.result.Result;
import swust.qiy.microservice.management.entity.Api;
import swust.qiy.microservice.management.query.ApiQuery;
import swust.qiy.microservice.management.service.ApiService;

/**
 * @author qiying
 * @create 2018/12/10
 */
@RequestMapping("/api")
@RestController
public class ApiController {

    @Autowired
    private ApiService apiService;

    @RequestMapping("/list")
    @ResponseBody
    public Result list(@RequestBody ApiQuery query) {
        Criteria<Api> criteria = new Criteria<Api>()
                .equal(ApiQuery.Enum.SERVICE_VERSION_ID, query.getServiceVersionId())
                .like(ApiQuery.Enum.PATH, query.getPath())
                .equal(ApiQuery.Enum.PROTOCOL, query.getProtocol())
                .equal(ApiQuery.Enum.TYPE, query.getType())
                .equal(ApiQuery.Enum.STATUS, query.getStatus())
                .equal(ApiQuery.Enum.INVALID, query.getInvalid());
        return apiService.findAll(criteria, query.getPage());
    }

    /**
     * 保存一个api
     *
     * @param api
     * @return
     */
    @PostMapping("/save")
    @ResponseBody
    public Result save(@RequestBody Api api) {
        if (StringUtils.isEmpty(api.getPath())) {
            return new Result().fail(ResultCodeEnum.PARAM_ERROR, "Api路径不能为空");
        }
        if (StringUtils.isEmpty(api.getName())) {
            return new Result().fail(ResultCodeEnum.PARAM_ERROR, "Api名称不能为空");
        }
        if (api.getServiceVersionId() == null) {
            return new Result().fail(ResultCodeEnum.PARAM_ERROR, "所属微服务版本不能为空");
        }
        return apiService.save(api);
    }

    /**
     * 更新api
     *
     * @param api
     * @return
     */
    @PostMapping("/update")
    @ResponseBody
    public Result update(@RequestBody Api api) {
        if (StringUtils.isEmpty(api.getPath())) {
            return new Result().fail(ResultCodeEnum.PARAM_ERROR, "Api路径不能为空");
        }
        if (StringUtils.isEmpty(api.getName())) {
            return new Result().fail(ResultCodeEnum.PARAM_ERROR, "Api名称不能为空");
        }
        if (api.getServiceVersionId() == null) {
            return new Result().fail(ResultCodeEnum.PARAM_ERROR, "所属微服务版本不能为空");
        }
        return apiService.update(api);
    }
}
