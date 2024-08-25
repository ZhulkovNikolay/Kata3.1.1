package ru.kata.springBoot.service;

import ru.kata.springBoot.entity.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUsers();

    public void saveUSer(User user);

    public User getUser(int id);

    public void deleteUser(int id);

}
