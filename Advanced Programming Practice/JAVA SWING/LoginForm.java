import javax.swing.*;       // Importing Swing components for GUI
import java.awt.event.*;    // Importing event classes for handling actions

// Main class
public class LoginForm {
    public static void main(String[] args) {

        // === Creating the Frame (Main Window) ===
        JFrame frame = new JFrame("Login Form");   // Window with title "Login Form"

        // === Username Label and Text Field ===
        JLabel userLabel = new JLabel("Username:"); // Label for username
        userLabel.setBounds(50, 50, 100, 30);       // Position (x,y) and size (width, height)

        JTextField userText = new JTextField();     // Input field for username
        userText.setBounds(150, 50, 150, 30);       // Position and size

        // === Password Label and Password Field ===
        JLabel passLabel = new JLabel("Password:"); // Label for password
        passLabel.setBounds(50, 100, 100, 30);

        JPasswordField passText = new JPasswordField(); // Secure password input field
        passText.setBounds(150, 100, 150, 30);

        // === Login Button ===
        JButton loginButton = new JButton("Login"); // Button with text "Login"
        loginButton.setBounds(150, 150, 100, 30);

        // === Action Listener for Button (Controller) ===
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get entered username and password
                String user = userText.getText();
                String pass = new String(passText.getPassword());

                // Check credentials (simple validation)
                if (user.equals("admin") && pass.equals("123")) {
                    JOptionPane.showMessageDialog(frame, "Login Successful!"); // Success message
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid Credentials"); // Error message
                }
            }
        });

        // === Adding Components to Frame ===
        frame.add(userLabel);
        frame.add(userText);
        frame.add(passLabel);
        frame.add(passText);
        frame.add(loginButton);

        // === Frame Settings ===
        frame.setSize(400, 300);                   // Window size
        frame.setLayout(null);                     // No layout manager (absolute positioning)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close program when window closes
        frame.setVisible(true);                    // Make frame visible
    }
}

//Login Form (TextField, PasswordField, Button)