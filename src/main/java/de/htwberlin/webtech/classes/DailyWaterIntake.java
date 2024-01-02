package de.htwberlin.webtech.classes;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class DailyWaterIntake {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "water_goal_id")
    private Watergoal waterGoal;

    private LocalDate date;
    private int ml;

    public DailyWaterIntake() {}

    public DailyWaterIntake(LocalDate date, int ml) {
        this.date = date;
        this.ml = ml;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getMl() {
        return ml;
    }

    public void setMl(int ml) {
        this.ml = ml;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    public Watergoal getWaterGoal() {
        return waterGoal;
    }

    public void setWaterGoal(Watergoal waterGoal) {
        this.waterGoal = waterGoal;
    }
}
