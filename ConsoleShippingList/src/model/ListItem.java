package model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="shopping.items")

public class ListItem {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@Column(name="STORE")
	private String store;
	
	@Column(name="ITEM")
	private String item;
	
	//default constructor with no arguments
	public ListItem() {
		super();
	}
	
	// constructor with two arguments
	public ListItem(String store, String item) {
		this.store = store;
		this.item = item;
	}

	// getter method for id
	public int getId() {
		return id;
	}

	//setter method for id
	public void setId(int id) {
		this.id = id;
	}

	// getter method for score
	public String getStore() {
		return store;
	}

	//setter method for store
	public void setStore(String store) {
		this.store = store;
	}

	// getter method for item
	public String getItem() {
		return item;
	}
	
	// setter method for item
	public void setItem(String item) {
		this.item = item;
	}
	
	// Method to print store and item details
	public String returnItemDetails() {		
		return store + " " + item;
	}

	@Override
	public String toString() {
		return "ListItem [id=" + id + ", store=" + store + ", item=" + item + "]";
	}
	
	

}
