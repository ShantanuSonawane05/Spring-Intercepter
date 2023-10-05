package com.JwtTokenGenaration.controllers;

import com.JwtTokenGenaration.Entity.User;
import com.JwtTokenGenaration.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public List<User> getUser()
    {
        System.out.println("Getting Users");
        return userService.getUsers();
    }

    @GetMapping("/currentUser")
    public String getLoggedUsers(Principal principal)
    {
        return principal.getName();
    }
}
