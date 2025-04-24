import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class AdminPanel extends JPanel {
    private JTextArea display;
    private JButton eventBtn, viewEventBtn;
    private EventManager eventManager;
    private musicEvent musicEvent;
    private performanceEvent performanceEvent;

    public AdminPanel() {
        String filename = "C:\\Users\\shrav\\eclipse-workspace\\OOP Coursework - Shravan Sankar\\src\\Stock.txt";
    	
        try {
            eventManager = new EventManager();
        } catch (IOException e) {
            e.printStackTrace();
        }

        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        display = new JTextArea();
        display.setEditable(false);
        JScrollPane scroll = new JScrollPane(display);
        scroll.setPreferredSize(new Dimension(400, 250));
        add(scroll, BorderLayout.CENTER);

        JPanel controls = new JPanel(new GridLayout(6, 2, 5, 5));

        eventBtn = new JButton("Add an Event");
        viewEventBtn = new JButton("View all events");

        viewEventBtn.addActionListener(e -> {
            eventManager.EventsFrom("C:\\Users\\shrav\\eclipse-workspace\\OOP Coursework - Shravan Sankar\\src\\Stock.txt");
            display.setText(eventManager.displayEvents());
        });

        controls.add(eventBtn);
        controls.add(viewEventBtn);

        eventBtn.addActionListener(e -> {
            String[] options = {"Music", "Performance"};
            int choice = JOptionPane.showOptionDialog(this, "Select the event type:", "Event Type",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            String category = options[choice];

            if (choice == 0) {
                String[] musicEventTypes = {"Live Concert", "DJ Set"};
                int musicEventTypeChoice = JOptionPane.showOptionDialog(null, "Select the type of music event:", "Music Event Type",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, musicEventTypes, musicEventTypes[0]);
                String eventType = musicEventTypes[musicEventTypeChoice];

                int numofPerformers = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the number of performers:"));

                String[] ageRestrictions = {"Adults", "All"};
                int ageRestrictionChoice = JOptionPane.showOptionDialog(null, "Select the age restriction:", "Age Restriction",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, ageRestrictions, ageRestrictions[0]);
                String ageRestriction = ageRestrictions[ageRestrictionChoice];

                int eventID = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the new event ID:"));
                String eventName = (JOptionPane.showInputDialog(null, "Please enter the new event name:"));
                int Stock = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the current stock:"));
                double Fee = Double.parseDouble(JOptionPane.showInputDialog(null, "Please enter the performance fee:"));
                double Price = Double.parseDouble(JOptionPane.showInputDialog(null, "Please enter the price:"));

                if (!eventManager.eventExists(eventID)) {
                musicEvent = new musicEvent(eventID, eventName, AgeRestrictionCategory.valueOf(ageRestriction), Stock, Fee, Price, LiveEventCategory.valueOf(category), eventType, numofPerformers);
                
                eventManager.addEvent(musicEvent);
        		
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
        			writer.write(eventID + ", " + "Music" + ", " + eventType + ", " + eventName + ", " + AgeRestrictionCategory.valueOf(ageRestriction) + ", " + Stock + ", " + Fee + ", " + Price + ", " + numofPerformers);
        			writer.newLine();
        		} catch (IOException i) {
        			i.printStackTrace();
        		}

                display.setText("Music event added:\n" + musicEvent.toString());
                } else {
                	display.setText("Event ID" + eventID + "already exists.");
                }
            
            } else if (choice == 1) {
                String[] performanceTypes = {"Stand-Up Comedy", "Theatre", "Magic"};
                int performanceTypeChoice = JOptionPane.showOptionDialog(null, "Select the type of performance:", "Performance Event Type",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, performanceTypes, performanceTypes[0]);
                String eventType = performanceTypes[performanceTypeChoice];

                String[] ageRestrictions = {"Adults", "All"};
                int ageRestrictionChoice = JOptionPane.showOptionDialog(null, "Select the age restriction:", "Age Restriction",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, ageRestrictions, ageRestrictions[0]);
                String ageRestriction = ageRestrictions[ageRestrictionChoice];

                String Language = JOptionPane.showInputDialog(null, "Please enter the language of the performance:");

                int eventID = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the new event ID:"));
                String eventName = (JOptionPane.showInputDialog(null, "Please enter the new event name:"));
                int Stock = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the current stock:"));
                double Fee = Double.parseDouble(JOptionPane.showInputDialog(null, "Please enter the performance fee:"));
                double Price = Double.parseDouble(JOptionPane.showInputDialog(null, "Please enter the price:"));

                if(!eventManager.eventExists(eventID)) {
                performanceEvent = new performanceEvent(eventID, eventName, AgeRestrictionCategory.valueOf(ageRestriction), Stock, Fee, Price, LiveEventCategory.valueOf(category), eventType, Language);
                
                
                eventManager.addEvent(performanceEvent);
        		
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
        			writer.write(eventID + ", " + "Performance" + ", " + eventType + ", " + eventName + ", " + AgeRestrictionCategory.valueOf(ageRestriction) + ", " + Stock + ", " + Fee + ", " + Price + ", " + Language);
        			writer.newLine();
        		} catch (IOException i) {
        			i.printStackTrace();
        		}

                display.setText("Performance event added:\n" + performanceEvent.toString());
                } else {
                	display.setText("Event ID" + eventID + "already exists.");
                }
            } 

        });

        add(controls, BorderLayout.SOUTH);
    }
}
