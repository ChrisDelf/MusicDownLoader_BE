package com.example.musicdownloader.service;


import com.example.musicdownloader.dao.UserDao;
import com.example.musicdownloader.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserDao userDao;

    @Autowired
    public UserService(@Qualifier("fakeDao") UserDao userDao) {
        this.userDao = userDao;
    }

    public int addUser(User user){
       return userDao.insertUser(user);
    }

    public List<User> getAllUser() {

        return userDao.selectAllUser();
    }

}