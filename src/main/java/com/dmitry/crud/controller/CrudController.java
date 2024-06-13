package com.dmitry.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import com.dmitry.crud.dto.CreateDto;
import com.dmitry.crud.service.CrudService;

@RestController
public class CrudController {

    private CrudService crudService;

    private final TemplateEngine templateEngine;

    @Autowired
    public CrudController(CrudService crudService, TemplateEngine templateEngine) {
        this.crudService = crudService;
        this.templateEngine = templateEngine;
    }

    @GetMapping(value = "/")
    public String printWelcome() {

        Context context = new Context();

        return templateEngine.process("index", context);
    }

    @GetMapping(value = "/create-user")
    public String printCreateUser() {
        Context context = new Context();

        return templateEngine.process("create-user", context);
    }


    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody CreateDto dto) {

        crudService.create(dto);

        return new ResponseEntity<>("User Created", HttpStatus.OK);
    }

//	@GetMapping("/{userId}")
//	public String findUserById(@PathVariable Long userId,
//							   Model model){
//		model.addAttribute("user", crudService.getUser(userId));
//
//		return "index";
//	}

}