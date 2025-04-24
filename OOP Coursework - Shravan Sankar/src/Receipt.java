public class Receipt {
	private String transactionID;
	
	public Receipt(String newTransactionID) {
		this.transactionID = newTransactionID;
	}
	
	public String getTransactionID() {
		return this.transactionID;
	}
	
	public boolean isSuccessful() {
		return transactionID != null;
	}

	@Override
	public String toString() {
		return "Receipt: " + transactionID;
	}

}
