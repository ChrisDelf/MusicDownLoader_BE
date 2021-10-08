package com.example.musicdownloader.dao;

import com.example.musicdownloader.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

    @Override
    public Optional<User> selectUserById(UUID id) {
        return DB.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteUserById(UUID id) {
        Optional<User> userMaybe= selectUserById(id);
        if (userMaybe.isEmpty())
        {
            return 0;

        }
        DB.remove(userMaybe.get());

        return 1;
    }

    @Override
    public int updateUserById(UUID id, User user) {
        return selectUserById(id)
                .map(u -> {
                    int indexOfUserToUpdate = DB.indexOf(u);
                    if(indexOfUserToUpdate >= 0) {
                        DB.set(indexOfUserToUpdate, new User(id, user.getName()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
