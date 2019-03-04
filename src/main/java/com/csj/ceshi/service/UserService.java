package com.csj.ceshi.service;

import com.csj.ceshi.pojo.User;

import java.util.List;

public interface UserService {
    public List<User> getUserList();
    public void saveUser(User user);
    public User getUserById(Integer id);
}
