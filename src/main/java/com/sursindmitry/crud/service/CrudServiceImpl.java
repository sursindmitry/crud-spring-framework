package com.sursindmitry.crud.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.sursindmitry.crud.dao.UserDao;
import com.sursindmitry.crud.dto.CreateDto;
import com.sursindmitry.crud.model.User;

@Service
public class CrudServiceImpl implements CrudService {

    private final UserDao userDao;

    public CrudServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public void create(CreateDto dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setSurname(dto.getSurname());
        user.setEmail(dto.getEmail());

        userDao.save(user);
    }

    @Transactional
    @Override
    public List<User> getAll() {
        return userDao.getAllUsers();
    }


    @Transactional
    @Override
    public User findUserById(Long id) {
        return userDao.findUserById(id);
    }

    @Transactional
    @Override
    public void deleteUserById(Long userId) {
        if (userId < 1) {
            throw new IllegalArgumentException("ID не может быть меньше нуля");
        }

        userDao.findUserById(userId);
        userDao.deleteUserById(userId);
    }

    @Transactional
    @Override
    public void update(User user) {
        if (user.getId() < 1) {
            throw new IllegalArgumentException("ID не может быть меньше нуля");
        }

        userDao.findUserById(user.getId());
        userDao.update(user);
    }
}
