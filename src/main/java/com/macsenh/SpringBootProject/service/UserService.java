package com.macsenh.SpringBootProject.service;

import com.macsenh.SpringBootProject.entity.User;
import com.macsenh.SpringBootProject.exception.ApplicationException;

import java.util.List;

public interface UserService {
    List<User> showUserList();

    void saveUser(User user);

    User findById(Integer id) throws ApplicationException;

    void deleteUser(Integer id);

}
