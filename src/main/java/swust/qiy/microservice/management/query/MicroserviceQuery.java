package swust.qiy.microservice.management.query;

import lombok.ToString;
import swust.qiy.microservice.core.enums.QueryEnum;
import swust.qiy.microservice.core.query.BaseQuery;
import swust.qiy.microservice.management.entity.Microservice;

import java.time.LocalDateTime;

/**
 * @author qiying
 * @create 2018/12/8
 */
public class MicroserviceQuery extends BaseQuery<Microservice> {

    private Integer id;

    private String code;

    private String name;

    private Integer appId;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public enum MicroserviceEnum implements QueryEnum<Microservice> {
        ID("id"),
        CODE("code"),
        NAME("name"),
        CREATE_TIME("createTime"),
        APP_ID("app_id"),
        ;

        private String field;

        MicroserviceEnum(String field) {
            this.field = field;
        }

        @Override
        public String getFieldName() {
            return field;
        }
    }

}
