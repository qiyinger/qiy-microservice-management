package swust.qiy.microservice.management.query;

import swust.qiy.microservice.core.enums.QueryEnum;
import swust.qiy.microservice.core.query.BaseQuery;
import swust.qiy.microservice.management.entity.ApiApply;

import java.time.LocalDateTime;

/**
 * @author qiying
 * @create 2018/12/10
 */
public class ApiApplyQuery extends BaseQuery {

    private Integer id;

    /**
     * 申请人
     */
    private String applicant;

    /**
     * 审核状态,0:等待审核;1:通过;2:打回
     */
    private Byte status;

    /**
     * 申请类型:service(微服务),api(接口)
     */
    private Byte type;

    /**
     * 申请时间
     */
    private LocalDateTime startTime;

    private LocalDateTime endTime;

    /**
     * 审核人
     */
    private String auditorName;

    /**
     * 接口/微服务版本标识
     */
    private Integer asId;

    /**
     * 修改时间
     */
    private LocalDateTime startMTime;

    private LocalDateTime endMTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
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

    public String getAuditorName() {
        return auditorName;
    }

    public void setAuditorName(String auditorName) {
        this.auditorName = auditorName;
    }

    public Integer getAsId() {
        return asId;
    }

    public void setAsId(Integer asId) {
        this.asId = asId;
    }

    public LocalDateTime getStartMTime() {
        return startMTime;
    }

    public void setStartMTime(LocalDateTime startMTime) {
        this.startMTime = startMTime;
    }

    public LocalDateTime getEndMTime() {
        return endMTime;
    }

    public void setEndMTime(LocalDateTime endMTime) {
        this.endMTime = endMTime;
    }

    public enum Enum implements QueryEnum<ApiApply> {
        ID("id"),
        APPLICANT("applicant"),
        STATUS("status"),
        TYPE("type"),
        APPLY_TIME("apply_time"),
        AUDITOR_NAME("auditor_name"),
        MODIFY_TIME("modify_time"),
        AS_ID("as_id"),
        ;

        private String fieldName;

        Enum(String fieldName) {
            this.fieldName = fieldName;
        }

        @Override
        public String getFieldName() {
            return null;
        }
    }


}
