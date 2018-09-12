package com.wyc.manager.shiro;

import com.wyc.entity.Role;
import com.wyc.entity.User;
import com.wyc.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CustomShiroRealm extends AuthorizingRealm {

  @Qualifier("userService")
  private UserService userService;

  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

    SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
    String username = (String) principalCollection.getPrimaryPrincipal();
    List<Role> comopleteRoles = userService.queryRolesByUserName(username);
    Set<String> roles = new HashSet<>();
    for (Role role : comopleteRoles) {
      roles.add(role.getRoleName());
    }

    authorizationInfo.setRoles(roles);
    return authorizationInfo;
  }

  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
      throws AuthenticationException {

    String username = authenticationToken.getPrincipal().toString();
    User user = userService.queryUserByUserName(username);
    if (user == null) {
      return null;
    }
    SimpleAuthenticationInfo authenticationInfo =
        new SimpleAuthenticationInfo(username, user.getPassword().toString(), getName());
    return authenticationInfo;
  }
}
