package de.htwberlin.webtech.classes;
import jakarta.persistence.*;
import org.springframework.web.bind.annotation.CrossOrigin;


@Entity
public class EmailReminder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String email;

    private boolean reminderEnabled;

    public EmailReminder() {}

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isReminderEnabled() {
        return reminderEnabled;
    }

    public void setReminderEnabled(boolean reminderEnabled) {
        this.reminderEnabled = reminderEnabled;
    }

}