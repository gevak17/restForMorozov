package com.gevak.rest.controller.dto.builder;

import com.gevak.rest.controller.dto.UserDTO;
import com.gevak.rest.entity.User;

public class UserDtoBuilder {

    public static UserDTO toDto(User user) {
        return new UserDTO(user.getUsername(), user.getPassword(), user.getEmail(),
                user.getPhone1(), user.getPhone2(), user.getPhone3(), user.getName(),
                user.getRate());
    }

    public static User toEntity(UserDTO userDTO) {
        return new User(userDTO.username, userDTO.password, userDTO.email,
                userDTO.phone1, userDTO.phone2, userDTO.phone3, userDTO.name);
    }

}
