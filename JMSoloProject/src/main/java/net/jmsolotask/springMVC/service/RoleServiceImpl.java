package net.jmsolotask.springMVC.service;

import net.jmsolotask.springMVC.dao.RoleDAO;
import net.jmsolotask.springMVC.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl  implements RoleService{

    @Autowired
    private RoleDAO roleDao;

    @Override
    public Role getRoleById(long id) {
        return roleDao.getRoleById(id);
    }

    @Override
    public Role getRoleByName(String roleName) {
        return roleDao.getRoleByName(roleName);
    }

    @Override
    public void addRole(Role role) {
        roleDao.addRole(role);
    }

    @Override
    public void updateRole(Role role) {
        roleDao.updateRole(role);

    }

    @Override
    public void deleteRole(long id) {
        roleDao.deleteRole(id);
    }

    @Override
    public List<Role> getRoles() {
        return roleDao.getRoles();
    }
}
