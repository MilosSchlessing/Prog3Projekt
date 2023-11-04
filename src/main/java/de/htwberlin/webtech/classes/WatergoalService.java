package de.htwberlin.webtech.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WatergoalService {
    @Autowired
    WatergoalRepository repo;

    public Watergoal save (Watergoal goal) {
        return repo.save(goal);
    }

    public Watergoal get(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException());
    }

    public List<Watergoal> getAll() {
        Iterable<Watergoal> iterator = repo.findAll();
        List<Watergoal> goals = new ArrayList<Watergoal>();
        for (Watergoal goal : iterator)  goals.add(goal);
        return goals;
    }
}
