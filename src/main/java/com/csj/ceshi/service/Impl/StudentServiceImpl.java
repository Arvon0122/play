package com.csj.ceshi.service.Impl;

import com.csj.ceshi.dao.StudentMapper;
import com.csj.ceshi.pojo.Student;
import com.csj.ceshi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public List<Student> getList() {
        return studentMapper.getList();
    }

    @Override
    public int addStudent(Student student) {
        return  studentMapper.insert(student);
    }

    @Override
    public boolean updateStudent(Student student) {
        if(student!=null){
            if(studentMapper.updateByPrimaryKeySelective(student)>0){
             return true;
            }else{
                return false;
            }
        }
        return false;
    }
}
