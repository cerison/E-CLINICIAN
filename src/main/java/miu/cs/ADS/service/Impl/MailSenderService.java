package miu.cs.ADS.service.Impl;
import io.github.cdimascio.dotenv.Dotenv;
import jakarta.mail.internet.MimeMessage;
import miu.cs.ADS.util.Confirm;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
@Component
public class MailSenderService {

    private final JavaMailSender mailSender;

    public MailSenderService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    Dotenv dotenv = Dotenv.configure().load();
    private String sender = dotenv.get("SENDER");

    public void sendEmail(String to, String fname, String lname, LocalDate date, Time time) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom(sender);
            helper.setTo(sender);
            helper.setSubject("Appointment Confirmation – "+date.format(DateTimeFormatter.ofPattern("MMMM d, yyyy")));

            String htmlContent = new Confirm().confirmation(fname,lname,date,time);

            helper.setText(htmlContent, true);
            mailSender.send(message);
            System.out.println("Email sent successfully.");
        } catch (Exception e) {
            System.out.println("Failed to send email. Error: " + e.getMessage());
        }
    }
}
