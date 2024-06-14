package com.dmitry.crud.controller;

import com.dmitry.crud.service.CrudService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@RestController
public class WebController {

    private final TemplateEngine templateEngine;

    public WebController(TemplateEngine templateEngine, CrudService crudService) {
        this.templateEngine = templateEngine;
    }

    @GetMapping("/")
    public String printWelcome() {

        Context context = new Context();

        return templateEngine.process("index", context);
    }

    @GetMapping("/create-user")
    public String createUserPage() {
        Context context = new Context();

        return templateEngine.process("create-user", context);
    }

    @GetMapping("/read-users")
    public String readUsersPage() {

        Context context = new Context();

        return templateEngine.process("read-users", context);
    }

    @GetMapping("/delete-user")
    public String deleteUserPage() {

        Context context = new Context();

        return templateEngine.process("delete-user", context);
    }

    @GetMapping("/update-user")
    public String updateUserPage() {

        Context context = new Context();

        return templateEngine.process("update-user", context);
    }

}
