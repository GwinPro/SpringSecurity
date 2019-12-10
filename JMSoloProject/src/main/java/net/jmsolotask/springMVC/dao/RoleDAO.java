package net.jmsolotask.springMVC.dao;

import net.jmsolotask.springMVC.model.Role;
import net.jmsolotask.springMVC.model.User;

import java.util.List;

public interface RoleDAO {
    Role getRoleById(long id);
    Role getRoleByName(String roleName);
    void addRole(Role role);
    void updateRole(Role role);
    void deleteRole(long id);
    List<Role> getRoles();
}
