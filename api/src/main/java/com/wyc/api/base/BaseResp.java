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

    public static BaseResp ERROR_SYSTEM() {
        BaseResp resp = new BaseResp();
        resp.setCode(ResponseCode.ERROR_SYSTEM.getCode());
        resp.setMsg(ResponseCode.ERROR_SYSTEM.getMsg());
        return resp;
    }

}
