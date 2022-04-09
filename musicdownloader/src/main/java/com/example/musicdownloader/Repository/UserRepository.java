package com.example.musicdownloader.Repository;

import com.example.musicdownloader.model.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository <User, Long> {
    User findByusername(String username);
    User findById(long id);
    User deleteById(long id);
}
