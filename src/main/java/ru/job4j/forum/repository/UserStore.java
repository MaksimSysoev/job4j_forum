package ru.job4j.forum.repository;


import org.springframework.stereotype.Repository;
import ru.job4j.forum.model.UserData;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class UserStore {

    private ConcurrentHashMap<Integer, UserData> users = new ConcurrentHashMap<>();
    private AtomicInteger id = new AtomicInteger(1);


    public UserStore() {
        users.put(id.getAndIncrement(), new UserData("admin", "1"));
    }


    public void add(UserData user) {
        this.users.put(id.getAndIncrement(), user);
    }

    public ConcurrentHashMap<Integer, UserData> getUsers() {
        return users;
    }
}
