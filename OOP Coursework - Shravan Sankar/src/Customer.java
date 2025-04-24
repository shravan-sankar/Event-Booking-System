public class Customer extends Role {
    private Basket basket;
    private PaymentMethod paymentMethod;

    public Customer(String userID, String username, String name, Address address) {
        super(userID, username, name, address);
        this.basket = new Basket();
    }

    
    public void setPaymentMethod(PaymentMethod paymentMethod) {
    	this.paymentMethod = paymentMethod;
    }

    public void addToBasket(LiveEvent event, int quantity) {
        this.basket.addEvent(event, quantity);
        System.out.println(quantity + " tickets added to the basket for: " + event.getEventName());
    }

    public void completePurchase(Address fullAddress) {
        if (paymentMethod == null) {
            System.out.println("No payment method selected.");
        }       
    
    double totalAmount = this.basket.calculateTotal();
    System.out.println("Total Amount: " + totalAmount);
    
    Receipt completedPayment = paymentMethod.processPayment(totalAmount, fullAddress);
    if (completedPayment.isSuccessful()) {
    	System.out.println("Payment successful, Thank you for your purchase!");
    	this.basket.clearBasket();
    } else {
    	System.out.println("Payment error, please try again.");
    	}
    }
}