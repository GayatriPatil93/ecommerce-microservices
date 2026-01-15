package com.ecommerce.user_service.controller;

import com.ecommerce.user_service.dto.LoginRequest;
import com.ecommerce.user_service.model.User;
import com.ecommerce.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {


        @Autowired
        private UserService userService;

        @PostMapping("/register")
        public User register(@RequestBody User user) {
            return userService.register(user);
        }

        @PostMapping("/login")
        public User login(@RequestBody LoginRequest request) {
            return userService.login(request.getEmail(), request.getPassword());
        }
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }


}
