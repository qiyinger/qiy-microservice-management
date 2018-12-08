package swust.qiy.microservice.management.query;

import lombok.ToString;
import org.springframework.data.domain.PageRequest;
import org.springframework.format.annotation.DateTimeFormat;
import swust.qiy.microservice.core.enums.QueryEnum;
import swust.qiy.microservice.core.query.BaseQuery;
import swust.qiy.microservice.management.entity.System;

import java.time.LocalDateTime;

/**
 * @author qiying
 * @create 2018/12/6
 */
public class SystemQuery extends BaseQuery<System> {

    private Integer id;

    private String code;

    private String name;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private Integer status;

    private Integer userId;

    private String userName;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public enum SystemEnum implements QueryEnum<System> {
        ID("id"),
        CODE("code"),
        NAME("name"),
        CREATE_TIME("createTime"),
        STATUS("status"),
        USER_ID("user_id"),
        USER_NAME("user_name"),
        ;

        private String fieldName;

        SystemEnum(String fieldName) {
            this.fieldName = fieldName;
        }

        @Override
        public String getFieldName() {
            return fieldName;
        }
    }
}
