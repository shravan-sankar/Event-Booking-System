import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

class CustomerPanel extends JPanel {
        private JTextArea display;
        private JButton viewBtn, basketBtn, payBtn;
        private EventManager eventManager;
        private Basket basket;

        public CustomerPanel() throws IOException {
        	eventManager = new EventManager();
            basket = new Basket();

            setLayout(new BorderLayout());
            setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

            display = new JTextArea();
            display.setEditable(false);
            JScrollPane scroll = new JScrollPane(display);
            scroll.setPreferredSize(new Dimension(400, 250));
            add(scroll, BorderLayout.CENTER);

            JPanel controls = new JPanel();
            viewBtn = new JButton("View Events");
            basketBtn = new JButton("View Basket");
            payBtn = new JButton("Checkout");

            viewBtn.addActionListener(e -> display.setText(eventManager.displayEvents()));
            basketBtn.addActionListener(e -> display.setText(basket.toString()));
            payBtn.addActionListener(e -> showPaymentDialog());

            controls.add(viewBtn);
            controls.add(basketBtn);
            controls.add(payBtn);
            add(controls, BorderLayout.SOUTH);
        }

        private void showPaymentDialog() {
            String[] options = {"PayPal", "Credit Card"};
            int choice = JOptionPane.showOptionDialog(this, "Choose Payment Method", "Checkout",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            int houseNum = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter House Number:"));
            String postcode = JOptionPane.showInputDialog(this, "Enter Postcode:");
            String city = JOptionPane.showInputDialog(this, "Enter City:");
            Address fullAddress = new Address(houseNum, postcode, city);

            if (choice == 0) {
                String email = JOptionPane.showInputDialog(this, "Enter PayPal Email:");
                PaymentMethod paypal = new PayPal(email);
                Receipt receipt = paypal.processPayment(basket.calculateTotal(), fullAddress);
                display.setText(receipt.toString());
                basket.clearBasket();
            } else if (choice == 1) {
                String cardNumber = JOptionPane.showInputDialog(this, "Enter 6-digit Card Number:");
                String secCode = JOptionPane.showInputDialog(this, "Enter 3-digit Security Code:");
                PaymentMethod credit = new CreditCard(cardNumber, secCode);
                Receipt receipt = credit.processPayment(basket.calculateTotal(), fullAddress);
                display.setText(receipt.toString());
                basket.clearBasket();
            }
        }
    }