package com.wyc.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * user.id
   *
   * @mbggenerated Sun Sep 09 20:43:54 GMT+08:00 2018
   */
  private Integer id;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * user.username
   *
   * @mbggenerated Sun Sep 09 20:43:54 GMT+08:00 2018
   */
  private String username;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * user.password
   *
   * @mbggenerated Sun Sep 09 20:43:54 GMT+08:00 2018
   */
  private String password;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * user.gmt_create
   *
   * @mbggenerated Sun Sep 09 20:43:54 GMT+08:00 2018
   */
  private Date gmtCreate;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * user.gmt_modified
   *
   * @mbggenerated Sun Sep 09 20:43:54 GMT+08:00 2018
   */
  private Date gmtModified;

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column user.id
   *
   * @return the value of user.id
   * @mbggenerated Sun Sep 09 20:43:54 GMT+08:00 2018
   */
  public Integer getId() {
    return id;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column user.id
   *
   * @param id the value for user.id
   * @mbggenerated Sun Sep 09 20:43:54 GMT+08:00 2018
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column user.username
   *
   * @return the value of user.username
   * @mbggenerated Sun Sep 09 20:43:54 GMT+08:00 2018
   */
  public String getUsername() {
    return username;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column user.username
   *
   * @param username the value for user.username
   * @mbggenerated Sun Sep 09 20:43:54 GMT+08:00 2018
   */
  public void setUsername(String username) {
    this.username = username;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column user.password
   *
   * @return the value of user.password
   * @mbggenerated Sun Sep 09 20:43:54 GMT+08:00 2018
   */
  public String getPassword() {
    return password;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column user.password
   *
   * @param password the value for user.password
   * @mbggenerated Sun Sep 09 20:43:54 GMT+08:00 2018
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column user.gmt_create
   *
   * @return the value of user.gmt_create
   * @mbggenerated Sun Sep 09 20:43:54 GMT+08:00 2018
   */
  public Date getGmtCreate() {
    return gmtCreate;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column user.gmt_create
   *
   * @param gmtCreate the value for user.gmt_create
   * @mbggenerated Sun Sep 09 20:43:54 GMT+08:00 2018
   */
  public void setGmtCreate(Date gmtCreate) {
    this.gmtCreate = gmtCreate;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column user.gmt_modified
   *
   * @return the value of user.gmt_modified
   * @mbggenerated Sun Sep 09 20:43:54 GMT+08:00 2018
   */
  public Date getGmtModified() {
    return gmtModified;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column user.gmt_modified
   *
   * @param gmtModified the value for user.gmt_modified
   * @mbggenerated Sun Sep 09 20:43:54 GMT+08:00 2018
   */
  public void setGmtModified(Date gmtModified) {
    this.gmtModified = gmtModified;
  }
}
