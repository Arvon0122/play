package com.csj.ceshi.dao;

import com.csj.ceshi.pojo.StdSkuProduct;
import com.csj.ceshi.utils.MongoCommonDao;
import com.csj.ceshi.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StdSkuProductDao extends MongoCommonDao<StdSkuProduct> {

    @Override
    @Autowired
    @Qualifier("mongoTemplate")
    protected void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate=mongoTemplate;
    }
}
