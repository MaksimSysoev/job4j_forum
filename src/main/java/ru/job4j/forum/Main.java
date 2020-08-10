package ru.job4j.forum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class Main extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Main.class);
    }
    public static void main(String[] args) {
        //UserStore store = new UserStore();
        //store.add(new User("admin", "1"));
        SpringApplication.run(Main.class, args);
    }
}