package com.eureka.user.service;

import com.eureka.user.model.User;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;

public interface UserService {

    void create(User user);

    User findById(Long id) throws NotFoundException;

    List<User> findAll();

    User findByUsername(String username) throws NotFoundException;

    User update(Long id, User user) throws NotFoundException;

    User delete(Long id) throws NotFoundException;


}
