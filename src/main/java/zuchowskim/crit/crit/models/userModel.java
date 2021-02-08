package zuchowskim.crit.crit.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class userModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private String role;

    private String description;

    private String country;

    @OneToMany(mappedBy = "user")
    private List<reviewModel> reviews;

    public userModel() {
    }

    public List<reviewModel> getReviews() {
        return reviews;
    }

    public void setReviews(List<reviewModel> reviews) {
        this.reviews = reviews;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
