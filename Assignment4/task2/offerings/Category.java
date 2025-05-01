package task2.offerings;

public enum Category {
    FURNITURE("Furniture"), 
    ELECTRONICS("Electronics"), 
    OTHER("OTHER");

    private final String repr;

    private Category(String repr) {
        this.repr = repr;
    }

    public String str() {
        return this.repr;
    }

    public boolean isSameCategory(Item item) {
        return item.getCategory() == this;
    }
}
