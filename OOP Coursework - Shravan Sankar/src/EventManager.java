import java.io.*;
import java.util.*;

public class EventManager {
    private ArrayList<LiveEvent> events;
    private Role currentUser;
    String filename = "C:\\Users\\shrav\\eclipse-workspace\\OOP Coursework - Shravan Sankar\\src\\Stock.txt";

    public EventManager() throws FileNotFoundException, IOException {
        events = new ArrayList<>();
        EventsFrom(filename);
    }

    public void setCurrentUser(Role User) {
    	this.currentUser = User;
    }
    
    public void EventsFrom(String filename) {
        events.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                String[] values = line.split(",");
                if (values.length < 9) continue;

                try {
                    int ID = Integer.parseInt(values[0].trim());
                    LiveEventCategory category = LiveEventCategory.valueOf(values[1].trim());
                    String type = values[2].trim();
                    String eventName = values[3].trim();
                    AgeRestrictionCategory ageRestriction = AgeRestrictionCategory.valueOf(values[4].trim());
                    int stock = Integer.parseInt(values[5].trim());
                    double fee = Double.parseDouble(values[6].trim());
                    double price = Double.parseDouble(values[7].trim());
                    String extra = values[8].trim();

                    LiveEvent event;
                    if (category == LiveEventCategory.Music) {
                        int numOfPerformers = Integer.parseInt(extra);
                        event = new musicEvent(ID, eventName, ageRestriction, stock, fee, price, category, type, numOfPerformers);
                    } else {
                        String language = extra;
                        event = new performanceEvent(ID, eventName, ageRestriction, stock, fee, price, category, type, language);
                    }

                    events.add(event);

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
    // verification of user being admin before adding an event.
    public void addEvent(LiveEvent event) {
        if (currentUser instanceof Admin) {
            ((Admin) currentUser).addEvent(events, event);
        } else {
            System.out.println("event added.");
        }
    }
    
    public boolean eventExists(int eventID) {
        for (LiveEvent event : events) {
            if (event.getEventID() == eventID) {
                return true;
            }
        }
        return false;
    }
    
    public ArrayList<LiveEvent> getEvents() {
    	return events;
    }
    
    public String displayEvents() {
        List<LiveEvent> sortedEvents = new ArrayList<>(events);
        sortedEvents.sort(Comparator.comparingDouble(LiveEvent::getTicketPrice));
        
        StringBuilder sb = new StringBuilder();
        for (LiveEvent event : sortedEvents) {
            sb.append(event.toString()).append("");
        }
        return sb.toString();
    }
    
    public musicEvent IDSearch(int eventID) {
        for (LiveEvent event : events) {
            if (event instanceof musicEvent) {
                musicEvent music = (musicEvent) event;
                if (music.getEventID() == eventID) {
                    return music;
                }
            }
        }
        return null;
    }

    public ArrayList<performanceEvent> filterLanguage(String language) {
        ArrayList<performanceEvent> results = new ArrayList<>();
        for (LiveEvent event : events) {
            if (event instanceof performanceEvent) {
                performanceEvent performance = (performanceEvent) event;
                if (performance.getLanguage().equalsIgnoreCase(language)) {
                    results.add(performance);
                }
            }
        }
        return results;
    }
}