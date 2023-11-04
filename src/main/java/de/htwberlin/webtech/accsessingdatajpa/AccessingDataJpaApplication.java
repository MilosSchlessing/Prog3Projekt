package de.htwberlin.webtech.accsessingdatajpa;

import de.htwberlin.webtech.classes.Watergoal;
import de.htwberlin.webtech.classes.WatergoalRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccessingDataJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccessingDataJpaApplication.class, args);
    }


}
