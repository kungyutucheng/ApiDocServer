package com.wyc.api.controller;

import com.alibaba.fastjson.JSONObject;
import com.wyc.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api")
public class ApiController {

  @Autowired private ApiService apiService;

  @RequestMapping(
    value = "/insert",
    method = RequestMethod.POST,
    produces = "text/plain;charset=utf-8"
  )
  @ResponseBody
  public Map<String, Object> insert(@RequestBody String content) {
    Map<String, Object> resultMap = new HashMap<String, Object>();

    resultMap.put("code", 0);
    try {
      JSONObject jsonObject = JSONObject.parseObject(content);
      apiService.insert(jsonObject);
    } catch (Exception e) {
      e.printStackTrace();
      resultMap.put("code", 1);
      resultMap.put("msg", "系统异常");
    }
    return resultMap;
  }
}
