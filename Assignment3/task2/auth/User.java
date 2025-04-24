package task2.auth;

import task2.offerings.Item;

/**
 * Class User represents a user of the marketplace
 * The class manages personal details and all the offered items 
 * 
 * @author Jan Schweers
 * @version 24.04.2025
 */
public class User {
    /** Username of the current user */
    private String username;
    /** Password of the current user */
    private String password;
    /** All items the current user offers */
    private Item[] items;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.items = new Item[10];
    }

    /**
     * Getter for username
     * @return username
     */
	public String getUsername() {
		return this.username;
	}

    /**
     * Setter for username
     * @param username  new username
     */
	public void setUsername(String username) {
		this.username = username;
	}

    /**
     * Getter for password
     * @return password
     */
	public String getPassword() {
		return this.password;
	}

    /**
     * Setter for password
     * @param password  new password 
     */
	public void setPassword(String password) {
		this.password = password;
	}

    /**
     * Getter for items
     * @return items
     */
	public Item[] getItems() {
		return this.items;
	}

    /**
     * Removes item from the items of the user
     * @param item Item to be removed
     * @return  returns true if item was successfully removed
     */
    public boolean removeItem(Item item) {
        // There will be 'holes' in the array
        
        for (int i = 0; i < this.items.length; i++) {
            if(item == this.items[i]) {
                this.items[i] = null;
                return true;
            }
        }

        return false;
    }

    /**
     * Adds item to the items of the user
     * @param item Item to be added
     * @return  returns true if item was successfully added
     */
    public boolean addItem(Item item) {
        for (int i = 0; i < this.items.length; i++) {
            if(this.items[i] == null) {
                this.items[i] = item;
                return true;
            }
            
        }

        return false;
    }

    /**
     * Returns a string representation for the user and his items
     * @return String of his name and the items he offers
     */
    // wasnt required but good solution for marketplace str()
    public String str() {
        // password probably shouldnt be printed
        String res = this.username + " offers:\n";

        for(int i = 0; i < this.items.length; i++) {
            if(this.items[i] == null) {
                continue;
            }
            
            res += this.items[i].str() + "\n";
        }

        return res;
    }
}