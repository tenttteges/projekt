package com.example.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.demo.entity.User;
import com.example.demo.user.DefaultUser;

public interface UserService extends UserDetailsService {

	public User findByUserName(String userName);

	public void save(DefaultUser defaultUser);
}
