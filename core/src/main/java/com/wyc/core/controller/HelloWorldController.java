package com.wyc.core.controller;

import com.alibaba.fastjson.JSONObject;
import com.wyc.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hello")
public class HelloWorldController {

  @Autowired private HelloWorldService helloWorldService;

  @RequestMapping(value = "/hello")
  @ResponseBody
  public String hello(@RequestBody String hello) {
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("name", hello);
    return helloWorldService.sayHello(jsonObject);
  }
}
