package com.gevak.rest.controller;


import com.gevak.rest.controller.dto.UserDTO;
import com.gevak.rest.controller.dto.builder.UserDtoBuilder;
import com.gevak.rest.entity.User;
import com.gevak.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.ws.rs.core.MediaType;
import java.util.List;

@RestController
public class MainController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/{user_id}", produces = MediaType.APPLICATION_JSON)
    public UserDTO index(@PathVariable("user_id") Long id) {
        return UserDtoBuilder.toDto(userService.findOne(id));
    }




}
