public class performanceEvent extends LiveEvent {
    private String type;
    private String language;

    public performanceEvent(int eventID, String eventName, AgeRestrictionCategory restriction, int quantityInStock, double performanceFee, double ticketPrice, LiveEventCategory liveEventCategory, String type, String language) {
        super(eventID, eventName, restriction, quantityInStock, performanceFee, ticketPrice, liveEventCategory);
        this.type = type;
        this.language = language;
    }

    public String getType() {
        return this.type;
    }

    public String getLanguage() {
        return this.language;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + this.type + ", " + this.language + "\n";
    }
}
