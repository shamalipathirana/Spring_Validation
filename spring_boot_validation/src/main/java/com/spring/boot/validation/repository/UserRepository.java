package com.spring.boot.validation.repository;

import com.spring.boot.validation.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {



}
