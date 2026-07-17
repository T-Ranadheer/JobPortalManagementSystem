package com.jobportal.service;

import com.jobportal.entity.User;
import java.util.List;

public interface UserService {

    User saveUser(User user);

    User updateUser(User user);

    User getUserById(Long id);


    User getUserByEmail(String email);

    List<User> getAllUsers();

    void deleteUser(Long id);

    boolean existsByEmail(String email);
}