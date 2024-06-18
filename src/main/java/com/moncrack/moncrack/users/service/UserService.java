package com.moncrack.moncrack.users.service;

import com.moncrack.moncrack.users.entity.User;
import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(Long id);

    User createUser(User user);

    User updateUser(Long id, User user);

    void deleteUser(Long id);

    Optional<User> findByEmail(String email);

//    boolean checkUserCredentials(String email, String password);
}
