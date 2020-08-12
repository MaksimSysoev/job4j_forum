package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostControl {
    @GetMapping({"/addpost"})
    public String post(Model model) {
        return "post";
    }
}
