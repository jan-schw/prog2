package task2;

import task2.auth.*;
import task2.offerings.*;

/**
 * This class represents a marketplace and manages all the users and items in it
 * Users can have multiple items they offer so sell
 * @author Jan Schweers
 * @version 24.04.2025
 */
public class Marketplace {
    /** List of all the users in the marketplace */
    private User[] users;

    /** Constructor for Marketplace, initializes array */
    public Marketplace() {
        this.users = new User[10];
    }

    /**
     * Returns string representation of the marketplace
     * Includes all users with their items
     * @return string representation
     */
    public String str() {
        String res = "";
        
        for(int i = 0; i < this.users.length; i++) {
            if(this.users[i] == null) {
                continue;
            }
            
            res += this.users[i].str();
            res += "\n\n";
        }

        return res;
    }

    /**
     * Returns a string representation of the marketplace for a single category of item
     * @param category category for the filtering
     * @return string representation of all offered items of the chosen category
     */
    public String filterMarket(Category category){
        String res = "";
        
        for(User user: this.users) {
            if(user != null){
                res += user.getUsername() + " offers:\n";

                Item[] items = user.getItems();
                for(Item item: items){
                    if(item != null && item.getCategory().equals(category)){
                        res += item.str() + "\n";
                    }
                }
                res += "\n\n";
            }
        }

        return res;
    }

    /**
     * Adds a user to the marketplace
     * Only if there is still space
     * @param user new user to be added
     * @return returns true if successfull
     */
    public boolean addUser(User user) {
        for (int i = 0; i < this.users.length; i++) {
            if(this.users[i] == null) {
                this.users[i] = user;
                return true;
            }
            
        }

        return false;
    }

    /**
     * Main method for testing and running the marketplace
     * @param args sound of someone taking an arrow to the knee
     */
    public static void main(String[] args) {
        // Main Methode darf auch in Main-Klasse sein.
        Marketplace market = new Marketplace();

        User first = new User("Max", "1234");
        User second = new User("Maxine", "4321");

        Item one = new Item(
            "Sandalen",
            10,
            first,
            "Neue Sandalen schwarz. Festpreis!",
            Category.OTHER
        );

        Item two = new Item(
            "Hut",
            100,
            second,
            "Toller Hut. Keine Anfragen, wie 'was letzter Preis'.",
            Category.OTHER
        );

        Item three = new Item(
            "Maus",
            50,
            second,
            "Kabelgebunden, pflegeleicht",
            Category.ELECTRONICS
        );

        first.addItem(one);
        second.addItem(two);
        second.addItem(three);
        
        market.addUser(first);
        market.addUser(second);


        System.out.println(market.str());

        one.setPrice(50, first);
        //market.removeUser(second);
        
        System.out.println(market.str());

        System.out.println(market.filterMarket(Category.OTHER));

        System.out.println(market.filterMarket(Category.ELECTRONICS));
    }

    /**
     * Removes a user from the marketplace
     * Wasnt implemented in the Musterlösung
     *@param second user to be removed
     */
    private void removeUser(User second) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeUser'");
    }
}

