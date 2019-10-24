package com.connor.demo.controllers;

import com.connor.demo.models.User;
import com.connor.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value ="/users")
@CrossOrigin
public class UserController {

    private UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Long id) {
        return new ResponseEntity<>(service.findUserById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Iterable<User>> getUsers() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        try {
            return new ResponseEntity<>(service.create(user), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        try {
            return new ResponseEntity<>(service.login(user), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping(value = "/all/{type}")
    public ResponseEntity<Iterable<User>> getUsersByProfileType(@PathVariable("type") String type) {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

}



