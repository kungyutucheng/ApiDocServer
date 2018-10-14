package com.wyc.api.req;

import com.wyc.annotation.Date;
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
    @Range(intValue = {CommonConstant.API_TYPE_REQUEST, CommonConstant.API_TYPE_RESPONSE}, message = "请求实体类型取值错误")
    private int type;

    @Require
    @Date(message = "时间不符合要求", pattern = "yyyy-MM-dd", between = {"2018-01-01", "2018-10-10"})
    private String date;
}
