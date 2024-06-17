package com.moncrack.moncrack.users.repository;

import com.moncrack.moncrack.users.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

}
