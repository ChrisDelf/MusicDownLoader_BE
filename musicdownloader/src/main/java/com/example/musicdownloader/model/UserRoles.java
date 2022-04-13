package com.example.musicdownloader.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;



@Entity
@Table(name = "user_roles")
public class UserRoles implements Serializable
    {
    @Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties("user_roles")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "role_id" )
    @JsonIgnoreProperties("user_roles")
    private Role role;

    public UserRoles()
    {
    }

    public UserRoles(User user, Role role)
    {
        this.user = user;
        this.role = role;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public Role getRole()
    {
        return role;
    }

    public void setRole(Role role)
    {
        this.role = role;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof UserRoles))
        {
            return false;
        }
        UserRoles userRoles = (UserRoles) o;
        return getUser().equals(userRoles.getUser()) && getRole().equals(userRoles.getRole());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getUser(), getRole());
    }

    @Override
    public String toString()
    {
        return "UserRoles{" + "user=" + user.getId() + ", role=" + role.getId() + '}';
    }

}

