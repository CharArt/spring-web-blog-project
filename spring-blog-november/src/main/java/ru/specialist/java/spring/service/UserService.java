package ru.specialist.java.spring.service;

import ru.specialist.java.spring.entity.User;

import java.util.List;

public interface UserService {

    List<User> findByAll();
}
