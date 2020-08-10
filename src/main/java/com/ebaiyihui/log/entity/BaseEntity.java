package com.ebaiyihui.log.entity;

import com.ebaiyihui.log.util.DateUtils;

/**
 * @author mac
 * @version 1.0
 * @create 2019-09-26-11:59
 */
public class BaseEntity {

    /** 主键**/
    private Long id;

    /** 创建者**/
    private String createUser;

    /** 更新者**/
    private String updateUser;

    /** 创建日期 , format: yyyy-MM-dd **/
    private String createDate = DateUtils.getCurrentDateSimpleToString();


    /** 创建时间 , format: HH:mm:ss **/
    private String createTime = DateUtils.getCurrentTimeToString();

    /** 更新日期 , format: yyyy-MM-dd **/
    private String updateDate;

    /** 更新时间 , format: HH:mm:ss **/
    private String updateTime;

    /** 有效/失效状态 , format: 0 =有效  1=无效  默认0 **/
    private Short enabled = 0;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Short getEnabled() {
        return enabled;
    }

    public void setEnabled(Short enabled) {
        this.enabled = enabled;
    }
}
