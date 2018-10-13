package com.wyc.enums;

/**
 * @author: wyc
 * @date: 2018/10/11
 */
public enum ApiType {
    REQUEST(1), RESPONSE(2);

    private final Integer code;

    ApiType(final Integer code) {
        this.code = code;
    }

    public final Integer getCode() {
        return this.code;
    }
}
