package swust.qiy.microservice.management.query;

import lombok.ToString;
import swust.qiy.microservice.core.enums.QueryEnum;
import swust.qiy.microservice.core.query.BaseQuery;
import swust.qiy.microservice.management.entity.Application;

import java.time.LocalDateTime;

/**
 * @author qiying
 * @create 2018/12/6
 */
@ToString(callSuper = true)
public class ApplicationQuery extends BaseQuery {

    private Integer id;

    private String code;

    private String name;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private Integer systemId;

    private Byte status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public enum ApplicationEnum implements QueryEnum<Application> {
        ID("id"),
        CODE("code"),
        NAME("name"),
        CREATE_TIME("create_time"),
        SYSTEM_ID("system_id"),
        STATUS("status"),
        ;

        private String fieldName;

        ApplicationEnum(String fieldName) {
            this.fieldName = fieldName;
        }

        @Override
        public String getFieldName() {
            return null;
        }
    }
}
