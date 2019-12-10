package net.jmsolotask.springMVC.dao;

import net.jmsolotask.springMVC.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class UserDaoHibernateImpl implements UserDao {

    @PersistenceContext
    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    @Transactional
    public void deleteUser(long id) {
        entityManager.remove(getUserById(id));
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    @Transactional
    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @Transactional
    public User getUserByUserName(String userName) {
        Query query = entityManager.createQuery("FROM User where name = :paramName");
        query.setParameter("paramName", userName);
        List user = query.getResultList();
        return (user.isEmpty()) ? null : (User) user.get(0);
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return entityManager.createQuery("FROM User").getResultList();
    }
}
