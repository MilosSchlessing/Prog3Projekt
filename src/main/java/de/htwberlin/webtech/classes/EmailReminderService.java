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
            emailService.sendReminderEmail(emailReminder.getEmail(), "Reminder to stay hydrated!", "Das tägliche Trinken von ausreichend Wasser ist entscheidend für die Aufrechterhaltung unserer Gesundheit und unseres Wohlbefindens. Wasser ist ein lebensnotwendiges Element, das eine Vielzahl von wichtigen Funktionen in unserem Körper unterstützt.\n" +
                    "\n" +
                    "Erstens dient Wasser als Transportmittel für Nährstoffe, sodass sie in alle Zellen gelangen können. Es spielt auch eine zentrale Rolle bei der Regulierung der Körpertemperatur durch Schwitzen und Verdunstung. Darüber hinaus trägt ausreichende Wasserzufuhr zur Entgiftung des Körpers bei, indem es Abfallprodukte ausspült und die Nierenfunktion unterstützt.\n" +
                    "\n" +
                    "Eine angemessene Hydratation fördert die Aufrechterhaltung der Hautelastizität und hilft, das Auftreten von Hautproblemen zu minimieren. Darüber hinaus unterstützt Wasser die Funktion der Gelenke, indem es als Schmiermittel wirkt und so Bewegungen erleichtert.\n" +
                    "\n" +
                    "Konzentration und kognitive Leistungsfähigkeit profitieren ebenfalls von ausreichendem Wasserkonsum. Dehydration kann zu Müdigkeit, Konzentrationsproblemen und einer verminderten geistigen Leistungsfähigkeit führen.\n" +
                    "\n" +
                    "Insgesamt ist die tägliche Aufnahme von ausreichend Wasser also von entscheidender Bedeutung, um die verschiedenen Körperfunktionen aufrechtzuerhalten und eine optimale Gesundheit zu fördern. Es wird empfohlen, etwa 2-3 Liter Wasser pro Tag zu trinken, aber individuelle Bedürfnisse können je nach Aktivitätsniveau, Klima und Gesundheitszustand variieren. Daher ist es wichtig, auf die Signale des Körpers zu achten und sicherzustellen, dass man ausreichend hydriert bleibt.");
        }
    }
}