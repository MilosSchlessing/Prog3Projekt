package de.htwberlin.webtech.classes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailReminderService {
    private final EmailReminderRepository emailReminderRepository;
    private final EmailService emailService;

    @Autowired
    public EmailReminderService(EmailReminderRepository emailReminderRepository, EmailService emailService) {
        this.emailService = emailService;
        this.emailReminderRepository = emailReminderRepository;
    }

    public EmailReminder save(EmailReminder emailReminder) {
        return emailReminderRepository.save(emailReminder);
    }

    public EmailReminder findByEmail(String email) {
        return emailReminderRepository.findByEmail(email);
    }

    public void enableReminder(Long id) {
        EmailReminder emailReminder = emailReminderRepository.findById(id).orElseThrow(() -> new RuntimeException("EmailReminder not found"));
        emailReminder.setReminderEnabled(true);
        emailReminderRepository.save(emailReminder);
        if (emailReminder.isReminderEnabled()) {
            emailService.sendReminderEmail(emailReminder.getEmail(), "Reminder to stay hydrated!", "Hey don't forget to drink water and always remember to stay hydrated!");
        }
    }
}