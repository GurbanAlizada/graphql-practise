package com.example.graphqlpractise.repo;

import com.example.graphqlpractise.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


}
