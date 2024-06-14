package com.dmitry.crud.controller;

import com.dmitry.crud.dto.CreateDto;
import com.dmitry.crud.model.User;
import com.dmitry.crud.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;

@RestController
public class CrudController {

    private CrudService crudService;
    private final TemplateEngine templateEngine;


    @Autowired
    public CrudController(CrudService crudService, TemplateEngine templateEngine) {
        this.crudService = crudService;
        this.templateEngine = templateEngine;
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody CreateDto dto) {

        crudService.create(dto);

        return new ResponseEntity<>("User Created", HttpStatus.OK);
    }

    @GetMapping("/read-users/{userId}")
    public ResponseEntity<User> readUsersPage( @PathVariable String userId){

        User user = crudService.findUserById(Long.parseLong(userId));

       return ResponseEntity.ok(user);
    }

}