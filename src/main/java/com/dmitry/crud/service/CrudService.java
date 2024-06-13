package com.dmitry.crud.service;

import com.dmitry.crud.dto.CreateDto;

public interface CrudService {
    Object getUser(Long userId);

    void create(CreateDto dto);
}
