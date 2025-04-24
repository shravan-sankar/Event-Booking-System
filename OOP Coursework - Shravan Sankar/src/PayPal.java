import java.time.LocalDate;

public class PayPal implements PaymentMethod {
	private String email;
	
	public PayPal(String newEmail) {
		this.email = newEmail;
	}

	@Override
	public Receipt processPayment(double amount, Address fullAddress) {
		LocalDate today = LocalDate.now();
		String receiptInfo = String.format("%.2f paid via PayPal using %s on %s, and the billing address is %s", amount, email, today, fullAddress);
		return new Receipt(receiptInfo);
	}
}
