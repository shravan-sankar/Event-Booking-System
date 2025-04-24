import java.awt.Font;
import java.awt.GridLayout;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class UserPanel extends JPanel {
    private UserManager userManager;

    public UserPanel(GUI application) {
        try {
            userManager = new UserManager("C:\\Users\\shrav\\eclipse-workspace\\OOP Coursework - Shravan Sankar\\src\\UserAccounts.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        setLayout(null);
        setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));

        JLabel title = new JLabel("Performance Hall System", JLabel.CENTER);
        title.setFont(new Font("Courier New", Font.BOLD, 100));
        title.setBounds(20, 50, 1500, 100);
        add(title);

        JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 10, 10));

        JButton adminButton = new JButton("Admin");
        adminButton.setFont(new Font("Arial", Font.BOLD, 25));
        JButton customerButton = new JButton("Customer");
        customerButton.setFont(new Font("Arial", Font.BOLD, 25));

        adminButton.addActionListener(e -> login(application, "admin"));
        customerButton.addActionListener(e -> login(application, "customer"));

        buttonPanel.add(adminButton);
        buttonPanel.add(customerButton);

        buttonPanel.setBounds(260, 500, 1000, 250);
        add(buttonPanel);
    }

    private void login(GUI application, String role) {
        String username = JOptionPane.showInputDialog(this, "Please enter your username: ");
        
        if (username == null || username.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Error, please enter a valid username.");
            return;
        }

        Role userRole = userManager.authenticateUser(username);

        if (userRole == null) {
            String name = JOptionPane.showInputDialog(this, "Creating new account... Please enter your name: ");
            int houseNum = Integer.parseInt(JOptionPane.showInputDialog(this, "Please enter your house number: "));
            String postcode = JOptionPane.showInputDialog(this, "Please enter your postcode: ");
            String city = JOptionPane.showInputDialog(this, "Please enter your city: ");

            Address address = new Address(houseNum, postcode, city);
            String newUserID = null;

            try {
                newUserID = userManager.newUserID();
                userManager.addUser(username, name, houseNum, postcode, city, role);
            } catch (IOException ex) {
                ex.printStackTrace();
                return;
            }

            if (role.equalsIgnoreCase("admin")) {
                userRole = new Admin(newUserID, username, name, address);
            } else {
                userRole = new Customer(newUserID, username, name, address);
            }

            if (role.equals("admin")) {
                application.switchTab("Admin");
            } else {
                application.switchTab("Customer");
            }
            return;
        }

        String existingRole;
        if (userRole instanceof Admin) {
            existingRole = "admin";
        } else {
            existingRole = "customer";
        }

        if (!existingRole.equalsIgnoreCase(role)) {
            JOptionPane.showMessageDialog(this, "Access denied. This username is registered as " + existingRole.toUpperCase() + ".");
            return;
        }

        if (role.equals("admin")) {
            application.switchTab("Admin");
        } else {
            application.switchTab("Customer");
        }
    }
}
