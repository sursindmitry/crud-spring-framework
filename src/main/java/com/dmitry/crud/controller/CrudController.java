package com.dmitry.crud.controller;

import com.dmitry.crud.dto.CreateDto;
import com.dmitry.crud.model.User;
import com.dmitry.crud.service.CrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CrudController {

    private final CrudService crudService;


    @Autowired
    public CrudController(CrudService crudService) {
        this.crudService = crudService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody CreateDto dto) {

        crudService.create(dto);

        return new ResponseEntity<>("User Created", HttpStatus.OK);
    }

    @GetMapping("/read-user/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable String userId) {

        User user = crudService.findUserById(Long.parseLong(userId));

        return ResponseEntity.ok(user);
    }

    @GetMapping("/read-all-users")
    public List<User> getUsers() {
        return crudService.getAll();
    }

    @DeleteMapping("/delete/{userId}")
    ResponseEntity<String> deleteUserById(@PathVariable String userId) {

        crudService.deleteUserById(Long.parseLong(userId));

        return new ResponseEntity<>("User delete", HttpStatus.OK);
    }

}