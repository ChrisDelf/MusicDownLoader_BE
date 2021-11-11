package com.example.musicdownloader.service;

import com.example.musicdownloader.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {

    public User addUser(User user);
    public List<User> getAllUser();
    public User getUserById(UUID id);
    public void deleteUser(UUID id);
    public User updateUser(UUID id, User user);

}
