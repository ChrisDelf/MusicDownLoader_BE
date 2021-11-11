package com.example.musicdownloader.service;


import com.example.musicdownloader.Repository.UserRepository;
import com.example.musicdownloader.exceptions.ResourceFoundException;
import com.example.musicdownloader.exceptions.ResourceNotFoundException;
import com.example.musicdownloader.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public User addUser(User user){

        if (userRepository.findByName(user.getName()) != null)
        {
            throw new ResourceFoundException(user.getName() + "is already taken!");
        }
        UUID uuid = UUID.randomUUID();
        User newUser = new User(uuid, user.getName());
        newUser.setPassword(user.getPassword());

        return userRepository.save(newUser);
    }

    @Override
    public List<User> getAllUser() {
        List<User> list = new ArrayList<>();
        userRepository.findAll()
                .iterator()
                .forEachRemaining(list::add);
        return list;
    }

    @Transactional
    @Override
    public User getUserById(UUID id) throws ResourceNotFoundException
    {
        return Optional.ofNullable(userRepository.findById(id))
                .orElseThrow(() -> new ResourceNotFoundException("User id " + id + "not found!"));

    }
    @Transactional
    @Override
    public void deleteUser(UUID id)
    {
        Optional.ofNullable(userRepository.findById(id))
                .orElseThrow( () -> new ResourceNotFoundException("User id " + id + "not found!"));
        userRepository.deleteById(id);
    }

    @Transactional
    @Override
    public User updateUser(UUID id, User user)
    {
        User currentUser = userRepository.findById(id);
    if (id == currentUser.getId()) {
        if (user.getName() != null) {
            currentUser.setName(user.getName());
        }

        if (user.getPassword() != null) {
            currentUser.setPassword(user.getPassword());
        }

        return userRepository.save(currentUser);
    }
    else
    {
        throw new ResourceNotFoundException(id + " Not current user");
    }

    }



}
