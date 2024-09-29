package com.projeto.microservices.services.impl;

import com.projeto.microservices.domain.User;
import com.projeto.microservices.repositories.UserRepository;
import com.projeto.microservices.services.UserService;
import com.projeto.microservices.services.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final Environment env;

    @Override
    public User findById(Long id) {
        log.info("USER SERVICE ::: GET REQUEST ON "+env.getProperty("local.server.port")+ " port");
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not Found"));
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }
}
