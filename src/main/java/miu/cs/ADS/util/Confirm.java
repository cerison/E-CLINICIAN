package miu.cs.ADS.util;

import java.sql.Time;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Confirm {
    public String confirmation(String fname, String lname, LocalDate date, Time time) {
        return "<!DOCTYPE html>"
                + "<html lang=\"en\">"
                + "<head>"
                + "<meta charset=\"UTF-8\">"
                + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">"
                + "<title>Appointment Confirmation</title>"
                + "</head>"
                + "<body style=\"font-family: Arial, sans-serif; background-color: #dddddd; margin: 0; padding: 0;\">"
                + "<div style=\"max-width: 700px; margin: 0 auto; background-color: #f4f4f4; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\">"
                + "<div style=\"background-color: #d3eafd; color: #333333; padding: 20px; text-align: center; margin-bottom: 30px;\">"
                + "<h1 style=\"color: #007bff; margin-top: 0;\">ADS CLINIC</h1>"
                + "<p style=\"margin-left: 40px;\">123 Main Street, City, Country</p>"
                + "<p style=\"margin-left: 40px;\">Phone: +123 456 7890</p>"
                + "</div>"
                + "<h2 style=\"color: #007bff; margin-top: 0; margin-left: 40px;\">Appointment Confirmation</h2>"
                + "<p style=\"margin-left: 40px;\">Dear " + fname + " " + lname + ",</p>"
                + "<p style=\"margin-left: 40px; margin-right: 40px;\">Thank you for booking your appointment with ADS. We are pleased to confirm your appointment as follows:</p>"
                + "<div style=\"margin-left: 20px;\">"
                + "<p style=\"margin-top: 20px; margin-bottom: 0; margin-left: 40px;\">Date: " + date.format(DateTimeFormatter.ofPattern("MMMM d, yyyy")) + " " + time.toLocalTime().format(DateTimeFormatter.ofPattern("h:mm a")) + "</p>"
                + "<p style=\"margin-top: 5px; margin-bottom: 0; margin-left: 40px;\">Doctor: Dr. John</p>"
                + "<p style=\"margin-top: 5px; margin-bottom: 0; margin-left: 40px;\">Department: Surgeon</p>"
                + "<p style=\"margin-top: 5px; margin-bottom: 20px; margin-left: 40px;\">Location: 123 Main Street, City, Country</p>"
                + "</div>"
                + "<p style=\"margin-left: 40px; margin-right: 40px;\">Please arrive 15 minutes prior to your scheduled appointment time to complete any necessary paperwork. Remember to bring your insurance card and a valid photo ID.</p>"
                + "<p style=\"margin-left: 40px; margin-right: 40px;\">If you have any questions or need to reschedule, please contact us at example@gmail.com.</p>"
                + "<p style=\"margin-left: 40px;\">We look forward to seeing you soon!</p>"
                + "<p style=\"margin-left: 40px;\">Best Regards,</p>"
                + "<p style=\"margin-left: 40px;\">ADS</p>"
                + "<div style=\"background-color: #d3eafd; color: #333333; padding: 20px; text-align: center; margin-top: 30px;\">"
                + "<p>© 2024 ADS. All Rights Reserved.</p>"
                + "</div>"
                + "</div>"
                + "</body>"
                + "</html>";
    }
}