package com.wyc.api.req;

import com.wyc.annotation.Range;
import com.wyc.annotation.Require;
import com.wyc.constant.CommonConstant;
import lombok.Data;


/**
 * @author: wyc
 * @date: 2018/10/9
 */
@Data
public class ApiQueryReq {

    @Require(message = "url不能为空")
    private String url;
    
    @Require(message = "请求实体类型不能为空")
    @Range(intValue = {CommonConstant.API_TYPE_RESPONSE, CommonConstant.API_TYPE_REQUEST}, message = "请求实体类型取值错误")
    private int type;
}
