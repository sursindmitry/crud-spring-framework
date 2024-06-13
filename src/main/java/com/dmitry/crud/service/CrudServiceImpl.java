package com.dmitry.crud.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.dmitry.crud.dao.UserDao;
import com.dmitry.crud.dto.CreateDto;
import com.dmitry.crud.model.User;

@Service
public class CrudServiceImpl implements CrudService {

    private UserDao userDao;

    public CrudServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void create(CreateDto dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setSurname(dto.getSurname());
        user.setEmail(dto.getEmail());

        userDao.save(user);
    }

    @Override
    public List<User> getAll() {
        return userDao.getAllUsers();
    }
}
