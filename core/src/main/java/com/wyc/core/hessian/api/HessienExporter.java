package com.wyc.core.hessian.api;

import com.wyc.service.ApiService;
import com.wyc.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianServiceExporter;

@Configuration
public class HessienExporter {

  @Autowired private HelloWorldService helloWorldService;

  @Autowired private ApiService apiService;

  private HessianServiceExporter buildHessianServiceExporter(
      Class serviceInterface, Object service) {
    HessianServiceExporter exporter = new HessianServiceExporter();
    exporter.setService(service);
    exporter.setServiceInterface(serviceInterface);
    return exporter;
  }

  @Bean("/helloWorldService")
  public HessianServiceExporter helloWorldService() {
    return buildHessianServiceExporter(HelloWorldService.class, helloWorldService);
  }

  @Bean("/apiService")
  public HessianServiceExporter apiService() {
    return buildHessianServiceExporter(ApiService.class, apiService);
  }
}
