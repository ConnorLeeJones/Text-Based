package com.connor.demo.services;

import com.connor.demo.models.UserProfile;
import com.connor.demo.repositories.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService {

    private UserProfileRepository repository;


    @Autowired
    public UserProfileService(UserProfileRepository repository){
        this.repository = repository;
    }


    public Iterable<UserProfile> findAll(){
        return repository.findAll();
    }

    public UserProfile findUserProfileById(Long id){
        return repository.findById(id).get();
    }

    public UserProfile create(UserProfile profile){
        return repository.save(profile);
    }



}
