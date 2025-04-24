public class musicEvent extends LiveEvent {
    private String type;
    private int numOfPerformers;

    public musicEvent(int eventID, String eventName, AgeRestrictionCategory restriction, int quantityInStock, double performanceFee, double ticketPrice, LiveEventCategory liveEventCategory, String type, int numOfPerformers) {
        super(eventID, eventName, restriction, quantityInStock, performanceFee, ticketPrice, liveEventCategory);
        this.type = type;
        this.numOfPerformers = numOfPerformers;
    }

    public String getType() {
        return this.type;
    }

    public int getNumOfPerformers() {
        return this.numOfPerformers;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + this.type + ", " + this.numOfPerformers + "\n";
    }
}
