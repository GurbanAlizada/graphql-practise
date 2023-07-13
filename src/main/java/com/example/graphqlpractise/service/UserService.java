package com.example.graphqlpractise.service;

import com.example.graphqlpractise.dto.UserRequest;
import com.example.graphqlpractise.exception.UserNotFoundException;
import com.example.graphqlpractise.model.User;
import com.example.graphqlpractise.repo.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return findUserById(id);
    }


    @Transactional
    public User createUser(UserRequest userRequest) {
        User user = User.builder()
                .email(userRequest.getEmail())
                .name(userRequest.getName())
                .password(userRequest.getPassword())
                .role(userRequest.getRole())
                .surname(userRequest.getSurname())
                .build();
        return userRepository.save(user);
    }

    @Transactional
    public User updateUser(UserRequest userRequest) {
        User user = findUserById(userRequest.getId());
        user.setName(user.getName());
        user.setSurname(user.getSurname());
        user.setPassword(user.getPassword());
        user.setRole(user.getRole());
        user.setEmail(user.getEmail());
        return userRepository.save(user);
    }


    @Transactional
    public Boolean deleteUser(Long id) {
        User user = findUserById(id);
        userRepository.delete(user);
        return true;
    }

    protected User findUserById(Long id){
        return userRepository.findById(id).orElseThrow(()-> new UserNotFoundException("user not found"));
    }

}
