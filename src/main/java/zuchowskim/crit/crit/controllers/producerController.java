package zuchowskim.crit.crit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import zuchowskim.crit.crit.models.gameModel;
import zuchowskim.crit.crit.models.gameRepository;
import zuchowskim.crit.crit.models.producerModel;
import zuchowskim.crit.crit.models.producerRepository;


import java.util.List;

@Controller
public class producerController {

    @Autowired
    private producerRepository producerRepository;

    @GetMapping("/producers")
    public String get(Model model)
    {

        model.addAttribute("producers", producerRepository.findAll());
        return "producers";
    }

    @GetMapping("/createProducer")
    public String create(Model model)
    {

//        List<producerModel> listProducers = (List<producerModel>) producerRepository.findAll();
//
//        model.addAttribute("producersList", listProducers);
        //System.out.println(listProducers);
        model.addAttribute("newProducer", new producerModel());
        return "createProducer";
    }

    @GetMapping("/editProducer{id}")
    public String edit(Model model, @PathVariable String id)
    {

        //List<producerModel> listProducers = (List<producerModel>) producerRepository.findAll();
        producerModel producer = producerRepository.findById(Integer.parseInt(id));

        //model.addAttribute("producersList", listProducers);
        //System.out.println(listProducers);
        //System.out.println(producer.getId());

        model.addAttribute("producer", producer);
        model.addAttribute("producerID", producer.getId());
        return "editProducer";
    }

    @PostMapping("/updateProducer")
    public String updateProducer(@ModelAttribute producerModel producer)
    {
        //System.out.println(game.getId());
        producerModel updatedProducer = producerRepository.findById(producer.getId());

        updatedProducer.setName(producer.getName());
        updatedProducer.setCountry(producer.getCountry());
        updatedProducer.setValue(producer.getValue());
        updatedProducer.setGames(producer.getGames());


        producerRepository.save(updatedProducer);
        return "redirect:/producers";
    }


    @PostMapping("/addProducer")
    public String addProducer(@ModelAttribute producerModel producer) {

        producerRepository.save(producer);
        return "redirect:/producers";
    }

    @GetMapping("/deleteProducer{id}")
    public String deleteProducer(@PathVariable String id) {

        producerModel producer = producerRepository.findById(Integer.parseInt(id));
        producerRepository.delete(producer);

        return "redirect:/producers";
    }

    @GetMapping("/detailsProducer{id}")
    public String details(Model model, @PathVariable String id) {

        producerModel producer = producerRepository.findById(Integer.parseInt(id));

        model.addAttribute("producer", producer);

        return "detailsProducer";
    }

}
