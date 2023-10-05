package com.JwtTokenGenaration.Service;

import com.JwtTokenGenaration.Entity.User;
import com.JwtTokenGenaration.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Load User from Database
        User user = userRepository.findByEmail(username).orElseThrow(() -> new RuntimeException("User Not Found"));

        return user;
    }
}
