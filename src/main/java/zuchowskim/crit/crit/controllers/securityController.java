package zuchowskim.crit.crit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import zuchowskim.crit.crit.models.userModel;
import zuchowskim.crit.crit.models.userRepository;

@Controller
public class securityController {

    @Autowired
    userRepository userRepository;

    @GetMapping("/login")
    public String get()
    {
        return "login";
    }

    @GetMapping("/register")
    public String get(Model model)
    {
        model.addAttribute("newUser", new userModel());
        return "register";
    }

    @PostMapping("/addUser")
    public String addGame(@ModelAttribute userModel user) {

        user.setRole("critic");
        userRepository.save(user);
        return "redirect:/home";
    }

}
