package com.wyc.api.controller;

import com.wyc.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hello")
public class HelloWorldController {

  @Autowired private HelloWorldService helloWorldService;

  @RequestMapping(value = "hello")
  public String hello() {
    return helloWorldService.sayHello();
  }
}
