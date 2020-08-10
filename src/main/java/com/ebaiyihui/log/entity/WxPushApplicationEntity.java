package com.ebaiyihui.log.entity;

/**
 * @author mac
 * @version 1.0
 * @create 2019-09-26-11:52
 */
public class WxPushApplicationEntity extends BaseEntity {
    private String grantType;

    private String appId;

    private String secret;

    private String clientCode;

    private String clientName;

    public String getGrantType() {
        return grantType;
    }

    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getClientCode() {
        return clientCode;
    }

    public void setClientCode(String clientCode) {
        this.clientCode = clientCode;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
}
