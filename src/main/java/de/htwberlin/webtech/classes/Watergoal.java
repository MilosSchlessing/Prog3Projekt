package de.htwberlin.webtech.classes;

import jakarta.persistence.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Set;

@Entity
public class Watergoal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int ml;

    protected Watergoal() {}

    @ManyToOne
    @JoinColumn(name = "accoundID", referencedColumnName = "id")
    private Account user;

    public Long getId() {
        return id;
    }

    public int getMl() {
        return ml;
    }

    public void setMl(int price) {
        this.ml = price;
    }

    @Override
    public String toString() {
        return "Watergoal{" +
                "id=" + id +
                ", ml=" + ml +
                '}';
    }
}

