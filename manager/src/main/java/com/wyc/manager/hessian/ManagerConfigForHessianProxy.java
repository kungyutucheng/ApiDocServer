package com.wyc.manager.hessian;

import com.wyc.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;

@Configuration
public class ManagerConfigForHessianProxy {

  @Value("${core.server.url}")
  private String coreServer;

  public HessianProxyFactoryBean buildHessianProxyFactoryBean(
      Class serviceInterface, String serviceName) {
    HessianProxyFactoryBean factoryBean = new HessianProxyFactoryBean();
    factoryBean.setServiceInterface(serviceInterface);
    factoryBean.setServiceUrl(coreServer + serviceName);
    return factoryBean;
  }

  @Bean
  public HessianProxyFactoryBean userService() {
    return buildHessianProxyFactoryBean(UserService.class, "userService");
  }
}
