package task2;

import java.util.ArrayList;
import java.util.List;

import task2.auth.User;
import task2.offerings.Item;

public class Marketplace {

    private List<User> users = new ArrayList<User>();

    public boolean addUser(User user){
        if(users.size() < 10 && !ContainsUsername(user.getUsername())){
            return users.add(user);
        }
        return false;
    }

    public String str(){
        String allItems = "";

        if(users.size() == 0){
            return "No users found";
        }

        for(User currentUser: users){

            String userHeader = "Benutzer: " + currentUser.getUsername() + "\n";
            allItems += userHeader;

            for(Item currentItem: currentUser.getItems()){
                String itemName = "Item: " + currentItem.getName() + "; ";
                String itemPrice = "Preis: " + currentItem + "; ";
                String itemSeller = "Verkäufer: " + currentUser + "; ";
                String itemDescription = "Beschreibung: " + currentItem.getDescription();

                allItems += "[" + itemName + itemPrice + itemSeller + itemDescription + "]\n";
            }

        }

        return allItems;
    }

    private boolean ContainsUsername(String name){
        return users.stream().anyMatch(u -> u.getUsername().equals(name));
    }
}
