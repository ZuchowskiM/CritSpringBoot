package zuchowskim.crit.crit;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class helloController {

    @GetMapping("/")
    public String get(Model model)
    {
        model.addAttribute("name", "przemek");
        return "hello";
    }

}
