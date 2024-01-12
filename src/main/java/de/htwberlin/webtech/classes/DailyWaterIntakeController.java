package de.htwberlin.webtech.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dailyWaterIntake")
@CrossOrigin(origins = {"http://localhost:8081", "http://localhost:8082", "https://frontend-ivh3.onrender.com/"})
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

    @GetMapping("/{id}/{date}")
    public DailyWaterIntake findByWaterGoalIdAndDate(@PathVariable Long id, @PathVariable String date) {
        return service.findByWaterGoalIdAndDate(id, date);
    }
    @PutMapping("/{id}/{date}")
    public DailyWaterIntake update(@PathVariable Long id, @PathVariable String date, @RequestBody DailyWaterIntake newDailyWaterIntake) throws ChangeSetPersister.NotFoundException {
        return service.update(id, date, newDailyWaterIntake);
    }

}