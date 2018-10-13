package com.wyc.core.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.wyc.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

@Component
public class ApiServiceImpl implements ApiService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void insert(Object object) {
        mongoTemplate.insert(object, "api");
    }

    @Override
    public JSONObject query(String url, Integer type) {
        Criteria criteria = new Criteria();
        criteria.and("url").is(url);
        criteria.and("type").is(type);
        Query query = new Query(criteria);
//    Criteria criteria = Criteria.where("url").is(url).andOperator(Criteria.where("type").is(type));
//        query.addCriteria(criteria);
        return mongoTemplate.findOne(query, JSONObject.class, "api");
    }
}
