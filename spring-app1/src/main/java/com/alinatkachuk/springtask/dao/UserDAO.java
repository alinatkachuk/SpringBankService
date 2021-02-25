package com.alinatkachuk.springtask.dao;

import com.alinatkachuk.springtask.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> showUsers() {
        return jdbcTemplate.query("SELECT * FROM DataUser", new BeanPropertyRowMapper<>(User.class));
    }

    public void saveUsers (User user) {
        jdbcTemplate.update("INSERT INTO DataUser VALUES(?, ?, ?, ?)", user.getFirstName(), user.getLastName(),
                user.getEmail(), user.getPassword());
     }
}
