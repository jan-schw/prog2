package task2.auth;

import java.util.ArrayList;
import java.util.List;

import task2.offerings.Item;

public class User {
    private String username;
    private String password;
    private List<Item> items;

    public User(String username, String password){
        this.username = username;
        this.password = password;
        this.items = new ArrayList<Item>();
    }

    public boolean removeItem(Item item){
        return items.remove(item);
    }

    public boolean addItem(Item item){
        return items.add(item);
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public List<Item> getItems() {
        return items;
    }
}
