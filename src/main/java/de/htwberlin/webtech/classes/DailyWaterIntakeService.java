package de.htwberlin.webtech.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    public DailyWaterIntake findByWaterGoalIdAndDate(Long id, String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(date, formatter);

        return repository.findByWaterGoalIdAndDate(id, localDate);
    }

    public DailyWaterIntake update(Long id, String date, DailyWaterIntake newDailyWaterIntake) {
        // Convert the date string to a LocalDate
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(date, formatter);

        // Find the existing DailyWaterIntake
        DailyWaterIntake existingDailyWaterIntake = repository.findByWaterGoalIdAndDate(id, localDate);

        if (existingDailyWaterIntake == null) {
            throw new IllegalArgumentException("No DailyWaterIntake found with id " + id + " and date " + date);
        }

        // Update the properties of the existing DailyWaterIntake
        existingDailyWaterIntake.setMl(newDailyWaterIntake.getMl());
        // Add any other properties that should be updated

        // Save the updated DailyWaterIntake in the database
        return repository.save(existingDailyWaterIntake);
    }
}