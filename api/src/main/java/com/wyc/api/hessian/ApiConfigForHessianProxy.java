package com.wyc.api.hessian;

import com.wyc.service.ApiService;
import com.wyc.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;

@Configuration
public class ApiConfigForHessianProxy {

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
  public HessianProxyFactoryBean helloWorldService() {
    return buildHessianProxyFactoryBean(HelloWorldService.class, "helloWorldService");
  }

  @Bean
  public HessianProxyFactoryBean apiService() {
    return buildHessianProxyFactoryBean(ApiService.class, "apiService");
  }
}
