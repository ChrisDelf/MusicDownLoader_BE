package com.example.musicdownloader.dao;

import com.example.musicdownloader.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserDao {


    int insertUser(UUID id, User user);

    default int insertUser(User user){
        UUID id = UUID.randomUUID();
        return insertUser(id, user);
    }

    List<User> selectAllUser();

    Optional<User> selectUserById(UUID id);

    int deleteUserById(UUID id);

    int updatePersonById(UUID id, User user);
}
