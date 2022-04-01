package com.example.musicdownloader.api;

import com.example.musicdownloader.model.User;
import com.example.musicdownloader.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/all_users")
    public ResponseEntity<List<User>> getAllUsers()throws Exception{
           List<User> tempUsers = userService.getAllUser();

        return new ResponseEntity<>(tempUsers, HttpStatus.OK);
    }

    @PostMapping(value = "/create_user",
            consumes = {"application/json"},
            produces = {"application/json"})
    public ResponseEntity<?> CreateUser(HttpServletRequest request, @Validated
    @RequestBody User newuser) throws Exception{


        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PutMapping(value = "/updated_user",
            consumes = {"application/json"},
            produces = {"application/json"})
    public ResponseEntity<?> UpdateUser(HttpServletRequest request, @Validated
    @RequestBody User newuser) throws Exception{


        return new ResponseEntity<>(HttpStatus.OK);



    }











}
