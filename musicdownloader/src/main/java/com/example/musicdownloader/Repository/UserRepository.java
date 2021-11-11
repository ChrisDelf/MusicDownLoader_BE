package com.example.musicdownloader.Repository;

import com.example.musicdownloader.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UserRepository extends CrudRepository <User, Long> {
    User findByUsername(String username);
    User findById(UUID id);
    User deleteById(UUID id);
}
