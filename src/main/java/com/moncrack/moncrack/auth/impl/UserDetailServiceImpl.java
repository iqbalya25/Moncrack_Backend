package com.moncrack.moncrack.auth.impl;

import com.moncrack.moncrack.auth.entity.UserAuth;
import com.moncrack.moncrack.users.entity.User;
import com.moncrack.moncrack.users.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    public UserDetailServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User existingUser = userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        var userAuth = new UserAuth();
        userAuth.setEmail(existingUser.getEmail());
        userAuth.setPassword(existingUser.getPassword());
        return userAuth;
    }
}
