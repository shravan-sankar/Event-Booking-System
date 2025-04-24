public class Address {
	private int houseNum;
	private String city;
	private String postcode;
	
	public Address(int newHouseNum, String newCity, String newPostcode) {
		this.houseNum = newHouseNum;
		this.city = newCity;
		this.postcode = newPostcode;
	}
	
	@Override
	public String toString() {
		return houseNum + ", " + city + ", " + postcode;
	}
}
