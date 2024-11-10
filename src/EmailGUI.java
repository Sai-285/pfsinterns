import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmailGUI {
    private static JTextArea inboxArea;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Email Client");
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel recipientLabel = new JLabel("To:");
        recipientLabel.setBounds(20, 20, 100, 30);
        frame.add(recipientLabel);

        JTextField recipientField = new JTextField();
        recipientField.setBounds(120, 20, 200, 30);
        frame.add(recipientField);

        JLabel subjectLabel = new JLabel("Subject:");
        subjectLabel.setBounds(20, 70, 100, 30);
        frame.add(subjectLabel);

        JTextField subjectField = new JTextField();
        subjectField.setBounds(120, 70, 100, 30);
        frame.add(subjectField);

        JLabel bodyLabel = new JLabel("Body:");
        bodyLabel.setBounds(20, 120, 100, 30);
        frame.add(bodyLabel);

        JTextArea bodyArea = new JTextArea();
        bodyArea.setBounds(120, 120, 250, 150);
        frame.add(bodyArea);

        JButton sendButton = new JButton("Send Email");
        sendButton.setBounds(150, 300, 120, 30);
        frame.add(sendButton);

        JButton reloadButton = new JButton("Refresh Inbox");
        reloadButton.setBounds(20, 350, 150, 30);
        frame.add(reloadButton);

        inboxArea = new JTextArea();
        inboxArea.setBounds(20, 400, 350, 150);
        inboxArea.setEditable(false);
        frame.add(inboxArea);


        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String recipient = recipientField.getText();
                String subject = subjectField.getText();
                String body = bodyArea.getText();
                EmailSender.sendEmail(recipient, subject, body);
            }
        });


        reloadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmailReceiver.checkEmail(inboxArea);
            }
        });

        frame.setVisible(true);

    }
}