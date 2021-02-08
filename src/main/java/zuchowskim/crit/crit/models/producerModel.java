package zuchowskim.crit.crit.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class producerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private String country;

    private int value;

    @OneToMany(mappedBy = "producer")
    private List<gameModel> games;

    public producerModel() {
    }

    public producerModel(String name, String country, int value)
    {
        this.name = name;
        this.country = country;
        this.value = value;
    }

    public List<gameModel> getGames() {
        return games;
    }

    public void setGames(List<gameModel> games) {
        this.games = games;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
