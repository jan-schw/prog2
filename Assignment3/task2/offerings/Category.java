package task2.offerings;

/**
 * The class represents categories for the items in the marketplace
 * Multiple different categories with the corresponding string representation
 * @author Jan Schweers
 * @version 24.04.2025
 */
public enum Category {
    /** Represents the different categories items can be sorted into */
    FURNITURE("Furniture"),
    ELECTRONICS("Electronics"),
    OTHER("Other");

    /** String representation of the current category */
    private String stringRepresentation;

    /**
     * Constructor for Category
     * @param rep string representation of the current category
     */
    private Category(String rep){
        this.stringRepresentation = rep;
    }

    /**
     * Returns string representation of current category
     * @return string representation
     */
    public String str(){
        return this.stringRepresentation;
    }
}
