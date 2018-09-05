package com.wyc.service;

import com.alibaba.fastjson.JSONObject;

public interface ApiService {
  /**
   * 插入数据
   *
   * @param object
   */
  void insert(Object object);

  /**
   * 查询数据
   *
   * @param url
   * @param type
   */
  JSONObject query(String url, Integer type);
}
