package com.example.musicdownloader.dao;

import com.example.musicdownloader.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class UserDataAccess implements UserDao {


    /// allows for construct functions with the database
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDataAccess(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertUser(UUID id, User user) {
        return 0;
    }

    @Override
    public List<User> selectAllUser() {
        final String sql = "SELECT id, name FROM users";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
           UUID id = UUID.fromString(resultSet.getString("id"));
           String name =  resultSet.getString("name");
            return new User(id,name);
        });
    }

    @Override
    public Optional<User> selectUserById(UUID id) {
        final String sql = "SELECT id, name FROM  users WHERE id = ?";
        User user = jdbcTemplate.queryForObject(sql, new Object[]{id},(resultSet, i) -> {
            UUID userId = UUID.fromString(resultSet.getString("id"));
            String name =  resultSet.getString("name");
            return new User(userId,name);
        });
        return Optional.ofNullable(user);
    }

    @Override
    public int deleteUserById(UUID id) {
        return 0;
    }

    @Override
    public int updateUserById(UUID id, User user) {
        return 0;
    }
}
