package com.wyc.enums;

/**
 * @author: wyc
 * @date: 2018/10/13
 */

public enum ResponseCode {
    SUCCESS(0, null), ERROR_PARAMS(-1, null), ERROR_SYSTEM(1, "系统异常");
    private Integer code;

    private String msg;

    ResponseCode(Integer code, String msg) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
