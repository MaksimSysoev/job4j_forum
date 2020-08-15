package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.User;
import ru.job4j.forum.store.UserRepository;

@Service
public class LoginService {

    private final UserRepository users;

    public LoginService(UserRepository users) {
        this.users = users;
    }

    public void reg(User user) {
        users.save(user);
    }
}
