package de.htwberlin.webtech.classes;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailReminderRepository extends JpaRepository<EmailReminder, Long> {
    EmailReminder findByEmail(String email);
}