package task2.offerings;


import task2.auth.User;

public class Item {
    
    private String name;
    private float price;
    private User owner; 
    private String description;
    private Category category;

    public Item(String name, float price, User owner, String description, Category category) {
        this.name = name;
        this.price = price;
        this.owner = owner;
        this.description = description;
        this.category = category;
    }

    public Item(){
        
    }

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

	public String getName() {
		return this.name;
	}

    public void setName(String name, User callee) {
        if(callee != owner) {
            return;
        }

		this.name = name;
	}

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price, User callee) {
        if(callee != owner || price < 0.0) {
            return;
        }

		this.price = price;
	}

	public User getUser() {
		return this.owner;
	}

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category, User callee) {
        if(callee != owner) {
            return;
        }

		this.category = category;
    }

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description, User callee) {
        if(callee != owner) {
            return;
        }
        
		this.description = description;
	}
}