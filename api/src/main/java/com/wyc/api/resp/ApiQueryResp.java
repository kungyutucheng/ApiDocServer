package com.wyc.api.resp;

import com.alibaba.fastjson.JSONObject;
import com.wyc.api.base.BaseResp;
import lombok.Data;

/**
 * @author: wyc
 * @date: 2018/10/13
 */
@Data
public class ApiQueryResp extends BaseResp {
    private JSONObject content;
}
