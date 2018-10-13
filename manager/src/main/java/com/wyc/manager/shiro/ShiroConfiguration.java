package com.wyc.manager.shiro;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

@Configuration
public class ShiroConfiguration {

  @Bean
  public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
    ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
    bean.setSecurityManager(securityManager);
    bean.setLoginUrl("/login");
    bean.setSuccessUrl("/home");
    LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
    filterChainDefinitionMap.put("/jsp/login.jsp", "anon"); // 表示可以匿名访问
    filterChainDefinitionMap.put("/login/loginPage", "anon"); // 表示可以匿名访问
    filterChainDefinitionMap.put("/*", "authc"); // 表示可以匿名访问
    bean.setFilterChainDefinitionMap(filterChainDefinitionMap);
    return bean;
  }

  @Bean
  public SecurityManager securityManager() {
    DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
    securityManager.setRealm(customShiroRealm());
    return securityManager;
  }

  @Bean
  public CustomShiroRealm customShiroRealm() {
    CustomShiroRealm shiroRealm = new CustomShiroRealm();
    shiroRealm.setCredentialsMatcher(credentialsMatcher());
    return shiroRealm;
  }

  @Bean
  public CredentialsMatcher credentialsMatcher() {
    return new CredentialsMatcher();
  }

  //  @Bean
  //  public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
  //    return new LifecycleBeanPostProcessor();
  //  }
  //
  //  @Bean
  //  public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
  //    DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator =
  //        new DefaultAdvisorAutoProxyCreator();
  //    defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
  //    return defaultAdvisorAutoProxyCreator;
  //  }

  @Bean
  public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(
      SecurityManager securityManager) {
    AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor =
        new AuthorizationAttributeSourceAdvisor();
    authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
    return authorizationAttributeSourceAdvisor;
  }
}
