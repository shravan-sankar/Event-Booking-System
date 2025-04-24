public enum AgeRestrictionCategory {
	All,
	Adults;
	
	private AgeRestrictionCategory() {
		
	}

	public static void main(String[] args) {
		try {
			AgeRestrictionCategory category = AgeRestrictionCategory.valueOf("All");
			System.out.println("Age Category" + category);
		
			System.out.println("\nAll Age Categories: ");
			AgeRestrictionCategory[] categories = AgeRestrictionCategory.values();
			for (AgeRestrictionCategory c : categories) {
				System.out.println(c);
			}
		} catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Error: Null name provided.");
        }
	
		System.out.println("\nOrdinal of Performance: " + AgeRestrictionCategory.All.ordinal());
		System.out.println("\nOrdinal of Music: " + AgeRestrictionCategory.Adults.ordinal());
	
	}
}
