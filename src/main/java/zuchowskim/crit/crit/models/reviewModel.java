package zuchowskim.crit.crit.models;

import javax.persistence.*;

@Entity
public class reviewModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String text;

    private String title;

    private int rating;

    @ManyToOne
    private userModel user;

    @ManyToOne
    private  gameModel game;

    public reviewModel() {
    }

    public userModel getUser() {
        return user;
    }

    public void setUser(userModel user) {
        this.user = user;
    }

    public gameModel getGame() {
        return game;
    }

    public void setGame(gameModel game) {
        this.game = game;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
