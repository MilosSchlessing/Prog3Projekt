package de.htwberlin.webtech;

import de.htwberlin.webtech.classes.EmailService;
import de.htwberlin.webtech.classes.WebtechApplication;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
@SpringBootTest(classes = WebtechApplication.class)
public class EmailServiceTest {
    @Autowired
    private EmailService emailService;
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