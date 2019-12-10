package net.jmsolotask.springMVC.dao;

import net.jmsolotask.springMVC.model.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);
    void deleteUser(long id);
    void updateUser(User user);
    User getUserById(long id);
    User getUserByUserName(String userName);
    List<User> getAllUsers();
}
