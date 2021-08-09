package com.eureka.user.service.imp;

import com.eureka.user.model.User;
import com.eureka.user.repository.UserRepository;
import com.eureka.user.service.UserService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private BCryptPasswordEncoder encoder;
    @Override
    public void create(User user) {
        //Connection con = DriverManager.getConnection("jdbc:mysql://localhost/testdb", "root", "b18dcdt73");

        String sql = "INSERT INTO user(username, password, role) values (?,?,?) ";
        jdbcTemplate.update(sql, user.getUsername(), encoder.encode(user.getPassword()), user.getRole());

        //return userRepository.saveAndFlush(user);
    }

    @Override
    public User findById(Long id) throws NotFoundException {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException("id: " + id));
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByUsername(String username) throws NotFoundException {
        String sql = "SELECT * FROM user WHERE username = '" + username + "'";
        return jdbcTemplate.queryForObject(sql, (resultSet, i) ->
                new User(
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("role")
                ));
    }

    @Override
    public User update(Long id, User user) throws NotFoundException {
        User currentUser = userRepository.findById(id).orElseThrow(() -> new NotFoundException("id: "+id));
        currentUser.setPassword(user.getPassword());
        currentUser.setRole(user.getPassword());
        return userRepository.saveAndFlush(currentUser);
    }

    @Override
    public User delete(Long id) throws NotFoundException {
        User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("id: "+id));
        userRepository.deleteById(id);
        return user;
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
