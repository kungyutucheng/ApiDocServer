package com.wyc.api.controller;

import com.wyc.annotation.Valid;
import com.wyc.api.base.BaseResp;
import com.wyc.api.req.ApiInsertReq;
import com.wyc.api.req.ApiQueryReq;
import com.wyc.enums.ResponseCode;
import com.wyc.service.ApiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api")
public class ApiController {

    private static final Logger logger = LoggerFactory.getLogger(ApiController.class);

    @Autowired
    private ApiService apiService;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> insert(@RequestBody ApiInsertReq req) {
        Map<String, Object> resultMap = new HashMap<String, Object>();

        resultMap.put("code", 0);
        try {
            apiService.insert(req.getContent());
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("code", 1);
            resultMap.put("msg", "系统异常");
        }
        return resultMap;
    }

    @RequestMapping(value = "/query", method = RequestMethod.POST)
    @ResponseBody
    public BaseResp insert(@Valid ApiQueryReq req) {
        BaseResp resp = new BaseResp();
        resp.setCode(ResponseCode.SUCCESS.getCode());
        try {
            resp.setResult(apiService.query(req.getUrl(), req.getType()));
        } catch (Exception e) {
            logger.error("查询API接口数据异常", e);
            resp.errorSystem();
            return resp;
        }
        return resp;
    }
}
