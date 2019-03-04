package com.csj.ceshi.controller;

import com.csj.ceshi.dao.StudentMapper;
import com.csj.ceshi.pojo.Reckon;
import com.csj.ceshi.pojo.Student;
import com.csj.ceshi.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Api(value = "学生controller")
@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentMapper studentMapper;

    @ApiOperation(value = "查询所有")
    @GetMapping(value = "/list")
    @ResponseBody
    public List<Student> getList() {
        return studentService.getList();
    }

    @ApiOperation(value = "根据id查询学生")
    @GetMapping(value = "/getStudent/{id}")
    @ResponseBody
    public Student getStudentById(@PathVariable("id") Integer id) {
        return studentMapper.selectByPrimaryKey(new BigDecimal(id));
    }

    @ApiOperation(value = "保存学生")
    @PostMapping("/save")
    @ResponseBody
    public String addStudent(@RequestBody Student student) {
        if (studentService.addStudent(student) > 0) {
            return "添加成功";
        } else {
            return "添加失败";
        }
    }

    @GetMapping("aaa")
    public String listIndex() {
        return "index";
    }

    @RequestMapping(value = "/reckon", method = RequestMethod.POST)
    @ResponseBody
    public Double reckon(@RequestBody Reckon reckon) {
        double sum = reckon.getNum1() * reckon.getNum2();
        return sum;
    }

    /**
     * 修改
     */
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    public String updateStudent(@RequestBody Student student) {
        if (studentService.updateStudent(student)) {
            return "修改成功";
        } else {
            return "修改失败";
        }
    }
}
