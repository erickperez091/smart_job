package com.example.prueba_smart_job.util;

import com.example.prueba_smart_job.entities.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;
import java.util.regex.Pattern;

@Component
public class UserUtilHelper {

    @Value( "${email.valid.regexp}" )
    private String emailRegEx;

    @Value( "${password.valid.regexp}" )
    private String passwordRegEx;

    public void populateUser( User user ) {
        user.setId( UUID.randomUUID().toString() );
        user.setCreated( LocalDateTime.now() );
        user.setModified( LocalDateTime.now() );
        user.setLast_login( LocalDateTime.now() );
        user.setActive( Boolean.TRUE );
        user.setToken( UUID.randomUUID().toString() );
        Optional.ofNullable( user.getPhones() ).ifPresent( phones -> {
            phones.forEach( phone -> {
                phone.setId( UUID.randomUUID().toString() );
                phone.setUser( user );
            } );
        } );
    }

    public void validateUser(Optional<User> userOptional, User user){
        this.validateExistingUser( userOptional );
        this.validateUserEmail( user );
        this.validateUserPassword( user );
    }

    private void validateExistingUser( Optional<User> userOptional ) {
        userOptional.ifPresent(existingUser -> {
            throw new DuplicateKeyException( "El correo ya se encuentra registrado" );
        });
    }

    private void validateUserEmail( User user ) {
        boolean matches = Pattern.compile(emailRegEx)
                .matcher(user.getEmail())
                .matches();

        if ( !matches ) {
            throw new RuntimeException( "Formato Email Invalido");
        }
    }

    private void validateUserPassword( User user ) {
        boolean matches = Pattern.compile(passwordRegEx)
                .matcher(user.getPassword())
                .matches();

        if ( !matches ) {
            throw new RuntimeException( "Formato Contraseña Invalido");
        }
    }
}
