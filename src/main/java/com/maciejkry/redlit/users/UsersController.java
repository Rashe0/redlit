package com.maciejkry.redlit.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/u")
public class UsersController {
    @Autowired
    private UsersService service;

    @GetMapping
    public ArrayList listUsers(){
        return service.fetchUsers();
    }

    @PostMapping
    public ResponseEntity addUser(@RequestBody User user) {
        //add new user to SQL
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(value = "/{userID}")
    public User listUser(@RequestParam(name = "usersID") String userID) {
        //return user from SQL
        User user = new User();
        return user;
    }

    @DeleteMapping(value = "/{userID}")
    public ResponseEntity deleteUser(@RequestParam(name = "usersID") String userID) {
        //delete user from SQL
        return new ResponseEntity(HttpStatus.OK);
    }
}
