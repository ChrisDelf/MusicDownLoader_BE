package com.example.musicdownloader.Repository;

import com.example.musicdownloader.model.User;
import com.example.musicdownloader.model.UserRoles;
import org.springframework.data.repository.CrudRepository;

public interface UserRolesRepository extends CrudRepository<UserRoles, Long>  {

    UserRoles findById(long id);
    UserRoles deleteById(long id);
}
