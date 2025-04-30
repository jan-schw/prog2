package task2.auth;

import task2.offerings.Item;

/**
 * Represents a user in a marketplace setting.
 * 
 * Represents a user in a marketplace settings.
 * Users are able to offer items on the marketplace
 * A user is associated with a username and password.
 * 
 * @author Kevin Schumann
 * @version 03/05/2023
 */
public class User {
    // Stores the username
    private String username;
    // Stores the password (extremly unsafe)
    private String password;
    // Stores the items that are offered. Some fields may be empty
    private Item[] items;

    /**
     * Constructs an user object with a given username
     * and password. User created with this method can
     * offer up to 10 items at a time.
     * 
     * @author Kevin Schumann
     * @param username Username of the user
     * @param password Password of the user
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.items = new Item[10];
    }

    /**
     * Returns the username.
     * 
     * @author Kevin Schumann
     * @return Username of the user
     */
	public String getUsername() {
		return this.username;
	}

    /**
     * Sets the username.
     * 
     * @author Kevin Schumann
     * @param username New username of the user
     */
	public void setUsername(String username) {
		this.username = username;
	}

    /**
     * Returns the password.
     * 
     * @author Kevin Schumann
     * @return Password of the user
     */
	public String getPassword() {
		return this.password;
	}

    /**
     * Sets the password.
     * 
     * @author Kevin Schumann
     * @param password New password of the user
     */
	public void setPassword(String password) {
		this.password = password;
	}

    /**
     * Returns the items offered by the user.
     * 
     * @author Kevin Schumann
     * @return Items that the user is offering
     */
	public Item[] getItems() {
		return this.items;
	}

    /**
     * Removes an item from the offered items.
     * 
     * @author Kevin Schumann
     * @param item Item that shall be removed
     * @return False if the item was not found, true otherwise.
     */
    public boolean removeItem(Item item) {
        for (int i = 0; i < this.items.length; i++) {
            if(item == this.items[i]) {
                this.items[i] = null;
                return true;
            }
        }

        return false;
    }

    /**
     * Adds an item from the offered items.
     * 
     * @author Kevin Schumann
     * @param item Item that shall be added
     * @return False if item could not be added, true otherwise.
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
     * Returns a string representation of the object.
     * 
     * @author Kevin Schumann
     * @return String representation of the object.
     */
    public String str() {
        // Password sollte vielleicht nicht ausgegeben werden.
        String res = this.username + " offers:\n";

        for(int i = 0; i < this.items.length; i++) {
            if(this.items[i] == null) {
                continue;
            }
            
            res += this.items[i].str();
        }

        return res;
    }
}