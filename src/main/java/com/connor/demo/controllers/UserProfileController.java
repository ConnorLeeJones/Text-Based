package com.connor.demo.controllers;

import com.connor.demo.models.UserProfile;
import com.connor.demo.services.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value ="/profiles")
@CrossOrigin
public class UserProfileController {

    private UserProfileService service;

    @Autowired
    public UserProfileController(UserProfileService service){ this.service = service; }

    @GetMapping
    public ResponseEntity<Iterable<UserProfile>> getAllProfiles() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<UserProfile> getUserProfile(@PathVariable("id") Long id) {
        return new ResponseEntity<>(service.findUserProfileById(id), HttpStatus.OK);
    }


}
