package com.bankinngApplication.Banking.Application.repository;

import com.bankinngApplication.Banking.Application.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

