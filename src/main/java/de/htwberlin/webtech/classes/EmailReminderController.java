package de.htwberlin.webtech.classes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emailReminders")
@CrossOrigin(origins = {"http://localhost:8081", "http://localhost:8082"})
public class EmailReminderController {
    private final EmailReminderService emailReminderService;

    @Autowired
    public EmailReminderController(EmailReminderService emailReminderService) {
        this.emailReminderService = emailReminderService;
    }

    @PostMapping("/create")
    public EmailReminder create(@RequestBody EmailReminder emailReminder) {
        return emailReminderService.save(emailReminder);
    }

    @GetMapping("/{email}")
    public EmailReminder getEmailReminder(@PathVariable String email) {
        return emailReminderService.findByEmail(email);
    }
}