package com.picpay.picpaydemo.controllers;


import com.picpay.picpaydemo.domain.user.User;
import com.picpay.picpaydemo.dtos.UserDTO;
import com.picpay.picpaydemo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController()
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDTO user){
        User newUser = userService.createUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
            List<User> users = this.userService.getAllUsers();
            return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
