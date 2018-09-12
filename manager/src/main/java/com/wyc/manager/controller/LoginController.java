package com.wyc.manager.controller;

import com.wyc.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value = "/login")
public class LoginController {

  private static Logger logger = LoggerFactory.getLogger(LoginController.class);

  @Autowired private UserService userService;

  @RequestMapping(value = "/loginPage")
  public ModelAndView loginPage() {
    ModelAndView modelAndView = new ModelAndView("login");
    return modelAndView;
  }

  @RequestMapping(value = "/login")
  public String login(String username, String password) {

    UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
    Subject subject = SecurityUtils.getSubject();
    try {
      subject.login(usernamePasswordToken);
      return "home";
    } catch (Exception e) {
      logger.error("登录异常", e);
      return "login";
    }
  }
}
