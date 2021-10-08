package com.example.musicdownloader.dao;

import com.example.musicdownloader.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("fakeDao")
public class FakeUserDataAccessService implements UserDao{

    private static List<User> DB = new ArrayList<>();

    @Override
    public int insertUser(UUID id, User user) {
        DB.add(new User(id,user.getName()));
        return 1;
    }

    @Override
    public List<User> selectAllUser() {
        return DB;
    }
}
