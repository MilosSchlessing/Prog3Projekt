package de.htwberlin.webtech;

import de.htwberlin.webtech.classes.EmailReminder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailReminderTest {
    private EmailReminder emailReminder;

    @BeforeEach
    void setUp() {
        emailReminder = new EmailReminder();
    }


    @Test
    void testEmail() {
        String email = "test@example.com";
        emailReminder.setEmail(email);
        assertEquals(email, emailReminder.getEmail());
    }

    @Test
    void testReminderEnabled() {
        emailReminder.setReminderEnabled(true);
        assertTrue(emailReminder.isReminderEnabled());

        emailReminder.setReminderEnabled(false);
        assertFalse(emailReminder.isReminderEnabled());
    }
}