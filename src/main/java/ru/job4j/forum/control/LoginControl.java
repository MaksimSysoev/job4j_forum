package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.LoginService;

@Controller
public class LoginControl {

    private final LoginService users;

    public LoginControl(LoginService users) {
        this.users = users;
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

    @RequestMapping(value="/registration", method = RequestMethod.POST)
    public String reg(@ModelAttribute User user) {
        users.reg(user);
        return "redirect:/registration/" + user.getId();
    }

}
