package com.alinatkachuk.springtask.dao;

import com.alinatkachuk.springtask.entity.User;

import java.util.List;

public interface UserDAO {

    public List<User> allUsers();

    public void addUser(User user);

    public void deleteUser(User user);

    public void editUser(User user);

    public User getUserById(Long id);

    public User getUserByEmail(String email);
}
