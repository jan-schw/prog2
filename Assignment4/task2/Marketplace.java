package task2;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import task2.auth.*;
import task2.offerings.*;

public class Marketplace {
    private Scanner scanner;
    private User[] users;

    public Marketplace() {
        this.users = new User[10];
        this.scanner = new Scanner(System.in);
    }

    public void cli(){
        //loop runs while as long as exitProgram is not called
        while(true){
            printOptions();
            int chosenOption = this.scanner.nextInt();
            switch (chosenOption) {
                case 1:
                    addNewItem();
                    break;
                case 2:
                    deleteItem();
                    break;
                case 3:
                    editItem();
                    break;
                case 4: 
                    showItemsOfCategory();
                    break;
                case 5:
                    exitProgram();
                    break;
                default:
                    exitProgram();
                    break;
            }
        }
    }

    private void addNewItem(){
        User user = null;
        System.out.print("Name des Items?");
        String name = this.scanner.next();
        System.out.print("Preis des Items?");
        float price = this.scanner.nextFloat();

        System.out.print("Besitzer des Items?");
        String owner = this.scanner.next();
        Optional<User> foundUsers = Arrays.asList(users).stream().filter(u -> u != null).filter(x -> x.getUsername().equals(owner)).findFirst();

        if(foundUsers.isPresent()){
            user = foundUsers.get();
        }
        else{
            System.out.println("Benutzer nicht gefunden");
            return;
        }
        System.out.print("Beschreibung des Items?");
        String description = this.scanner.next();

        Category category = getCategoryFromInput();

        Item newItem = new Item(name, price, user, description, category);

        boolean success = user.addItem(newItem);
        if(success){
            System.out.println("Item erfolgreich hinzugefügt");
        }
        else{
            System.out.println("Item konnte nicht hinzugefügt werden");
        }
    }

    private void deleteItem(){
        System.out.println("Name des zu löschenden Items?");
        String toBeDeleted = scanner.next();
        boolean success = false;
        List<User> existingUsers = Arrays.asList(users).stream().filter(u -> u != null).toList();
        for(User current: existingUsers){
            Item[] items = current.getItems();
            Optional<Item> temp = Arrays.asList(items).stream().filter(i -> i != null && i.getName().equals(toBeDeleted)).findFirst();
            if(temp.isPresent()){
                success = current.removeItem(temp.get());
            }
        }
        if(success){
            System.out.println("Item erfolgreich gelöscht");
        }
        else{
            System.out.println("Item konnte nicht gelöscht werden");
        }
    }

    private void editItem(){
        System.out.println("Name des zu bearbeitenden Items?");
        String toBeEdited = scanner.next();
        Item item = new Item();
        User owner = null;
        List<User> existingUsers = Arrays.asList(users).stream().filter(u -> u != null).toList();
        for(User current: existingUsers){
            Item[] items = current.getItems();
            Optional<Item> temp = Arrays.asList(items).stream().filter(i -> i != null && i.getName().equals(toBeEdited)).findFirst();
            if(temp.isPresent()){
                owner = current;
                item = temp.get();
            }
        }

        System.out.println("Was soll der neue Name sein?");
        String newName = this.scanner.next();
        item.setName(newName, owner);

        System.out.println("Was soll die neue Beschreibung sein?");
        String newDescription = this.scanner.next();
        item.setDescription(newDescription, owner);
        	
        System.out.println("Was soll der neue Preis sein?");
        float newPrice = this.scanner.nextFloat();
        item.setPrice(newPrice, owner);

    }

    private Category getCategoryFromInput(){
        System.out.println("Welche Kategorie?");
        System.out.println("1. Furniture");
        System.out.println("2. Electronics");
        System.out.println("3. Other");

        int chosenCategory = this.scanner.nextInt();

        switch (chosenCategory) {
            case 1:
                return Category.FURNITURE;
            case 2:
                return Category.ELECTRONICS;
            case 3:
                return Category.OTHER;
            default:
                return null;
        }
    }

    private void showItemsOfCategory(){
        Category chosenCategory = getCategoryFromInput();
        System.out.println(filterMarket(chosenCategory));

    }

    private void exitProgram(){
        System.out.println("Programm wird beendet");
        System.exit(0);
    }

    private void printOptions(){
        System.out.println("Wählen Sie eine der folgenden Optionen:");
        System.out.println("1. Item hinzufügen");
        System.out.println("2. Item entfernen");
        System.out.println("3. Item Name, Beschreibung und Preis ändern");
        System.out.println("4. Alle Items einer Kategorie anzeigen");
        System.out.println("5. Programm beenden");
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

        //market.login();
        // System.out.println(market.filterMarket(Category.OTHER));
        // System.out.println(market.filterMarket(Category.ELECTRONICS));
        // System.out.println(market.filterMarket(null));
        market.cli();
    }
}
