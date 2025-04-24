import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GUI extends JFrame {
    private CardLayout layout;
    private JPanel panel;

    public GUI() {
        setTitle("Performance Hall");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        layout = new CardLayout();
        panel = new JPanel(layout);

        panel.add(new UserPanel(this), "User Selection");

        try {
            panel.add(new AdminPanel(), "Admin");
            panel.add(new CustomerPanel(), "Customer");
        } catch (IOException e) {
            e.printStackTrace();
        }

        add(panel);
        layout.show(panel, "User Selection");
    }

    public void switchTab(String newPanel) {
        layout.show(panel, newPanel);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GUI().setVisible(true));
    }
}