package de.htwberlin.webtech;

import de.htwberlin.webtech.classes.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.mockito.InjectMocks;
import org.mockito.Mock;


import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.any;
import static org.mockito.MockitoAnnotations.openMocks;

public class EmailServiceTest {

    @Mock
    private JavaMailSender emailSender;

    @InjectMocks
    private EmailService emailService;

    @Test
    public void testSendReminderEmail() {
        openMocks(this);

        String to = "test@example.com";
        String subject = "Test Subject";
        String text = "Test Text";

        emailService.sendReminderEmail(to, subject, text);

        verify(emailSender, times(1)).send(any(SimpleMailMessage.class));
    }
}