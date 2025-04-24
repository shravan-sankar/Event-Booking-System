public abstract class LiveEvent {
    private int eventID;
    private String eventName;
    private AgeRestrictionCategory restriction;
    private int quantityInStock;
    private double performanceFee;
    private double ticketPrice;
    private LiveEventCategory liveEventCategory;

    public LiveEvent(int eventID, String eventName, AgeRestrictionCategory restriction, int quantityInStock, double performanceFee, double ticketPrice, LiveEventCategory liveEventCategory) {
        this.eventID = eventID;
        this.eventName = eventName;
        this.restriction = restriction;
        this.quantityInStock = quantityInStock;
        this.performanceFee = performanceFee;
        this.ticketPrice = ticketPrice;
        this.liveEventCategory = liveEventCategory;
    }

    public AgeRestrictionCategory getAgeRestriction() {
        return this.restriction;
    }

    public LiveEventCategory getEventCategory() {
        return this.liveEventCategory;
    }

    public int getEventID() {
        return eventID;
    }

    public String getEventName() {
        return this.eventName;
    }

    public double getPerformanceFee() {
        return this.performanceFee;
    }

    public int getQuantityInStock() {
        return this.quantityInStock;
    }

    public double getTicketPrice() {
        return this.ticketPrice;
    }

    public void setQuantityInStock(int newQuantityInStock) {
        this.quantityInStock = newQuantityInStock;
    }

    @Override
    public String toString() {
        return this.eventID + ", " + this.liveEventCategory + ", " + this.eventName + ", " + this.restriction + ", " + this.quantityInStock + ", " + this.performanceFee + ", " + this.ticketPrice;
    }
}
