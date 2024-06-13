package com.dmitry.crud.service;

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
    public Object getUser(Long userId) {
        return null;
    }

    @Override
    public void create(CreateDto dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setSurname(dto.getSurname());
        user.setEmail(dto.getEmail());

        userDao.save(user);
    }
}
