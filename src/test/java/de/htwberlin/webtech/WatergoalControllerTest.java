package de.htwberlin.webtech;

import de.htwberlin.webtech.classes.*;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = WebtechApplication.class)
public class WatergoalControllerTest {

    @InjectMocks
    private WatergoalController controller;

    @Mock
    private WatergoalService service;
    @Autowired
    private EmailService emailService;


    @Test
    public void testCreateWatergoal() {
        Watergoal goal = new Watergoal();
        when(service.save(goal)).thenReturn(goal);
        assertEquals(goal, controller.createWatergoal(goal));
    }

    @Test
    public void testGetWatergoal() {
        Watergoal goal = new Watergoal();
        when(service.get(1L)).thenReturn(goal);
        assertEquals(goal, controller.getWatergoal("1"));
    }

    @Test
    public void testGetAllWatergoals() {
        Watergoal goal1 = new Watergoal();
        Watergoal goal2 = new Watergoal();
        when(service.getAll()).thenReturn(Arrays.asList(goal1, goal2));
        List<Watergoal> goals = controller.getAllThings();
        assertEquals(2, goals.size());
        assertEquals(goal1, goals.get(0));
        assertEquals(goal2, goals.get(1));
    }

    @Test
    public void testUpdateWatergoal() {
        Watergoal existingGoal = new Watergoal();
        Watergoal updatedGoal = new Watergoal();
        updatedGoal.setMl(2000);
        when(service.get(1L)).thenReturn(existingGoal);
        when(service.save(existingGoal)).thenReturn(updatedGoal);
        assertEquals(updatedGoal, controller.updateWatergoal("1", updatedGoal));
    }

    @Test
    public void testSendReminderEmail() {
        // Erstellen Sie einen Mock des JavaMailSender
        JavaMailSender emailSender = Mockito.mock(JavaMailSender.class);

        // Erstellen Sie eine Instanz des EmailService mit dem Mock
        EmailService emailService = new EmailService(emailSender);

        // Rufen Sie die Methode sendReminderEmail auf
        emailService.sendReminderEmail("milos.8773@gmail.com", "Test Subject", "Test Text");

        // Überprüfen Sie, ob die Methode send des JavaMailSender einmal aufgerufen wurde
        Mockito.verify(emailSender, Mockito.times(1)).send(Mockito.any(SimpleMailMessage.class));
    }
    @Test
    public void testSendReminderEmail1() {
        // Rufen Sie die Methode sendReminderEmail auf
        emailService.sendReminderEmail("milos.8773@gmail.com", "Test Subject", "Test Text");
    }
}