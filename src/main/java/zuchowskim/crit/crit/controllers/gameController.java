package zuchowskim.crit.crit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import zuchowskim.crit.crit.models.gameModel;
import zuchowskim.crit.crit.models.gameRepository;
import zuchowskim.crit.crit.models.producerModel;
import zuchowskim.crit.crit.models.producerRepository;
import java.util.List;



@Controller
public class gameController {

    @Autowired
    private gameRepository gameRepository;

    @Autowired
    private producerRepository producerRepository;

    @GetMapping("/games")
    public String get(Model model)
    {

        model.addAttribute("games", gameRepository.findAll());
        return "games";
    }

    @GetMapping("/createGame")
    public String create(Model model)
    {

        List<producerModel> listProducers = (List<producerModel>) producerRepository.findAll();

        model.addAttribute("producersList", listProducers);
        //System.out.println(listProducers);
        model.addAttribute("newGame", new gameModel());
        return "createGame";
    }

    @GetMapping("/editGame{id}")
    public String edit(Model model, @PathVariable String id)
    {

        List<producerModel> listProducers = (List<producerModel>) producerRepository.findAll();
        gameModel game = gameRepository.findById(Integer.parseInt(id)).get();

        model.addAttribute("producersList", listProducers);
        //System.out.println(listProducers);
        System.out.println(game.getId());
        model.addAttribute("game", game);
        model.addAttribute("gameID", game.getId());
        return "editGame";
    }

    @PostMapping("/updateGame")
    public String updateGame(@ModelAttribute gameModel game)
    {
        System.out.println(game.getId());
        gameModel updatedGame = gameRepository.findById(game.getId()).get();

        updatedGame.setName(game.getName());
        updatedGame.setDescription(game.getDescription());
        updatedGame.setProducer(game.getProducer());
        updatedGame.setPicture(game.getPicture());
        updatedGame.setPlatfroms(game.getPlatfroms());
        updatedGame.setReleaseDate(game.getReleaseDate());
        updatedGame.setType(game.getType());

        gameRepository.save(updatedGame);
        return "redirect:/games";
    }


    @PostMapping("/addGame")
    public String addGame(@ModelAttribute gameModel game) {

        gameRepository.save(game);
        return "redirect:/games";
    }

    @GetMapping("/deleteGame{id}")
    public String deleteGame(@PathVariable String id) {

        gameModel game = gameRepository.findById(Integer.parseInt(id)).get();
        gameRepository.delete(game);

        return "redirect:/games";
    }

    @GetMapping("/detailsGame{id}")
    public String details(Model model, @PathVariable String id) {

        gameModel game = gameRepository.findById(Integer.parseInt(id)).get();

        model.addAttribute("game", game);

        return "detailsGame";
    }

}
