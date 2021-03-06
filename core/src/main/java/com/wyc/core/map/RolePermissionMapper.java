package com.wyc.core.map;

import com.wyc.entity.RolePermission;
import com.wyc.entity.RolePermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface RolePermissionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_permission
     *
     * @mbggenerated Mon Oct 01 09:20:24 GMT+08:00 2018
     */
    @SelectProvider(type=RolePermissionSqlProvider.class, method="countByExample")
    int countByExample(RolePermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_permission
     *
     * @mbggenerated Mon Oct 01 09:20:24 GMT+08:00 2018
     */
    @DeleteProvider(type=RolePermissionSqlProvider.class, method="deleteByExample")
    int deleteByExample(RolePermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_permission
     *
     * @mbggenerated Mon Oct 01 09:20:24 GMT+08:00 2018
     */
    @Delete({
        "delete from role_permission",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_permission
     *
     * @mbggenerated Mon Oct 01 09:20:24 GMT+08:00 2018
     */
    @Insert({
        "insert into role_permission (id, rid, ",
        "pid)",
        "values (#{id,jdbcType=INTEGER}, #{rid,jdbcType=INTEGER}, ",
        "#{pid,jdbcType=INTEGER})"
    })
    int insert(RolePermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_permission
     *
     * @mbggenerated Mon Oct 01 09:20:24 GMT+08:00 2018
     */
    @InsertProvider(type=RolePermissionSqlProvider.class, method="insertSelective")
    int insertSelective(RolePermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_permission
     *
     * @mbggenerated Mon Oct 01 09:20:24 GMT+08:00 2018
     */
    @SelectProvider(type=RolePermissionSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="rid", property="rid", jdbcType=JdbcType.INTEGER),
        @Result(column="pid", property="pid", jdbcType=JdbcType.INTEGER)
    })
    List<RolePermission> selectByExample(RolePermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_permission
     *
     * @mbggenerated Mon Oct 01 09:20:24 GMT+08:00 2018
     */
    @Select({
        "select",
        "id, rid, pid",
        "from role_permission",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="rid", property="rid", jdbcType=JdbcType.INTEGER),
        @Result(column="pid", property="pid", jdbcType=JdbcType.INTEGER)
    })
    RolePermission selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_permission
     *
     * @mbggenerated Mon Oct 01 09:20:24 GMT+08:00 2018
     */
    @UpdateProvider(type=RolePermissionSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") RolePermission record, @Param("example") RolePermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_permission
     *
     * @mbggenerated Mon Oct 01 09:20:24 GMT+08:00 2018
     */
    @UpdateProvider(type=RolePermissionSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") RolePermission record, @Param("example") RolePermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_permission
     *
     * @mbggenerated Mon Oct 01 09:20:24 GMT+08:00 2018
     */
    @UpdateProvider(type=RolePermissionSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(RolePermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_permission
     *
     * @mbggenerated Mon Oct 01 09:20:24 GMT+08:00 2018
     */
    @Update({
        "update role_permission",
        "set rid = #{rid,jdbcType=INTEGER},",
          "pid = #{pid,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(RolePermission record);
}