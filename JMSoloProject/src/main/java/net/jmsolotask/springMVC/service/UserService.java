package net.jmsolotask.springMVC.service;

import net.jmsolotask.springMVC.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllClient();
    void addUser(User user);
    void deleteUser(Long id);
    void updateUser(User user);
    User getUserById(Long id);
    User getUserByUserName(String userName);
}
