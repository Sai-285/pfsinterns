import javax.mail.*;
import javax.swing.*;
import java.util.Properties;

public class EmailReceiver {
    public static void checkEmail(JTextArea inboxArea) {
        String host = "imap.example.com";
        String user = "your_email@example.com";
        String password = "your_password";

        try {
            Properties properties= new Properties();
            properties.put("mail.imap.host", host);
            properties.put("mail.imap.port", "993");
            properties.put("mail.imap.ssl.enable", "true");

            Session emailSession = Session.getInstance(properties);
            Store store = emailSession.getStore("imap");
            store.connect(user, password);

            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);
            Message[] messages = emailFolder.getMessages();

            inboxArea.setText("");
            for(Message message : messages) {
                inboxArea.append("Email Subject" + message.getSubject() + "\n");
            }

            emailFolder.close(false);
            store.close();
        } catch (Exception e) {
            inboxArea.setText("Failed to check email: " + e.getMessage());
        }
    }
}