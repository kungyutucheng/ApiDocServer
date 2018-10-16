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

@RestController
@RequestMapping(value = "/api")
public class ApiController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiController.class);

    @Autowired
    private ApiService apiService;

    @PostMapping(value = "/insert")
    @ResponseBody
    public BaseResp insert(@RequestBody ApiInsertReq req) {
        BaseResp resp = new BaseResp();

        resp.setCode(ResponseCode.SUCCESS.getCode());
        try {
            apiService.insert(req.getContent());
        } catch (Exception e) {
            LOGGER.error("系统异常", e);
            resp.errorSystem();
        }
        return resp;
    }

    @PostMapping(value = "/query")
    @ResponseBody
    public BaseResp query(@RequestBody @Valid ApiQueryReq req) {
        BaseResp resp = new BaseResp();
        resp.setCode(ResponseCode.SUCCESS.getCode());
        try {
            resp.setResult(apiService.query(req.getUrl(), req.getType()));
        } catch (Exception e) {
            LOGGER.error("查询API接口数据异常", e);
            resp.errorSystem();
            return resp;
        }
        return resp;
    }
}
