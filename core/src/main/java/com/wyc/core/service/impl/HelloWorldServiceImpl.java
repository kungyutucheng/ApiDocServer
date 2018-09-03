package com.wyc.core.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.wyc.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldServiceImpl implements HelloWorldService {

  @Autowired private MongoTemplate template;

  @Override
  public String sayHello(JSONObject object) {
    template.insert(object, "test");
    return "hello";
  }
}
