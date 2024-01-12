package de.htwberlin.webtech;

import de.htwberlin.webtech.classes.Watergoal;
import de.htwberlin.webtech.classes.WatergoalRepository;
import de.htwberlin.webtech.classes.WatergoalService;
import de.htwberlin.webtech.classes.WebtechApplication;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.ArgumentMatchers.any;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

@SpringBootTest(classes = WebtechApplication.class)
public class WatergoalServiceTest {

    @Autowired
    private WatergoalService watergoalService;

    @MockBean
    private WatergoalRepository repository;

    @Test
    @DisplayName("should save a watergoal")
    void testSave() {
        Watergoal goal = new Watergoal();
        goal.setMl(500);
        doReturn(goal).when(repository).save(any(Watergoal.class));

        Watergoal savedGoal = watergoalService.save(goal);

        assertEquals(savedGoal.getMl(), 500);
    }

    @Test
    @DisplayName("should find a watergoal by its id")
    void testGet() {
        Watergoal goal = new Watergoal();
        goal.setMl(500);
        doReturn(Optional.of(goal)).when(repository).findById(42L);

        Watergoal foundGoal = watergoalService.get(42L);

        assertEquals(foundGoal.getMl(), 500);
    }

    @Test
    @DisplayName("should find all watergoals")
    void testGetAll() {
        Watergoal goal1 = new Watergoal();
        goal1.setMl(500);
        Watergoal goal2 = new Watergoal();
        goal2.setMl(600);
        doReturn(Arrays.asList(goal1, goal2)).when(repository).findAll();

        List<Watergoal> goals = watergoalService.getAll();

        assertEquals(goals.size(), 2);
        assertEquals(goals.get(0).getMl(), 500);
        assertEquals(goals.get(1).getMl(), 600);
    }
}