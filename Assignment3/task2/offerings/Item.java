package task2.offerings;

import task2.auth.User;

/**
 * The class represents an item being sold on the marketplace
 * Each item has an owner and a category, as well as multiple defining characteristics
 * @author Jan Schweers
 * @version 24.04.2025
 */
public class Item {
    /* 
    Items sollten generell nur durch den Owner
    änderbar sein. Kann allerdings auch erst später
    durch die business logik realisiert werden

    Price darf nicht unter 0 liegen.
    */
    /** Name of the current item */
    private String name;
    /** Price of the current item */
    private float price;
    /** Owner of the current item */
    private User owner;
    /** Description of the current item */
    private String description;
    /** Category of the current item */
    private Category category;

    /**
     * Constructor for Item
     * @param name sets name
     * @param price sets price
     * @param owner sets owner
     * @param description sets description
     * @param category sets category
     */
    public Item(String name, float price, User owner, String description, Category category) {
        this.name = name;
        this.price = price;
        this.owner = owner;
        this.description = description;
        this.category = category;
    }

    /**
     * Returns a string representation of the current item
     * Includes all of the defining characteristics of the item
     * @return string representation
     */
    public String str() {
        return String.format(
            "Item: %s; Price: %.2f, User: %s, Description: %s, Category: %s",
            name,
            price,
            owner.getUsername(),
            description,
            category.str()
        );
    }

    /**
     * Getter for name
     * @return name
     */
	public String getName() {
		return this.name;
	}

    /**
     * Setter for name
     * Only the owner of the current item can change its name
     * @param name new name
     * @param callee caller of the method
     */
	public void setName(String name, User callee) {
        if(callee != owner) {
            return;
        }

		this.name = name;
	}

    /**
     * Getter for price
     * @return price
     */
	public float getPrice() {
		return this.price;
	}

    /**
     * Only the owner of the current item can change its price
     * @param price new price
     * @param callee caller of the method
     */
	public void setPrice(float price, User callee) {
        if(callee != owner || price < 0.0) {
            return;
        }

		this.price = price;
	}

    /**
     * Getter for user
     * Returns the owner of the current item
     * @return
     */
	public User getUser() {
		return this.owner;
	}

    /**
     * Getter for description
     * @return description
     */
	public String getDescription() {
		return this.description;
	}

    /**
     * Setter for description
     * Only the owner of an item can change its description
     * @param description new description
     * @param callee caller of the method
     */
	public void setDescription(String description, User callee) {
        if(callee != owner) {
            return;
        }
        
		this.description = description;
	}

    /**
     * Getter for category
     * @return category
     */
    public Category getCategory() {
        return category;
    }
}