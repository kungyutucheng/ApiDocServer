package com.wyc.manager.shiro;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

@Configuration
public class ShiroConfiguration {

  @Bean("shiroFilter")
  public ShiroFilterFactoryBean shiroFilter(
      @Qualifier("securityManager") SecurityManager securityManager) {
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

  @Bean("securityManager")
  public SecurityManager securityManager(
      @Qualifier("customShiroRealm") CustomShiroRealm shiroRealm) {
    DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
    securityManager.setRealm(shiroRealm);
    return securityManager;
  }

  @Bean("customShiroRealm")
  public CustomShiroRealm shiroRealm(@Qualifier("credentialsMatcher") CredentialsMatcher matcher) {
    CustomShiroRealm shiroRealm = new CustomShiroRealm();
    shiroRealm.setCredentialsMatcher(matcher);
    return shiroRealm;
  }

  @Bean("credentialsMatcher")
  public CredentialsMatcher credentialsMatcher() {
    return new CredentialsMatcher();
  }

  @Bean
  public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
    return new LifecycleBeanPostProcessor();
  }

  @Bean
  public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
    DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator =
        new DefaultAdvisorAutoProxyCreator();
    defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
    return defaultAdvisorAutoProxyCreator;
  }

  @Bean
  public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(
      @Qualifier("securityManager") SecurityManager securityManager) {
    AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor =
        new AuthorizationAttributeSourceAdvisor();
    authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
    return authorizationAttributeSourceAdvisor;
  }
}
