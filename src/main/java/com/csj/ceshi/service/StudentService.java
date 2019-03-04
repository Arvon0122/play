package com.csj.ceshi.service;

import com.csj.ceshi.pojo.Student;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface StudentService {
    List<Student> getList();
    int addStudent(Student student);
    boolean updateStudent(Student student);
}
