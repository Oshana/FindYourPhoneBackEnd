package com.softwareArchitecture.assignment2.oshana.findYourPhone.config;

import com.softwareArchitecture.assignment2.oshana.findYourPhone.model.Users;
import com.softwareArchitecture.assignment2.oshana.findYourPhone.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users optionalUsers = usersRepository.findByName(username);
        return (UserDetails) optionalUsers;

    }
}