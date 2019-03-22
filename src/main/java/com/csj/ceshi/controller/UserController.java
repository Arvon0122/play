package com.csj.ceshi.controller;

import com.csj.ceshi.dao.MongodbDao;
import com.csj.ceshi.pojo.SysUser;
import com.csj.ceshi.pojo.User;
import com.csj.ceshi.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private MongodbDao mongodbDao;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<User> show(Model model) {
        return userService.getUserList();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ApiOperation(value = "创建用户", notes = "根据user对象创建用户")
    public void save(User user) {
        userService.saveUser(user);
    }

    @RequestMapping(value = "get/{id}",method = RequestMethod.GET)
    public User getUserById(@PathVariable("id") Integer id) {
        return userService.getUserById(id);
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String show() {
        return "index";
    }

    @RequestMapping(value = "/showString",method = RequestMethod.GET)
    public String showString() {
        String a = "aafdsf";
        return a;
    }
    @RequestMapping(value = "/saveUser",method = RequestMethod.POST)
    public String saveUser(@RequestBody SysUser sysUser){
        if(sysUser!=null){
          mongodbDao.save(sysUser);
        }
        return "添加成功";
    }
}
