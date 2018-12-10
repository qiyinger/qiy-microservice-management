package swust.qiy.microservice.management.query;

import swust.qiy.microservice.core.enums.QueryEnum;
import swust.qiy.microservice.core.query.BaseQuery;
import swust.qiy.microservice.management.entity.MicroserviceVersion;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author qiying
 * @create 2018/12/9
 */
public class MicroserviceVersionQuery extends BaseQuery<MicroserviceVersion> {

    private String version;

    private Byte onlineStatus;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private Integer microserviceId;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Byte getOnlineStatus() {
        return onlineStatus;
    }

    public void setOnlineStatus(Byte onlineStatus) {
        this.onlineStatus = onlineStatus;
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

    public Integer getMicroserviceId() {
        return microserviceId;
    }

    public void setMicroserviceId(Integer microserviceId) {
        this.microserviceId = microserviceId;
    }

    public enum Enum implements QueryEnum<MicroserviceVersion> {
        VERSION("version"),
        ONLINE_STATUS("online_status"),
        CREATE_TIME("create_time"),
        MICROSERVICE_ID("microservice_id"),
        ;

        private String fieldName;

        Enum(String fieldName) {
            this.fieldName = fieldName;
        }

        @Override
        public String getFieldName() {
            return fieldName;
        }

    }

}
