package com.mukhina.spring.mvc.service;

import com.mukhina.spring.mvc.entity.User;
import java.util.List;

public interface UserService {
    List<User> getUsers();
    void saveUser(User user);
    User getUser(int id);
    void deleteUser(int id);
}
