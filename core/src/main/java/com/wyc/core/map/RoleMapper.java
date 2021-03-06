package com.wyc.core.map;

import com.wyc.entity.Role;
import com.wyc.entity.RoleExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface RoleMapper {
  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * role
   *
   * @mbggenerated Mon Sep 10 18:55:31 GMT+08:00 2018
   */
  @SelectProvider(type = RoleSqlProvider.class, method = "countByExample")
  int countByExample(RoleExample example);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * role
   *
   * @mbggenerated Mon Sep 10 18:55:31 GMT+08:00 2018
   */
  @DeleteProvider(type = RoleSqlProvider.class, method = "deleteByExample")
  int deleteByExample(RoleExample example);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * role
   *
   * @mbggenerated Mon Sep 10 18:55:31 GMT+08:00 2018
   */
  @Delete({"delete from role", "where id = #{id,jdbcType=INTEGER}"})
  int deleteByPrimaryKey(Integer id);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * role
   *
   * @mbggenerated Mon Sep 10 18:55:31 GMT+08:00 2018
   */
  @Insert({
    "insert into role (id, role_name, ",
    "gmt_create, gmt_modified)",
    "values (#{id,jdbcType=INTEGER}, #{roleName,jdbcType=VARCHAR}, ",
    "#{gmtCreate,jdbcType=TIMESTAMP}, #{gmtModified,jdbcType=TIMESTAMP})"
  })
  int insert(Role record);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * role
   *
   * @mbggenerated Mon Sep 10 18:55:31 GMT+08:00 2018
   */
  @InsertProvider(type = RoleSqlProvider.class, method = "insertSelective")
  int insertSelective(Role record);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * role
   *
   * @mbggenerated Mon Sep 10 18:55:31 GMT+08:00 2018
   */
  @SelectProvider(type = RoleSqlProvider.class, method = "selectByExample")
  @Results({
    @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
    @Result(column = "role_name", property = "roleName", jdbcType = JdbcType.VARCHAR),
    @Result(column = "gmt_create", property = "gmtCreate", jdbcType = JdbcType.TIMESTAMP),
    @Result(column = "gmt_modified", property = "gmtModified", jdbcType = JdbcType.TIMESTAMP)
  })
  List<Role> selectByExample(RoleExample example);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * role
   *
   * @mbggenerated Mon Sep 10 18:55:31 GMT+08:00 2018
   */
  @Select({
    "select",
    "id, role_name, gmt_create, gmt_modified",
    "from role",
    "where id = #{id,jdbcType=INTEGER}"
  })
  @Results({
    @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
    @Result(column = "role_name", property = "roleName", jdbcType = JdbcType.VARCHAR),
    @Result(column = "gmt_create", property = "gmtCreate", jdbcType = JdbcType.TIMESTAMP),
    @Result(column = "gmt_modified", property = "gmtModified", jdbcType = JdbcType.TIMESTAMP)
  })
  Role selectByPrimaryKey(Integer id);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * role
   *
   * @mbggenerated Mon Sep 10 18:55:31 GMT+08:00 2018
   */
  @UpdateProvider(type = RoleSqlProvider.class, method = "updateByExampleSelective")
  int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * role
   *
   * @mbggenerated Mon Sep 10 18:55:31 GMT+08:00 2018
   */
  @UpdateProvider(type = RoleSqlProvider.class, method = "updateByExample")
  int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * role
   *
   * @mbggenerated Mon Sep 10 18:55:31 GMT+08:00 2018
   */
  @UpdateProvider(type = RoleSqlProvider.class, method = "updateByPrimaryKeySelective")
  int updateByPrimaryKeySelective(Role record);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * role
   *
   * @mbggenerated Mon Sep 10 18:55:31 GMT+08:00 2018
   */
  @Update({
    "update role",
    "set role_name = #{roleName,jdbcType=VARCHAR},",
    "gmt_create = #{gmtCreate,jdbcType=TIMESTAMP},",
    "gmt_modified = #{gmtModified,jdbcType=TIMESTAMP}",
    "where id = #{id,jdbcType=INTEGER}"
  })
  int updateByPrimaryKey(Role record);

  @Select(
      "select * from role where id in (select rid from user_role where uid = (select id from user where username = #{username})")
  List<Role> queryRoleByUserName(@Param("username") String username);
}
