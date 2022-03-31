package com.example.musicdownloader.service;

import com.example.musicdownloader.Repository.RoleRepository;
import com.example.musicdownloader.Repository.UserRepository;
import com.example.musicdownloader.exceptions.ResourceNotFoundException;
import com.example.musicdownloader.model.Role;
import com.example.musicdownloader.model.User;
import com.example.musicdownloader.model.UserRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service(value = "roleService")
public class RoleServiceImpl implements RoleService{
    @Autowired
    RoleRepository rolerepos;

    @Autowired
    UserRepository userrepos;

    @Override
    public List<Role> findAll()
    {
        List<Role> list = new ArrayList<>();
        rolerepos.findAll()
                .iterator()
                .forEachRemaining(list::add);
        return list;
    }


    @Override
    public Role findRoleById(long id)
    {
        return rolerepos.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Role id " + id + " not found!"));
    }

    @Override
    public Role findByName(String name)
    {
        Role rr = rolerepos.findByNameIgnoreCase(name);

        if (rr != null)
        {
            return rr;
        } else
        {
            throw new ResourceNotFoundException(name);
        }
    }

    @Transactional
    @Override
    public void delete(long id)
    {
        rolerepos.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Role id " + id + " not found!"));
        rolerepos.deleteById(id);
    }


    @Transactional
    @Override
    public Role save(Role role)
    {

        Role newRole = new Role();
        newRole.setName(role.getName());

        ArrayList<UserRoles> newUsers = new ArrayList<>();
        for (UserRoles ur : role.getUserroles())
        {
            long id = ur.getUser()
                    .getId();
            User user = userrepos.findById(id);
            if (user == null) {

                throw new ResourceNotFoundException("User id " + id + " not found!");
            }
            else {
                System.out.println("Do we get here");
                newUsers.add(new UserRoles(ur.getUser(), newRole));
            }
        }
        newRole.setUserroles(newUsers);

        return rolerepos.save(role);
    }
    
}
