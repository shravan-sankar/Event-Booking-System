import java.util.HashMap;
import java.util.Map;

public class Basket {
    private Map<LiveEvent, Integer> basketItems;

    public Basket() {
        this.basketItems = new HashMap<>();
    }

    public void addEvent(LiveEvent event, int quantity) {
        basketItems.put(event, quantity);
    }

    public double calculateTotal() {
        double total = 0;
        for (Map.Entry<LiveEvent, Integer> entry : basketItems.entrySet()) {
            total += entry.getKey().getTicketPrice() * entry.getValue();
        }
        return total;
    }

    public void clearBasket() {
        basketItems.clear();
    }
}
