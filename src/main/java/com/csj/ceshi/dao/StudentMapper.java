package com.csj.ceshi.dao;

import com.csj.ceshi.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface StudentMapper {
    int deleteByPrimaryKey(BigDecimal stuid);
    List<Student> getList();
    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(BigDecimal stuid);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}