package com.wyc.service;

import com.wyc.entity.Permission;
import com.wyc.entity.Role;
import com.wyc.entity.User;

import java.util.List;

public interface UserService {
  /**
   * 根据用户名获取用户对象
   *
   * @param userName
   * @return
   */
  User queryUserByUserName(String userName);

  /**
   * 根据用户名获取用户角色
   *
   * @param userName
   * @return
   */
  List<Role> queryRolesByUserName(String userName);

  /**
   * 根据用户名获取用户权限
   *
   * @param username
   * @return
   */
  List<Permission> queryPermissionsByUserName(String username);
}
