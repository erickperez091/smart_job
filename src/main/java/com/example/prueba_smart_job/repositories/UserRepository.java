package com.example.prueba_smart_job.repositories;

import com.example.prueba_smart_job.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository< User, String> {

    Optional<User> findByEmail(String email);
}
