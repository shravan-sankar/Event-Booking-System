import java.time.LocalDate;

public class CreditCard implements PaymentMethod {
	private String cardNum;
	private String securityCode;
	
	public CreditCard(String newCardNum, String newSecurityCode) {
		this.cardNum = newCardNum;
		this.securityCode = newSecurityCode;
	}

	@Override
	public Receipt processPayment(double amount, Address fullAddress) {
		LocalDate today = LocalDate.now();
		String receiptInfo = String.format("%.2f paid by Credit Card using %s on %s, and the billing address is %s", amount, cardNum, today, fullAddress);
		return new Receipt(receiptInfo);
	}
}
