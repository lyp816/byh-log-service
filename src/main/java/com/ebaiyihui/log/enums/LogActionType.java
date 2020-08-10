package com.ebaiyihui.log.enums;

/**
 * @author lyp
 */

public enum LogActionType {
    /**
     * 增删改查
     */
    ADD(1,"新增"),
    SELECT(2,"查询"),
    UPDATE(3,"更新"),
    DELETE(4,"删除");
    private Integer value;
    private String display;


    LogActionType(Integer value, String display) {
        this.value = value;
        this.display=display;
    }

    public String getDisplay() {
        return display;
    }

    public void getDisplay(String display) {
        this.display = display;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
