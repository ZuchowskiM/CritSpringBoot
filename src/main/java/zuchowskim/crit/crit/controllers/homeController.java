package zuchowskim.crit.crit.controllers;

import org.bouncycastle.math.raw.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class homeController {

    @GetMapping("/")
    public String get()
    {
        return "home";
    }

    @GetMapping("/home")
    public String getHome()
    {
        return "home";
    }

}
