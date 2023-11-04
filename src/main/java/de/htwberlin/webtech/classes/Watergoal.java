package de.htwberlin.webtech.classes;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Watergoal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int ml;

    public Watergoal() {}

    public Watergoal(String name, int ml) {
        this.name = name;
        this.ml = ml;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMl() {
        return ml;
    }

    public void setMl(int price) {
        this.ml = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Watergoal)) return false;

        Watergoal watergoal = (Watergoal) o;

        if (getMl() != watergoal.getMl()) return false;
        if (getId() != null ? !getId().equals(watergoal.getId()) : watergoal.getId() != null) return false;
        return getName() != null ? getName().equals(watergoal.getName()) : watergoal.getName() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + getMl();
        return result;
    }

    @Override
    public String toString() {
        return "Watergoal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ml=" + ml +
                '}';
    }
}

