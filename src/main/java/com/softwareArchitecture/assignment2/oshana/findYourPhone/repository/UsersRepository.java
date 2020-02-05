package com.softwareArchitecture.assignment2.oshana.findYourPhone.repository;

import com.softwareArchitecture.assignment2.oshana.findYourPhone.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findByName(String username);
    List<Users> findByEmail(String email);
}
