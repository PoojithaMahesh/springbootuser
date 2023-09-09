package com.jsp.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.user.dto.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
