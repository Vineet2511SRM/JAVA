import javax.swing.*;
import java.awt.event.*;

public class AtmSimulation {
    private static double balance = 5000; // initial balance
    private static String pin = "1234";   // correct PIN

    public static void main(String[] args) {
        JFrame frame = new JFrame("ATM Simulation");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // --- Login panel ---
        JPanel loginPanel = new JPanel();
        JLabel label = new JLabel("Enter PIN: ");
        JPasswordField pinField = new JPasswordField(10);
        JButton loginBtn = new JButton("Login");
        loginPanel.add(label);
        loginPanel.add(pinField);
        loginPanel.add(loginBtn);

        frame.add(loginPanel);
        frame.setVisible(true);

        // Login action
        loginBtn.addActionListener(e -> {
            String enteredPin = new String(pinField.getPassword());
            if (enteredPin.equals(pin)) {
                showMenu(frame); // show menu if correct
            } else {
                JOptionPane.showMessageDialog(frame, "Wrong PIN!");
                pinField.setText("");
            }
        });
    }

    // --- Menu Panel ---
    private static void showMenu(JFrame frame) {
        JPanel menuPanel = new JPanel();
        JButton checkBtn = new JButton("Check Balance");
        JButton depositBtn = new JButton("Deposit");
        JButton withdrawBtn = new JButton("Withdraw");
        JButton exitBtn = new JButton("Exit");

        menuPanel.add(checkBtn);
        menuPanel.add(depositBtn);
        menuPanel.add(withdrawBtn);
        menuPanel.add(exitBtn);

        frame.setContentPane(menuPanel);
        frame.validate();

        checkBtn.addActionListener(e ->
                JOptionPane.showMessageDialog(frame, "Balance: ₹" + balance)
        );

        depositBtn.addActionListener(e -> {
            String input = JOptionPane.showInputDialog(frame, "Enter amount:");
            if (input != null) {
                double amt = Double.parseDouble(input);
                balance += amt;
                JOptionPane.showMessageDialog(frame, "Deposited ₹" + amt);
            }
        });

        withdrawBtn.addActionListener(e -> {
            String input = JOptionPane.showInputDialog(frame, "Enter amount:");
            if (input != null) {
                double amt = Double.parseDouble(input);
                if (amt <= balance) {
                    balance -= amt;
                    JOptionPane.showMessageDialog(frame, "Withdrawn ₹" + amt);
                } else {
                    JOptionPane.showMessageDialog(frame, "Insufficient Balance!");
                }
            }
        });

        exitBtn.addActionListener(e -> System.exit(0));
    }
}
