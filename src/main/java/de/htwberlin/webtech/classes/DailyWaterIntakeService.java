package de.htwberlin.webtech.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DailyWaterIntakeService {

    private final DailyWaterIntakeRepository repository;

    @Autowired
    public DailyWaterIntakeService(DailyWaterIntakeRepository repository) {
        this.repository = repository;
    }

    public DailyWaterIntake save(DailyWaterIntake dailyWaterIntake) {
        return repository.save(dailyWaterIntake);
    }

    public List<DailyWaterIntake> findAll() {
        return repository.findAll();
    }

    public List<DailyWaterIntake> findByWaterGoalId(Long id) {
        return repository.findByWaterGoalId(id);
    }
}