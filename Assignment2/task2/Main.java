package task2;

import task2.auth.User;
import task2.offerings.Item;

public class Main {
    
    public static void main(String[] args) {
        Marketplace market = new Marketplace();

        System.out.println(market.str());

        User user = new User("User1", "pw123");
        market.addUser(user);
        System.out.println(market.str());

        Item item = new Item("Banane", 5, user, "Wunderbar gebogen");
        user.addItem(item);
        System.out.println(market.str());

        user.removeItem(item);
        System.out.println(market.str());
    }
}
