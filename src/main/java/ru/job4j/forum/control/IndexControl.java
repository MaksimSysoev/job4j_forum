package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.forum.service.PostService;

import java.io.Console;

@Controller
public class IndexControl {
    private final PostService posts;

    public IndexControl(PostService posts) {
        this.posts = posts;
    }

    @GetMapping({"/", "/index"})
    public String index(Model model) {
        model.addAttribute("posts", posts.getAll());
        return "index";
    }

    @GetMapping({"/registration"})
    @RequestMapping(value = {"/registration**"}, method = {RequestMethod.GET})
    public String reg(Model model) {
        return "reg";
    }

    @GetMapping({"/login"})
    public String loginPage(@RequestParam(value = "error", required = false) String error,
                            Model model) {
        String errorMessge = null;
        if(error != null) {
            errorMessge = "Username or Password is incorrect !!";
        }

        model.addAttribute("errorMessge", errorMessge);
        return "login";
    }


    @PostMapping({"/login"})
    public void loginPage(Model model){
         String user = model.getAttribute("username").toString();
         String password = model.getAttribute("password").toString();
    }
}