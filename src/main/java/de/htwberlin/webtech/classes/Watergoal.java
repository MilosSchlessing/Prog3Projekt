package de.htwberlin.webtech.classes;

import jakarta.persistence.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Set;

@Entity
public class Watergoal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "water_goal_id")
    private Watergoal waterGoal;
    private int ml;
    private String name;

    public Watergoal() {}

    public Long getId() {
        return id;
    }

    public int getMl() {
        return ml;
    }

    public void setMl(int price) {
        this.ml = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "Watergoal{" +
                "id=" + id +
                ", ml=" + ml +
                ", name=" + name + '\'' +
                '}';
    }
}

