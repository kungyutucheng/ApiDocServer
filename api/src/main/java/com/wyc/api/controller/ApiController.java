package com.wyc.api.controller;

import com.wyc.annotation.Valid;
import com.wyc.api.req.ApiInsertReq;
import com.wyc.api.req.ApiQueryReq;
import com.wyc.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api")
public class ApiController {

    @Autowired
    private ApiService apiService;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> insert(@RequestBody ApiInsertReq req) {
        Map<String, Object> resultMap = new HashMap<String, Object>();

        resultMap.put("code", 0);
        try {
//            JSONObject jsonObject = JSONObject.parseObject(req.getContent());
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
    public Map<String, Object> insert(@Valid ApiQueryReq req) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("code", 0);
//        if (StringUtils.isBlank(req.getUrl())) {
//            resultMap.put("code", 1);
//            resultMap.put("msg", "参数非法");
//            return resultMap;
//        }
//        if (req.getType() == null
//                || (req.getType() != CommonConstant.API_TYPE_REQUEST && req.getType() != CommonConstant.API_TYPE_RESPONSE)) {
//            resultMap.put("code", 1);
//            resultMap.put("msg", "参数非法");
//            return resultMap;
//        }
        try {
            resultMap.put("content", apiService.query(req.getUrl(), req.getType()));
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("code", 1);
            resultMap.put("msg", "系统异常");
        }
        return resultMap;
    }
}
