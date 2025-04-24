public enum LiveEventCategory {
	Music,
	Performance;
	
	private LiveEventCategory() {
		
	}

	public static void main(String[] args) {
		try {
			LiveEventCategory category = LiveEventCategory.valueOf("Music");
			System.out.println("Event Category" + category);
		
			System.out.println("\nAll Event Categories: ");
			LiveEventCategory[] categories = LiveEventCategory.values();
			for (LiveEventCategory c : categories) {
				System.out.println(c);
			}
		} catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Error: Null name provided.");
        }
	
		System.out.println("\nOrdinal of Performance: " + LiveEventCategory.Performance.ordinal());
		System.out.println("\nOrdinal of Music: " + LiveEventCategory.Music.ordinal());
	
	}
}
