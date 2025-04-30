package task2.offerings;

/**
 * This class represents the categories 
 * a item can be in the setting of a 
 * digital marketplace. 
 * 
 * Each enum value represents a category
 * with a unique string representation.
 * 
 * @author Kevin Schumann
 * @version 23/04/2024
 */
public enum Category {
    FURNITURE("Furniture"), 
    ELECTRONICS("Electronics"), 
    OTHER("OTHER");

    // Stores the string representation.
    private final String repr;

    /**
     * Constructs the object.
     * 
     * @author Kevin Schumann
     * @param repr Representation of the object.
     */
    private Category(String repr) {
        this.repr = repr;
    }

    /**
     * Returns the string representation of the object.
     * 
     * @author Kevin Schumann
     * @return String representation of the object.
     */
    public String str() {
        return this.repr;
    }

    /**
     * Checks if the given item is within the same
     * category as the enum value.
     * 
     * @author Kevin Schumann
     * @param item Item that shall be compared to the enum value
     * @return True if the items is within the same category, otherwise false.
     */
    public boolean isSameCategory(Item item) {
        // possible way to filter items later on
        return item.getCategory() == this;
    }
}
