package com.csj.ceshi.dao;

import com.csj.ceshi.pojo.SysUser;
import com.csj.ceshi.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class MongodbDao {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Transactional
    public void save(SysUser user){
        mongoTemplate.insert(user);
    }
}
