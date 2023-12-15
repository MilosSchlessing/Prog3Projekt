package de.htwberlin.webtech.classes;

import jakarta.persistence.*;

import java.util.Set;

@Entity(name = "Account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private int passwordHash;

    @OneToMany(mappedBy = "user")
    private Set<Watergoal> goals;

    public Account(long id, String name, String password) {
        this.id = id;
        this.name = name;
        setPassword(password);
    }

    protected Account() {

    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setPassword(String password) {
        this.passwordHash = password.hashCode();
    }

    public boolean checkPassword(String password) {
        return this.passwordHash == password.hashCode();
    }
}