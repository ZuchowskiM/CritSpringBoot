package zuchowskim.crit.crit.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
public class gameModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private String description;

    private Date releaseDate;

    private String picture;

    private String type;

    private String platfroms;

    @ManyToOne
    private producerModel producer;

    @OneToMany(mappedBy = "game")
    private List<reviewModel> reviews;

    public gameModel() {

    }

    public gameModel(int id, String name, int producerID, String description, Date releaseDate, String picture, String type, String platfroms) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.releaseDate = releaseDate;
        this.picture = picture;
        this.type = type;
        this.platfroms = platfroms;
    }

    public List<reviewModel> getReviews() {
        return reviews;
    }

    public void setReviews(List<reviewModel> reviews) {
        this.reviews = reviews;
    }

    public producerModel getProducer() {
        return producer;
    }

    public void setProducer(producerModel producer) {
        this.producer = producer;
    }

    public String getPlatfroms() {
        return platfroms;
    }

    public void setPlatfroms(String platfroms) {
        this.platfroms = platfroms;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
