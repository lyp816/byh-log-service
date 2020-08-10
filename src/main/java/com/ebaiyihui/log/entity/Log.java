package com.ebaiyihui.log.entity;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author lyp
 */
@Data
//@Document("log")
public class Log {
    private Long ObjectId;

    /** 操作用户 */
    private String userViewId;

    /** 描述 */
    private String description;

    /** 方法名 */
    private String method;

    /** 参数 */
    private String params;

    /** 日志类型 */
    private String logType;

    /** 请求ip */
    private String requestIp;

    /** 地址 */
    private String address;

    /** 浏览器  */
    private String browser;

    /** 请求耗时 */
    private Long time;

    /** 异常详细  */
    private byte[] exceptionDetail;

    /** 创建日期 */
    private Timestamp createTime;

    private Integer logActionType;
    public Log(String logType, Long time) {
        this.logType = logType;
        this.time = time;
    }
}
