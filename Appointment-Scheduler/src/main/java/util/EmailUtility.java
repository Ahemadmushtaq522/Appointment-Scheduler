package util;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtility {

    private static final String SMTP_HOST = "your_smtp_host";
    private static final int SMTP_PORT = 587;
    private static final String USERNAME = "your_email_username";
    private static final String PASSWORD = "your_email_password";

    public static void sendAppointmentConfirmation(String consultantEmail, String clientEmail) {
        // Set up mail server properties
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", SMTP_HOST);
        props.put("mail.smtp.port", SMTP_PORT);

        // Create the session with authentication
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USERNAME, PASSWORD);
            }
        });

        try {
            // Create a new message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(USERNAME));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(consultantEmail));
            message.setSubject("Appointment Confirmation");
            message.setText("Dear Consultant,\n\nYou have a new appointment.");

            // Send the message
            Transport.send(message);

            // Create a new message for the client
            message = new MimeMessage(session);
            message.setFrom(new InternetAddress(USERNAME));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(clientEmail));
            message.setSubject("Appointment Confirmation");
            message.setText("Dear Client,\n\nYour appointment is confirmed.");

            // Send the message to the client
            Transport.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
