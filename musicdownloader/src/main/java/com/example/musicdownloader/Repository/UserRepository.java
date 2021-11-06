package com.example.musicdownloader.Repository;

import com.example.musicdownloader.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository <User, Long> {
    User findByUsername(String username);
    User findById(long userid);
}
