import java.util.List;

public class Admin extends Role {
	
    public Admin(String userID, String username, String name, Address address) {
        super(userID, username, name, address);
    }
    
    
	public void addEvent(List<LiveEvent> events, LiveEvent newEvent) {
		events.add(newEvent);
		System.out.println("New event added: " + newEvent);
	}
}
