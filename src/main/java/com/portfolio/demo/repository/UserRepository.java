package com.portfolio.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.portfolio.demo.model.User;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);


}
