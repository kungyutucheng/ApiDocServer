package com.wyc.core.service.impl;

import com.wyc.core.map.RoleMapper;
import com.wyc.core.map.UserMapper;
import com.wyc.entity.Permission;
import com.wyc.entity.Role;
import com.wyc.entity.User;
import com.wyc.entity.UserExample;
import com.wyc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {

  @Autowired private UserMapper userMapper;

  @Autowired private RoleMapper roleMapper;

  @Override
  public User queryUserByUserName(String userName) {
    UserExample userExample = new UserExample();
    userExample.or().andUsernameEqualTo(userName);
    List<User> users = userMapper.selectByExample(userExample);
    if (users == null || users.size() <= 0) {
      return null;
    }
    return users.get(0);
  }

  @Override
  public List<Role> queryRolesByUserName(String userName) {
    return roleMapper.queryRoleByUserName(userName);
  }

  @Override
  public List<Permission> queryPermissionsByUserName(String username) {
    return null;
  }
}
