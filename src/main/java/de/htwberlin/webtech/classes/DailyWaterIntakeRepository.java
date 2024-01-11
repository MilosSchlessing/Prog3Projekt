package de.htwberlin.webtech.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public interface DailyWaterIntakeRepository extends JpaRepository<DailyWaterIntake, Long> {
    List<DailyWaterIntake> findByWaterGoalId(Long id);
    DailyWaterIntake findByWaterGoalIdAndDate(Long id, LocalDate date);
}
