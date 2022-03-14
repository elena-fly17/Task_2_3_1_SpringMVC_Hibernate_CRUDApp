package com.mukhina.spring.mvc.DAO;

import com.mukhina.spring.mvc.entity.User;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManger;

    @Override
    public List<User> getUsers() {
        return entityManger.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void saveUser(User user) {
        entityManger.merge(user);
    }

    @Override
    public User getUser(int id) {
        return entityManger.find(User.class, id);
    }

    @Override
    public void deleteUser(int id) {
        User user = entityManger.find(User.class, id);
        entityManger.remove(user);
    }
}
