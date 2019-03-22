package com.csj.ceshi.utils;


import org.junit.platform.commons.util.StringUtils;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;


public abstract class MongoCommonDao<T> {

    /**
     * 默认分页信息
     */
    private static final int DEFAULT_SKIP = 1;
    private static final int DEFAULT_LIMIT = 20;

    /**
     * spring-mongodb　集成操作类
     */
    protected MongoTemplate mongoTemplate;

    /**
     * 通过条件查询实体(集合)， 只能指定条件，集合名默认为实体类
     */

    public List<T> find(Query query) {
        return mongoTemplate.find(query, this.getEntityClass());
    }

    public List<T> find(Map<String, Object> map) {
        Query query = covertQuery(map);
        return mongoTemplate.find(query, this.getEntityClass());
    }

    /**
     * 通过条件查询实体(集合)，可以指定条件和集合名
     */

    public List<T> find(Query query, String collectionName) {
        return mongoTemplate.find(query, this.getEntityClass(), collectionName);
    }

    /**
     * 通过条件查询实体(集合)，可以指定条件和集合名以及返回集合实体类
     */

    public List<?> find(Query query, Class<?> clazz, String collectionName) {
        return mongoTemplate.find(query, clazz, collectionName);
    }

    /**
     * 通过一定的条件查询一个实体，只能指定条件，集合名默认为实体类
     */

    public T findOne(Query query) {
        return mongoTemplate.findOne(query, this.getEntityClass());
    }

    public T findOne(Map<String, Object> map) {
        Query query = covertQuery(map);
        return mongoTemplate.findOne(query, this.getEntityClass());
    }

    /**
     * 可以指定条件和集合名以及返回集合实体类
     *
     * @param query
     * @param collectionName
     * @return T
     */

    public T findOne(Query query, String collectionName) {
        return mongoTemplate.findOne(query, this.getEntityClass(), collectionName);
    }

    /**
     * 可以指定条件和集合名以及返回集合实体类
     *
     * @param query
     * @param clazz
     * @param collectionName
     */

    public Object findOne(Query query, Class<?> clazz, String collectionName) {
        return mongoTemplate.findOne(query, clazz, collectionName);
    }

    /**
     * 通过条件查询更新数据，
     *
     * @param query
     * @param update
     * @return void
     */

    public void update(Query query, Update update) {
        mongoTemplate.findAndModify(query, update, this.getEntityClass());
    }

    /**
     * 根据id修改
     *
     * @param t
     */
    public void updateById(T t) {
        Update update = covertUpdate(t);
        Query query = covertQueryById(t);
        mongoTemplate.findAndModify(query, update, this.getEntityClass());
    }

    /**
     * 通过条件查询更新数据,可以指定集合名
     *
     * @param query
     * @param update
     * @param collectionName
     * @return void
     */

    public void update(Query query, Update update, String collectionName) {
        mongoTemplate.findAndModify(query, update, this.getEntityClass(), collectionName);
    }

    /**
     * 通过条件查询更新数据，可以指定集合名和类名（主要获取其属性名称）
     *
     * @param query
     * @param update
     * @param clazz
     * @param collectionName
     * @return void
     */

    public void update(Query query, Update update, Class<?> clazz, String collectionName) {
        mongoTemplate.findAndModify(query, update, clazz, collectionName);
    }

    /**
     * 保存一个对象到mongodb
     *
     * @param entity
     * @return T
     */

    public T save(T entity) {
        mongoTemplate.insert(entity);
        return entity;
    }

    /**
     * 保存一个对象到mongodb(可以指定存储到的集合名称)
     *
     * @param entity
     * @param collectionName
     * @return T
     */

    public T save(T entity, String collectionName) {
        mongoTemplate.insert(entity, collectionName);
        return entity;
    }

    /**
     * 批量新增
     *
     * @param t
     * @param collectionName
     * @return void
     */
    public void saveBatch(List<T> t, String collectionName) {
        mongoTemplate.insert(t, collectionName);
    }

    /**
     * 按条件删除
     *
     * @param query
     * @param collectionName
     * @return void
     */
    public void remove(Query query, String collectionName) {
        if (mongoTemplate.exists(query, collectionName)) {
            mongoTemplate.remove(query, collectionName);
        }
    }

    public void remove(Query query) {
        if (mongoTemplate.exists(query, getEntityClass())) {
            mongoTemplate.remove(query, getEntityClass());
        }
    }

    public void remove(Map<String, Object> map, String collectionName) {
        Query query = covertQuery(map);
        if (mongoTemplate.exists(query, collectionName)) {
            mongoTemplate.remove(query, collectionName);
        }
    }

    public void remove(Map<String, Object> map) {
        Query query = covertQuery(map);
        if (mongoTemplate.exists(query, getEntityClass())) {
            mongoTemplate.remove(query, getEntityClass());
        }
    }

    /**
     * 删除数据集
     */
    public void drop(String collectionName) {
        mongoTemplate.dropCollection(collectionName);
    }


    /**
     * 通过ID获取记录
     *
     * @param id
     * @return T
     */

    public T findById(String id) {
        return mongoTemplate.findById(id, this.getEntityClass());
    }

    /**
     * 通过ID获取记录,并且指定了集合名(表的意思)
     *
     * @param id
     * @param collectionName
     * @return T
     */

    public T findById(String id, String collectionName) {
        return mongoTemplate.findById(id, this.getEntityClass(), collectionName);
    }

    /**
     * 分页查询
     *
     * @param pageNum
     * @param pageSize
     * @param query
     */

    public Page<T> findPage(Integer pageNum, Integer pageSize, Query query) {
        //获取分页总数
        Long total = this.count(query);
        //分页信息处理
        if (pageNum == null) {
            pageNum = DEFAULT_SKIP;
        }
        if (pageSize == null) {
            pageSize = DEFAULT_LIMIT;
        }
        query.skip((pageNum - 1) * pageSize);
        query.limit(pageSize);

        //将查询的数据设置进集合
        return new Page<T>(this.find(query), pageNum, pageSize, total);
    }

    public Page<T> findPage(Integer pageNum, Integer pageSize, Map<String, Object> map) {
        Query query = covertQuery(map);
        //获取sort 状态
        String sortStatus = (String) map.get("sort");
        String content = (String) map.get("content");
        Sort sort = null;
        if (StringUtils.isNotBlank(sortStatus)) {
            //1 升序 -1 降序
            if (sortStatus.equals("1")) {
                sort = new Sort(Sort.Direction.ASC,(content));
            } else if (sortStatus.equals("-1")) {
                sort = new Sort(Sort.Direction.DESC,(content));
            }
        }
        query.with(sort);
        //获取分页总数
        Long total = this.count(query);
        //分页信息处理
        if (pageNum == null) {
            pageNum = DEFAULT_SKIP;
        }
        if (pageSize == null) {
            pageSize = DEFAULT_LIMIT;
        }
        query.skip((pageNum - 1) * pageSize);
        query.limit(pageSize);
        //将查询的数据设置进集合
        return new Page<T>(this.find(query), pageNum, pageSize, total);
    }
    /**
     * 分页查询
     */
    public Page<T> findPage(Integer pageNum, Integer pageSize, Query query, String collectionName) {
        //获取分页总数
        Long total = this.count(query, collectionName);
        //分页信息处理
        if (pageNum == null) {
            pageNum = DEFAULT_SKIP;
        }
        if (pageSize == null) {
            pageSize = DEFAULT_LIMIT;
        }
        query.skip((pageNum - 1) * pageSize);
        query.limit(pageSize);
        //将查询的数据设置进集合
        return new Page<T>(this.find(query, collectionName), pageNum, pageSize, total);
    }

    /**

     */

    public long count(Query query) {
        return mongoTemplate.count(query, this.getEntityClass());
    }

    public long count(Map<String, Object> map) {
        Query query = covertQuery(map);
        return mongoTemplate.count(query, this.getEntityClass());
    }

    public long count(Query query, String collectionName) {
        return mongoTemplate.count(query, this.getEntityClass(), collectionName);
    }

    /**
     * 分组统计
     *
     * @param collectionName 数据集名称
     * @param match          条件注入
     * @param group          分组信息
     */
    public List<T> sum(String collectionName, MatchOperation match, GroupOperation group) {
        // Aggregation.match(Criteria.where("oid").is(orderId))
        // Aggregation.group("userName").sum("flowSize").as("tatoalFlowSize").sum("amount").as("totalAmount")
        Aggregation aggregation = Aggregation.newAggregation(match, group);
        AggregationResults<T> aggRes = mongoTemplate.aggregate(aggregation,
                collectionName, this.getEntityClass());
        return aggRes.getMappedResults();
    }

    public Update covertUpdate(T t) {
        Update update = new Update();
        Class<?> clazz = t.getClass();
        for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
            try {
                Field[] fields = clazz.getDeclaredFields();
                for (Field field : fields) {
                    field.setAccessible(true);
                    String name = field.getName();
                    Object vaule = field.get(t);
                    if (vaule != null && StringUtils.isNotBlank(vaule.toString())) {
                        update.set(name, vaule);
                    }
                }
            } catch (Exception e) {
                throw new BussinessException("covertUpdate 异常");
            }
        }
        return update;
    }

    public Query covertQuery(Map<String, Object> map) {
        Criteria criteria = new Criteria();
        if (map != null && !map.isEmpty()) {
            Class<?> entityClass = this.getEntityClass();
            List<String> list = covertEntity(entityClass);
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if ((list.contains(entry.getKey()) || entry.getKey().endsWith("_like")) && entry.getValue() != null && StringUtils.isNotBlank(entry.getValue().toString())) {
                    if (entry.getKey().endsWith("_like")) {
                        String key = entry.getKey().substring(0, entry.getKey().indexOf("_like"));
                        Pattern pattern = Pattern.compile("^.*" + entry.getValue() + ".*$", Pattern.CASE_INSENSITIVE);
                        criteria.and(key).regex(pattern);
                    } else {
                        criteria.and(entry.getKey()).is(entry.getValue());
                    }
                }
            }
        }
        Query query = new Query(criteria);
        return query;
    }

    public Query covertQuery(T t) {
        Criteria criteria = new Criteria();
        Class<?> clazz = t.getClass();
        for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
            try {
                Field[] fields = clazz.getDeclaredFields();
                for (Field field : fields) {
                    field.setAccessible(true);
                    String name = field.getName();
                    Object o = field.get(t);
                    if (o != null) {
                        criteria.and(name).is(o);
                    }
                }
            } catch (Exception e) {
                throw new BussinessException("covertQueryById 异常");
            }
        }
        Query query = new Query(criteria);
        return query;
    }

    public List<String> covertEntity(Class<?> entityClass) {
        List<String> list = new ArrayList<>();
        for (; entityClass != Object.class; entityClass = entityClass.getSuperclass()) {
            try {
                Field[] fields = entityClass.getDeclaredFields();
                for (Field field : fields) {
                    field.setAccessible(true);
                    String name = field.getName();
                    list.add(name);
                }
            } catch (Exception e) {
                throw new BussinessException("转换对象异常", e.getMessage());
            }
        }
        return list;
    }

    public Query covertQueryById(T t) {
        Class<?> clazz = t.getClass();
        for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
            try {
                Field[] fields = clazz.getDeclaredFields();
                for (Field field : fields) {
                    field.setAccessible(true);
                    String name = field.getName();
                    if (name.equals("id")) {
                        Query query = new Query(Criteria.where("_id").is(field.get(t)));
                        return query;
                    }
                }
            } catch (Exception e) {
                throw new BussinessException("covertQueryById 异常");
            }
        }
        return null;
    }

    /**
     * 获取需要操作的实体类class
     *
     * @return
     */
    private Class<T> getEntityClass() {
        return ReflectionUtils.getSuperClassGenricType(getClass());
    }

    /**
     * 注入mongodbTemplate
     *
     * @param mongoTemplate
     */
    protected abstract void setMongoTemplate(MongoTemplate mongoTemplate);

    public MongoTemplate getMongoTemplate() {
        return mongoTemplate;
    }
}



