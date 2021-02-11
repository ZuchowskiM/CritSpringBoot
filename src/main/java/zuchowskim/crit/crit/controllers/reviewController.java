package zuchowskim.crit.crit.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import zuchowskim.crit.crit.models.*;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Controller
public class reviewController {

    @Autowired
    reviewRepository reviewRepository;

    @Autowired
    gameRepository gameRepository;

    @Autowired
    userRepository userRepository;

    @GetMapping("/reviews")
    public String get(Model model, String keyword)
    {
        Predicate<reviewModel> byName = review -> review.getGame().getName().toLowerCase().contains(keyword.toLowerCase());
        List<reviewModel> reviews = (List<reviewModel>) reviewRepository.findAll();

        if (keyword!=null)
        {
            reviews = reviews.stream().filter(byName).collect(Collectors.toList());
        }

        model.addAttribute("reviews", reviews);
        return "reviews";
    }

    @GetMapping("/createReview")
    public String create(Model model)
    {

        List<gameModel> listGames = (List<gameModel>) gameRepository.findAll();
        List<userModel> userModels = (List<userModel>) userRepository.findAll();

        model.addAttribute("gamesList", listGames);
        model.addAttribute("usersList", userModels);
        //System.out.println(listProducers);
        model.addAttribute("newReview", new reviewModel());

        return "createReview";
    }

    @GetMapping("/editReview{id}")
    public String edit(Model model, @PathVariable String id)
    {

        List<gameModel> listGames = (List<gameModel>) gameRepository.findAll();
        List<userModel> userModels = (List<userModel>) userRepository.findAll();

        reviewModel review = reviewRepository.findById(Integer.parseInt(id)).get();

        model.addAttribute("gamesList", listGames);
        model.addAttribute("usersList", userModels);

        //System.out.println(review.getId());
        model.addAttribute("review", review);
        model.addAttribute("reviewID", review.getId());
        return "editReview";
    }


    @PostMapping("/updateReview")
    public String update(@ModelAttribute reviewModel review)
    {
        //System.out.println(review.getId());

        reviewModel updatedReview = reviewRepository.findById(review.getId()).get();

        updatedReview.setTitle(review.getTitle());
        updatedReview.setRating(review.getRating());
        updatedReview.setGame(review.getGame());
        updatedReview.setUser(review.getUser());
        updatedReview.setText(review.getText());


        reviewRepository.save(updatedReview);
        return "redirect:/reviews";
    }

    @PostMapping("/addReview")
    public String add(@ModelAttribute reviewModel review) {

        reviewRepository.save(review);
        return "redirect:/reviews";
    }

    @GetMapping("/deleteReview{id}")
    public String delete(@PathVariable String id) {

        reviewModel review = reviewRepository.findById(Integer.parseInt(id)).get();
        reviewRepository.delete(review);

        return "redirect:/reviews";
    }

    @GetMapping("/detailsReview{id}")
    public String details(Model model, @PathVariable String id) {

        reviewModel review = reviewRepository.findById(Integer.parseInt(id)).get();
        //System.out.println(review.getText());

        model.addAttribute("review", review);

        return "detailsReview";
    }

}
