package de.htwberlin.webtech.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dailyWaterIntake")
@CrossOrigin(origins = {"http://localhost:8081", "http://localhost:8082"})
public class DailyWaterIntakeController {

    private final DailyWaterIntakeService service;

    @Autowired
    public DailyWaterIntakeController(DailyWaterIntakeService service) {
        this.service = service;
    }

    @PostMapping
    public DailyWaterIntake save(@RequestBody DailyWaterIntake dailyWaterIntake) {
        return service.save(dailyWaterIntake);
    }

    @GetMapping
    public List<DailyWaterIntake> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public List<DailyWaterIntake> findByWaterGoalId(@PathVariable Long id) {
        return service.findByWaterGoalId(id);
    }
}