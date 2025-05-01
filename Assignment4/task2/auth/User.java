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

    public String str() {
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