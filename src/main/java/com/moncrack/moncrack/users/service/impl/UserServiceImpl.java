package com.moncrack.moncrack.users.service.impl;

import com.moncrack.moncrack.users.entity.User;
import com.moncrack.moncrack.users.repository.UserRepository;
import com.moncrack.moncrack.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    @Override
    public User createUser(User user) {
        // Uncomment the line below if you want to hash the password in some other way
        // user.setPasswordHash(hashPassword(user.getPasswordHash()));
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User user) {
        return userRepository.findById(id)
                .map(existingUser -> {
                    existingUser.setName(user.getName());
                    existingUser.setEmail(user.getEmail());
                    // Uncomment the line below if you want to hash the password in some other way
                    // existingUser.setPasswordHash(hashPassword(user.getPasswordHash()));
                    return userRepository.save(existingUser);
                }).orElse(null);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // Uncomment and implement this method if you want to add password hashing logic
    // private String hashPassword(String password) {
    //     // Implement your password hashing logic here
    //     return password;
    // }
}
