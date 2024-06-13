package com.dmitry.crud.service;

import com.dmitry.crud.dto.CreateDto;
import com.dmitry.crud.model.User;
import java.util.List;

public interface CrudService {

    void create(CreateDto dto);

    List<User> getAll();
}
