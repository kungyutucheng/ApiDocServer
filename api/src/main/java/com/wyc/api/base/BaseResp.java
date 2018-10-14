package com.wyc.api.base;

import com.wyc.enums.ResponseCode;
import lombok.Data;

/**
 * @author: wyc
 * @date: 2018/10/13
 */
@Data
public class BaseResp {
    /**
     * 状态码，0-成功；1-参数错误
     */
    private Integer code;
    /**
     * 错误信息
     */
    private String msg;

    /**
     * 返回内容
     */
    private Object result;

    public void errorSystem() {
        this.code = ResponseCode.ERROR_SYSTEM.getCode();
        this.msg = ResponseCode.ERROR_SYSTEM.getMsg();
    }

}
