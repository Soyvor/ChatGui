import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatGUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextArea chatArea;
    private JTextField messageField;

    public ChatGUI() {
        // Set up the JFrame
        setTitle("Chat Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 400));

        // Create the chat area
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatArea);

        // Create the message field
        messageField = new JTextField();
        messageField.addActionListener(event -> sendMessage());

        // Add the components to the JFrame
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(messageField, BorderLayout.SOUTH);
        add(panel);

        // Pack and show the JFrame
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void sendMessage() {
        String message = messageField.getText();
        chatArea.append("You: " + message + "\n");
        messageField.setText("");
    }

    public static void main(String[] args) {
        new ChatGUI();
    }
}
