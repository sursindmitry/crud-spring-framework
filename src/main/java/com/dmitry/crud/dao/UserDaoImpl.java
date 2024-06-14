package com.dmitry.crud.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.dmitry.crud.model.User;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Transactional
    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Transactional
    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }

    @Transactional
    @Override
    public User findUserById(Long id) {
        Query query = entityManager.createQuery("FROM User WHERE id=:id");

        query.setParameter("id", id);

        return (User) query.getSingleResult();
    }

    @Transactional
    @Override
    public void deleteUserById(Long userId) {
        Query query = entityManager.createQuery("DELETE User WHERE id = :userId");

        query.setParameter("userId", userId).executeUpdate();
    }
}
