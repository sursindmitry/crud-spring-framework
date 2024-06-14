package com.dmitry.crud.dao;

import com.dmitry.crud.model.User;
import java.util.List;

public interface UserDao {
    void save(User user);

    List<User> getAllUsers();

    User findUserById(Long id);
}
