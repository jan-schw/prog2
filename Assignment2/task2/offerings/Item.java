package task2.offerings;

import task2.auth.User;

public class Item {
    private String name;
    private float price;
    private User seller;
    private String description;

    public Item(String name, float price, User seller, String description) {
        this.name = name;
        this.price = price;
        this.seller = seller;
        this.description = description;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public User getSeller() {
        return seller;
    }
    public void setSeller(User seller) {
        this.seller = seller;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
