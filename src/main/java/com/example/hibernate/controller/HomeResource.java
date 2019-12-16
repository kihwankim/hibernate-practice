package com.example.hibernate.controller;

import com.example.hibernate.domain.User;
import com.example.hibernate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.RollbackException;

@RestController
public class HomeResource {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String home() {
        return ("<h1>Welcome</h1>");
    }

    @GetMapping("/user")
    public User user(@RequestParam("username") String username) throws RollbackException {
        return userService.loadUserByUsername(username);
    }

    @GetMapping("/save")
    public boolean save(@RequestBody User user) throws Exception {
        return this.userService.save(user);
    }

    @GetMapping("/admin")
    public String admin() {
        return "<h1>welcome admin</h1>";
    }
}
