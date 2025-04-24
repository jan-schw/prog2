package task2.offerings;

public enum Category {
    FURNITURE("Furniture"),
    ELECTRONICS("Electronics"),
    OTHER("Other");

    private String stringRepresentation;

    private Category(String rep){
        this.stringRepresentation = rep;
    }

    public String str(){
        return this.stringRepresentation;
    }
}
