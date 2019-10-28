package com.connor.demo.services;

import com.connor.demo.models.User;
import com.connor.demo.models.UserProfile;
import com.connor.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    private UserRepository repository;
    private UserProfileService userProfileService;


    @Autowired
    public UserService(UserRepository repository){
        this.repository = repository;
    }

    public Iterable<User> findAll(){
        return repository.findAll();
    }

    public User findUserById(Long id){
        return repository.findUserByUserId(id);
    }

    public User findUserByUsername(String username){return repository.findUserByUsername(username);}

    public User create(User user){
//        User newUser = repository.save(user);
//        UserProfile userProfile = this.userProfileService.create(new UserProfile(newUser.getUserId()));
//        newUser.setUserProfile(userProfile);
//        newUser.setPassword(encryptPassword(user.getPassword()));
//        return repository.save(newUser);

        return repository.save(user);
    }

    public User login(User user){
        try {
            User tempUser = findUserByUsername(user.getUsername());
            if (confirmPassword(user.getPassword(), tempUser.getPassword())){
                return tempUser;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }


    private String encryptPassword(String password) {
        String salt = BCrypt.gensalt(4);
        return BCrypt.hashpw(password, salt);
    }

    private Boolean confirmPassword(String password, String hashed) {
        return BCrypt.checkpw(password, hashed);
    }


}
