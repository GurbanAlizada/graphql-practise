package com.example.graphqlpractise.dto;

import com.example.graphqlpractise.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {

    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private Role role;

}
