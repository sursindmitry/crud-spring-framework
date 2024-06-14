package com.sursindmitry.crud.dao;

import com.sursindmitry.crud.model.User;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void save(User user) {
        entityManager.persist(user);
    }


    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }


    @Override
    public User findUserById(Long id) {

        return Optional.ofNullable(entityManager.find(User.class, id))
            .orElseThrow(() -> new RuntimeException("Пользователь с таким id не найден"));
    }


    @Override
    public void deleteUserById(Long userId) {
        Query query = entityManager.createQuery("DELETE User WHERE id = :userId");

        query.setParameter("userId", userId);

        query.executeUpdate();
    }


    @Override
    public void update(User user) {
        entityManager.merge(user);
    }
}
