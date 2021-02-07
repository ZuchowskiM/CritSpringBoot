package zuchowskim.crit.crit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import zuchowskim.crit.crit.models.gameModel;
import zuchowskim.crit.crit.models.gameRepository;

import java.util.ArrayList;
import java.util.List;


@Controller
public class gameController {

    @Autowired
    private gameRepository gameRepository;

    @GetMapping("/games")
    public String get(Model model)
    {
//        gameModel game1 = new gameModel(1,"lol",1,"nice",null,null,null);
//        gameModel game2 = new gameModel(2,"wot",2,"bad",null,null, null);
//        List<gameModel> games = new ArrayList<>();
//
//        games.add(game1);
//        games.add(game2);
//
//        model.addAttribute("games", games);
        model.addAttribute("newGame", new gameModel());
        model.addAttribute("games", gameRepository.findAll());
        return "games";
    }


    @PostMapping("/addGame")
    public String addCar(@ModelAttribute gameModel game) {

        gameRepository.save(game);
        return "redirect:/games";
    }


}
