package com.example.musicdownloader.service;


import com.example.musicdownloader.dao.UserDao;
import com.example.musicdownloader.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    private final UserDao userDao;

    @Autowired
    public UserService(@Qualifier("postgres") UserDao userDao) {
        this.userDao = userDao;
    }

    public int addUser(User user){
       return userDao.insertUser(user);
    }

    public List<User> getAllUser() {

        return userDao.selectAllUser();
    }

    public Optional<User> getUserById(UUID id)
    {
        return userDao.selectUserById(id);

    }

    public int deleteUser(UUID id) {
        return userDao.deleteUserById(id);
    }

    public int updateUser(UUID id, User user)
    {
        return userDao.updateUserById(id, user);

    }

}
