package com.connor.demo.repositories;

import com.connor.demo.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findUserByUserId(Long id);
    User findUserByUsername(String username);


}