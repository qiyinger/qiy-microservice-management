package swust.qiy.microservice.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import swust.qiy.microservice.core.enums.ResultCodeEnum;
import swust.qiy.microservice.core.query.Criteria;
import swust.qiy.microservice.core.result.Result;
import swust.qiy.microservice.management.entity.ApiApply;
import swust.qiy.microservice.management.query.ApiApplyQuery;
import swust.qiy.microservice.management.service.ApiApplyService;

/**
 * @author qiying
 * @create 2018/12/10
 */
@RequestMapping("/api/apply")
@RestController
public class ApiApplyController {

    @Autowired
    private ApiApplyService apiApplyService;

    @RequestMapping("/list")
    @ResponseBody
    public Result list(@RequestBody ApiApplyQuery query) {
        if (query.getAsId() != null && query.getType() == null) {
            return new Result().fail(ResultCodeEnum.PARAM_ERROR, "申请类型不能为空");
        }
        Criteria<ApiApply> criteria = new Criteria<ApiApply>()
                .equal(ApiApplyQuery.Enum.ID, query.getId())
                .equal(ApiApplyQuery.Enum.APPLICANT, query.getApplicant())
                .gte(ApiApplyQuery.Enum.APPLY_TIME, query.getStartTime())
                .equal(ApiApplyQuery.Enum.STATUS, query.getStatus())
                .equal(ApiApplyQuery.Enum.TYPE, query.getType())
                .equal(ApiApplyQuery.Enum.AS_ID, query.getAsId())
                .lte(ApiApplyQuery.Enum.APPLY_TIME, query.getEndTime())
                .gte(ApiApplyQuery.Enum.MODIFY_TIME, query.getStartMTime())
                .lte(ApiApplyQuery.Enum.MODIFY_TIME, query.getEndMTime());
        return apiApplyService.findAll(criteria, query.getPage());
    }


    /**
     * 保存一个api
     *
     * @param apiApply
     * @return
     */
    @PostMapping("/save")
    @ResponseBody
    public Result save(@RequestBody ApiApply apiApply) {
        if (apiApply.getType() == null) {
            return new Result().fail(ResultCodeEnum.PARAM_ERROR, "申请类型不能为空");
        }
        if (apiApply.getAsId() == null) {
            return new Result().fail(ResultCodeEnum.PARAM_ERROR, "Api/微服务 Id不能为空");
        }
        return apiApplyService.save(apiApply);
    }

    /**
     * 更新api
     *
     * @param apiApply
     * @return
     */
    @PostMapping("/update")
    @ResponseBody
    public Result update(@RequestBody ApiApply apiApply) {
        if (apiApply.getType() == null) {
            return new Result().fail(ResultCodeEnum.PARAM_ERROR, "申请类型不能为空");
        }
        if (apiApply.getAsId() == null) {
            return new Result().fail(ResultCodeEnum.PARAM_ERROR, "Api/微服务 Id不能为空");
        }
        return apiApplyService.update(apiApply);
    }

}
