package com.csj.ceshi.dao;

import com.csj.ceshi.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    @Select("select * from user")
    public List<User> getUserList();
    @Insert("insert into user values(#{id},#{name},#{age})")
    public void saveUser(User user);
    @Select("select * from user where id=#{id}")
    public User getUserById(Integer id);
}
