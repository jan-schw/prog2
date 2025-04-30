package task2;

import java.util.Scanner;

import task2.auth.*;
import task2.offerings.*;

/**
 * This class represents a digital marketplace.
 * 
 * Items are offered on this marketplace by user,
 * which can be added to this marketplace.
 * 
 * @author Kevin Schumann
 * @version 23/04/2024
 */
public class Marketplace {
    // users of this marketplace
    private User[] users;

    /**
     * Constructs a marketplace object with
     * maximum 10 users.
     * 
     * @author Kevin Schumann
     */
    public Marketplace() {
        this.users = new User[10];
    }

    public User login() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            System.out.println("Benutzername?");
            String username = scanner.nextLine();
            System.out.println("Passwort?");
            String password = scanner.nextLine();

            for (User current : this.users) {
                if(current != null){
                    boolean matchingUsernameFound = current.getUsername().compareTo(username) == 0;
                    boolean matchingPasswordFound = current.getPassword().compareTo(password) == 0;
    
                    if (matchingUsernameFound && matchingPasswordFound) {
                        System.out.println("Richtige Eingabe!");
                        scanner.close();
                        return current;
                    }

                }
            }
            int remainingTries = 2 - i;
            System.out.println(String.format("Falsche Eingabe! Noch %d Versuche über", remainingTries));
        }
        System.exit(0);
        scanner.close();
        return null;
    }

    /**
     * Returns a string representation of the marketplace
     * 
     * @author Kevin Schumann
     * @return String representation of the item.
     */
    public String str() {
        String res = "";

        for (int i = 0; i < this.users.length; i++) {
            if (this.users[i] == null) {
                continue;
            }

            res += this.users[i].str();
            res += "\n\n";
        }

        return res;
    }

    /**
     * Adds an user to the marketplace.
     * 
     * @author Kevin Schumann
     * @param user User that shall be added.
     * @return False if user limit has been reached, else true.
     */
    public boolean addUser(User user) {
        for (int i = 0; i < this.users.length; i++) {
            if (this.users[i] == null) {
                this.users[i] = user;
                return true;
            }

        }

        return false;
    }

    /**
     * Returns string of all items that belong to as the given category.
     * Iff category is null all items will be printed like
     * in the str() function.
     * 
     * @author Kevin Schumann
     * @param category Category that shall be printed. Can be null. If null all
     *                 items will be printed.
     * @return String of all the items that belong to the given category.
     */
    public String filterMarket(Category category) {
        // this if was not demanded by the task
        if (category == null) {
            return this.str();
        }

        String res = "";
        for (int i = 0; i < users.length; i++) {
            if (this.users[i] == null) {
                continue;
            }

            Item[] items = this.users[i].getItems();
            for (int j = 0; j < items.length; j++) {
                if (items[j] == null) {
                    continue;
                }

                if (category.isSameCategory(items[j])) {
                    res += items[j].str();
                }
            }

            res += "\n";
        }

        return res;
    }

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
                Category.OTHER);

        Item two = new Item(
                "Hut",
                100,
                second,
                "Toller Hut. Keine Anfragen, wie 'was letzter Preis'.",
                Category.OTHER);

        first.addItem(one);
        second.addItem(two);

        market.addUser(first);
        market.addUser(second);

        market.login();
        // System.out.println(market.filterMarket(Category.OTHER));
        // System.out.println(market.filterMarket(Category.ELECTRONICS));
        // System.out.println(market.filterMarket(null));
    }
}
