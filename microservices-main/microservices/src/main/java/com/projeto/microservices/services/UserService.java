package com.projeto.microservices.services;

import com.projeto.microservices.domain.User;

import java.util.List;

public interface UserService {

    User findById(Long id);
    List<User> findAll();
}
