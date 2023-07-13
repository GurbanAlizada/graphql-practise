package com.example.graphqlpractise.controller;

import com.example.graphqlpractise.dto.UserRequest;
import com.example.graphqlpractise.model.User;
import com.example.graphqlpractise.service.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController{


    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }



    @QueryMapping
    List<User> getAllUsers(){
        return userService.getAllUsers();
    }


    @QueryMapping
    User getById(@Argument Long id){
       return userService.findById(id);
    }

    @MutationMapping
    User createUser(@Argument UserRequest userRequest){
        return userService.createUser(userRequest);
    }


    @MutationMapping
    User updateUser(@Argument UserRequest userRequest){
        return userService.updateUser(userRequest);
    }


    @MutationMapping
    Boolean deleteUser(@Argument Long id){
        return userService.deleteUser(id);
    }






}
