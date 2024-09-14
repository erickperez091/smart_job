package com.example.prueba_smart_job.services;

import com.example.prueba_smart_job.entities.User;
import com.example.prueba_smart_job.repositories.UserRepository;
import com.example.prueba_smart_job.util.UserUtilHelper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserUtilHelper userUtilHelper;

    public UserService(UserRepository userRepository, UserUtilHelper userUtilHelper) {
        this.userRepository = userRepository;
        this.userUtilHelper = userUtilHelper;
    }

    public User save( User user) {
        Optional<User> userOptional = userRepository.findByEmail(user.getEmail());
        this.userUtilHelper.validateUser( userOptional, user );
        this.userUtilHelper.populateUser( user );
        return userRepository.save(user);
    }
}
