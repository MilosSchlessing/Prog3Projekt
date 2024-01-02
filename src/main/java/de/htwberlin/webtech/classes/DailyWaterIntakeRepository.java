package de.htwberlin.webtech.classes;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DailyWaterIntakeRepository extends JpaRepository<DailyWaterIntake, Long> {
    List<DailyWaterIntake> findByWaterGoalId(Long id);

}