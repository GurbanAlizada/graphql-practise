package com.example.graphqlpractise.model;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Entity(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity {

    private String name;

    private String surname;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING )
    private Role role;





}
