package ru.kata.springBoot.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.springBoot.dao.UserDAO;
import ru.kata.springBoot.entity.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional
    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Transactional
    @Override
    public void saveUSer(User user) {
        userDAO.saveUser(user);
    }

    @Transactional
    @Override
    public User getUser(int id) {
        return userDAO.getUser(id);
    }

    @Transactional
    @Override
    public void deleteUser(int id) {
        userDAO.deleteUser(id);
    }
}
