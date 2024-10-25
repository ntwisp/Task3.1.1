package org.test.springboot.service;

import org.test.springboot.model.User;
import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void saveUser(User user);
    User getUser(Long id);
    void deleteUser(Long id);
   }