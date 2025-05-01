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

    private void showItemsOfCategory(){
        Category chosenCategory = getCategoryFromConsole();
        System.out.println(filterMarket(chosenCategory));
    }

    private void exitProgram(){
        System.out.println("Programm wird beendet");
        System.exit(0);
    }

    private void addNewItem(){
        System.out.println("Neues Item hinzufügen!");
        String name = this.getItemNameFromConsole();
        float price = this.getItemPriceFromConsole();
        String description = this.getItemDescriptionFromConsole();
        Category category = this.getCategoryFromConsole();

        Optional<User> foundUser = this.tryGetItemOwnerFromConsole();
        if(!foundUser.isPresent()){
            System.out.println("Benutzer nicht gefunden");
            return;
        }
        User user = foundUser.get();

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
        System.out.println("Item löschen!");
        String toBeDeleted = this.getItemNameFromConsole();
        boolean success = false;
        List<User> existingUsers = this.getExistingUsers();
        for(User current: existingUsers){
            Item[] items = current.getItems();
            Optional<Item> temp = tryToFindItem(toBeDeleted, items);
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
        System.out.println("Item bearbeiten!");
        String toBeEdited = this.getItemNameFromConsole();
        Item item = null;
        User owner = null;
        List<User> existingUsers = this.getExistingUsers();
        for(User current: existingUsers){
            Item[] items = current.getItems();
            Optional<Item> temp = this.tryToFindItem(toBeEdited, items);
            if(temp.isPresent()){
                owner = current;
                item = temp.get();
            }
        }

        if(owner == null || item == null){
            System.out.println("Editieren nicht möglich");
            return;
        }

        String newName = this.getItemNameFromConsole();
        item.setName(newName, owner);

        String newDescription = this.getItemDescriptionFromConsole();
        item.setDescription(newDescription, owner);
        	
        float newPrice = this.getItemPriceFromConsole();
        item.setPrice(newPrice, owner);
    }

    private List<User> getExistingUsers(){
        return Arrays.asList(this.users).stream().filter(u -> u != null).toList();
    }

    private Optional<Item> tryToFindItem(String itemName, Item[] items){
        return Arrays.asList(items).stream().filter(i -> i != null && i.getName().equals(itemName)).findFirst();
    }

    private String getItemNameFromConsole(){
        System.out.print("Name des Items?");
        String name = this.scanner.next();
        return name;
    }

    private float getItemPriceFromConsole(){
        System.out.print("Preis des Items?");
        float price = this.scanner.nextFloat();
        return price;
    }

    private Optional<User> tryGetItemOwnerFromConsole(){
        System.out.print("Besitzer des Items?");
        String owner = this.scanner.next();
        Optional<User> foundUser = Arrays.asList(users).stream().filter(u -> u != null).filter(x -> x.getUsername().equals(owner)).findFirst();
        return foundUser;
    }

    private String getItemDescriptionFromConsole(){
        System.out.print("Beschreibung des Items?");
        String description = this.scanner.next();
        return description;
    }

    private Category getCategoryFromConsole(){
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

    public boolean addUser(User user) {
        for (int i = 0; i < this.users.length; i++) {
            if (this.users[i] == null) {
                this.users[i] = user;
                return true;
            }

        }

        return false;
    }

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
