package swust.qiy.microservice.management.controller;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import swust.qiy.microservice.core.enums.ResultCodeEnum;
import swust.qiy.microservice.core.query.Criteria;
import swust.qiy.microservice.core.result.Result;
import swust.qiy.microservice.management.entity.System;
import swust.qiy.microservice.management.query.SystemQuery;
import swust.qiy.microservice.management.service.SystemService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * @author qiying
 * @create 2018/11/21
 */
@RestController
@RequestMapping("/system")
public class SystemController {

    private Logger log = LoggerFactory.getLogger(SystemController.class);

    @Autowired
    private SystemService systemService;

    /**
     * 条件查询分页列表
     *
     * @param query
     * @return
     */
    @PostMapping(value = "/list")
    @ResponseBody
    public Result list(@RequestBody SystemQuery query) {
        Criteria<System> criteria = new Criteria<System>()
                .equal(SystemQuery.Enum.CODE, query.getCode())
                .like(SystemQuery.Enum.NAME, query.getName())
                .gte(SystemQuery.Enum.CREATE_TIME, query.getStartTime())
                .lte(SystemQuery.Enum.CREATE_TIME, query.getEndTime())
                .equal(SystemQuery.Enum.STATUS, query.getStatus())
                .equal(SystemQuery.Enum.USER_NAME, query.getUserName());
        return systemService.findAll(criteria, query.getPage());
    }

    /**
     * 保存系统
     *
     * @param system
     * @return
     */
    @PostMapping(value = "/save")
    @ResponseBody
    public Result save(@RequestBody System system) {

        if (StringUtils.isEmpty(system.getName())) {
            return new Result().fail(ResultCodeEnum.PARAM_ERROR, "名称不能为空");
        }
        if (StringUtils.isEmpty(system.getCode())) {
            return new Result().fail(ResultCodeEnum.PARAM_ERROR, "编码不能为空");
        }
        return systemService.save(system);
    }

    /**
     * 更新系统
     *
     * @param system
     * @return
     */
    @PostMapping(value = "/update")
    @ResponseBody
    public Result update(@RequestBody System system) {
        if (system.getId() == null) {
            return new Result().fail(ResultCodeEnum.PARAM_ERROR, "ID不能为空");
        }
        return systemService.update(system);
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
        systemService.deleteByIds(ids);
        return new Result().success();
    }


    @RequestMapping("/test")
    @ResponseBody
    public void getPush(HttpServletRequest request, HttpServletResponse response, String sms_status,
                        String sms_reply, String voice_status, String flow_status) throws IOException {

        PrintWriter writer = response.getWriter();
        try {
            if (StringUtils.isNotBlank(sms_status)) {
                log.info("rcv sms_status:" + URLDecoder.decode(sms_status, "utf8"));
            }
            if (StringUtils.isNotBlank(sms_reply)) {
                log.info("rcv sms_reply:" + URLDecoder.decode(sms_reply, "utf8"));
            }
            if (StringUtils.isNotBlank(voice_status)) {
                log.info("rcv voice_status:" + URLDecoder.decode(voice_status, "utf8"));
            }
            if (StringUtils.isNotBlank(flow_status)) {
                log.info("rcv flow_status:" + URLDecoder.decode(flow_status, "utf8"));
            }
        } catch (UnsupportedEncodingException e) {
            log.error(String.valueOf(e));
        }

        //writer.write("\"SUCCESS\""); 错误写法
        //writer.write("\"0\""); 错误写法
        writer.write("SUCCESS");
        return;
    }

}
