package com.wyc.manager.shiro;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

public class CredentialsMatcher extends SimpleCredentialsMatcher {
  @Override
  public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
    UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;

    return StringUtils.equals(
        new String(usernamePasswordToken.getPassword()), (String) info.getCredentials());
  }
}
