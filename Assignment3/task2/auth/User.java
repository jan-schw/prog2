package task2.auth;

import task2.offerings.Item;

public class User {
    private String username;
    private String password;
    private Item[] items;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.items = new Item[10];
    }

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Item[] getItems() {
		return this.items;
	}


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

    public boolean addItem(Item item) {
        for (int i = 0; i < this.items.length; i++) {
            if(this.items[i] == null) {
                this.items[i] = item;
                return true;
            }
            
        }

        return false;
    }

    // wasnt required but good solution for marketplace str()
    public String str() {
        // password probably shouldnt be printed
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