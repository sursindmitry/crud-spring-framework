package com.sursindmitry.crud.dao;

import com.sursindmitry.crud.model.User;
import java.util.List;

public interface UserDao {
    void save(User user);

    List<User> getAllUsers();

    User findUserById(Long id);

    void deleteUserById(Long userId);

    void update(User user);
}
