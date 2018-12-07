package swust.qiy.microservice.management.entity;

import javax.persistence.*;

@Entity
@Table(name = "`api_content`")
public class ApiContent {
    /**
     * 唯一标识
     */
    @Id
    @Column(name = "`ID`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 所属API标识
     */
    @Column(name = "`API_ID`")
    private Integer apiId;

    /**
     * 请求头部
     */
    @Column(name = "`HEAD`")
    private String head;

    /**
     * 请求参数
     */
    @Column(name = "`PARAMETERS`")
    private String parameters;

    /**
     * 返回信息
     */
    @Column(name = "`RETURN_INFO`")
    private String returnInfo;

    /**
     * 复杂类型对象
     */
    @Column(name = "`TYPE_OBJ`")
    private String typeObj;

    /**
     * 错误码说明
     */
    @Column(name = "`ERROR_CODE`")
    private String errorCode;

    /**
     * 获取唯一标识
     *
     * @return ID - 唯一标识
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置唯一标识
     *
     * @param id 唯一标识
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取所属API标识
     *
     * @return API_ID - 所属API标识
     */
    public Integer getApiId() {
        return apiId;
    }

    /**
     * 设置所属API标识
     *
     * @param apiId 所属API标识
     */
    public void setApiId(Integer apiId) {
        this.apiId = apiId;
    }

    /**
     * 获取请求头部
     *
     * @return HEAD - 请求头部
     */
    public String getHead() {
        return head;
    }

    /**
     * 设置请求头部
     *
     * @param head 请求头部
     */
    public void setHead(String head) {
        this.head = head;
    }

    /**
     * 获取请求参数
     *
     * @return PARAMETERS - 请求参数
     */
    public String getParameters() {
        return parameters;
    }

    /**
     * 设置请求参数
     *
     * @param parameters 请求参数
     */
    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    /**
     * 获取返回信息
     *
     * @return RETURN_INFO - 返回信息
     */
    public String getReturnInfo() {
        return returnInfo;
    }

    /**
     * 设置返回信息
     *
     * @param returnInfo 返回信息
     */
    public void setReturnInfo(String returnInfo) {
        this.returnInfo = returnInfo;
    }

    /**
     * 获取复杂类型对象
     *
     * @return TYPE_OBJ - 复杂类型对象
     */
    public String getTypeObj() {
        return typeObj;
    }

    /**
     * 设置复杂类型对象
     *
     * @param typeObj 复杂类型对象
     */
    public void setTypeObj(String typeObj) {
        this.typeObj = typeObj;
    }

    /**
     * 获取错误码说明
     *
     * @return ERROR_CODE - 错误码说明
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * 设置错误码说明
     *
     * @param errorCode 错误码说明
     */
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}