import javax.swing.*;
import java.awt.event.*;

public class ShoppingCart {
    public static void main(String[] args) {
        // === Create Frame ===
        JFrame frame = new JFrame("Shopping Cart Simulation");

        // === Create Checkboxes with items and prices ===
        JCheckBox laptop = new JCheckBox("Laptop - ₹50,000");
        laptop.setBounds(50, 50, 200, 30);

        JCheckBox phone = new JCheckBox("Phone - ₹25,000");
        phone.setBounds(50, 100, 200, 30);

        JCheckBox headphones = new JCheckBox("Headphones - ₹2,000");
        headphones.setBounds(50, 150, 200, 30);

        // === Create Button ===
        JButton billButton = new JButton("Generate Bill");
        billButton.setBounds(50, 200, 150, 40);

        // === Add Action Listener for Button ===
        billButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int total = 0;
                StringBuilder items = new StringBuilder("Items Purchased:\n");

                // Check selected items
                if (laptop.isSelected()) {
                    total += 50000;
                    items.append("- Laptop (₹50,000)\n");
                }
                if (phone.isSelected()) {
                    total += 25000;
                    items.append("- Phone (₹25,000)\n");
                }
                if (headphones.isSelected()) {
                    total += 2000;
                    items.append("- Headphones (₹2,000)\n");
                }

                // If no item is selected
                if (total == 0) {
                    JOptionPane.showMessageDialog(frame, "No items selected!");
                } else {
                    items.append("\nTotal: ₹" + total);
                    JOptionPane.showMessageDialog(frame, items.toString());
                }
            }
        });

        // === Add components to frame ===
        frame.add(laptop);
        frame.add(phone);
        frame.add(headphones);
        frame.add(billButton);

        // === Frame Settings ===
        frame.setSize(400, 350);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
