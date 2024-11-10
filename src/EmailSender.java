import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.JOptionPane;
import java.util.Properties;

public class EmailSender {
    public static void sendEmail(String recipient, String subject, String body) {
        String sender = "your_email@example.com";
        String password = "your_password";

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.example.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(sender, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(sender));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
            message.setSubject(subject);
            message.setText(body);
            Transport.send(message);
            JOptionPane.showMessageDialog(null, "Email sent successfully");
        } catch (MessagingException e) {
            JOptionPane.showMessageDialog(null, "Failed to send email: " + e.getMessage() );
        }
    }
}