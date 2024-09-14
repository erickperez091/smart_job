package com.example.prueba_smart_job.controllers;

import com.example.prueba_smart_job.entities.User;
import com.example.prueba_smart_job.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/user/v1" )
public class UserController {


    private final UserService userService;

    public UserController( UserService userService ) {
        this.userService = userService;
    }

    @PostMapping( name = "create", value = "/", path = "/", consumes = { MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE } )
    public ResponseEntity< Object > create( @RequestBody User user ) {
        return new ResponseEntity<>( this.userService.save( user ), HttpStatus.CREATED );
    }
}
