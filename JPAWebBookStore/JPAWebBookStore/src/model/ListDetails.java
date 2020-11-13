package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="library.list_details")

public class ListDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="LIST_ID")
	private int id;
	
	@Column(name="LIST_NAME")
	private String listName;
	
	@Column(name="RENT_DATE")
	private LocalDate rentDate;
	
	@ManyToOne (cascade=CascadeType.PERSIST)
	@JoinColumn(name="CUSTOMER_ID")
	private Customer customer;	
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	
	@JoinTable
	  (
	      name="library.books_on_list",
	      joinColumns={ @JoinColumn(name="LIST_ID", referencedColumnName="LIST_ID") },
	      inverseJoinColumns={ @JoinColumn(name="ITEM_ID", referencedColumnName="ID", unique=true) }
	  )
	
	private List<BookClass> listOfBooks;	
	
	public ListDetails() {
		super();		
	}


	public ListDetails(int id, String listName, LocalDate rentDate,	Customer customer, List<BookClass> listOfBooks){
		super();
		this.id = id;
		this.listName = listName;
		this.rentDate = rentDate;
		this.customer = customer;
		this.listOfBooks = listOfBooks;
	}
		
		
	public ListDetails(String listName, LocalDate rentDate,	Customer customer, List<BookClass> listOfBooks){
		super();
		this.listName = listName;
		this.rentDate = rentDate;
		this.customer = customer;
		this.listOfBooks = listOfBooks;	
	}
			
	public ListDetails(String listName, LocalDate rentDate, Customer customer) {
		super();
		this.listName = listName;
		this.rentDate = rentDate;
		this.customer = customer;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getListName() {
		return listName;
	}
	public void setListName(String listName) {
		this.listName = listName;
	}
	public LocalDate getRentDate() {
		return rentDate;
	}
	public void setRentDate(LocalDate rentDate) {
		this.rentDate = rentDate;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public List<BookClass> getListOfBooks() {
		return listOfBooks;
	}

	public void setListOfBooks(List<BookClass> listOfBooks) {
		this.listOfBooks = listOfBooks;
	}


	@Override
	public String toString() {
		return "CustomerListDetails [id=" + id + ", ListName=" + listName + ", rentDate=" + rentDate + ", customer="
				+ customer + ", listOfBooks=" + listOfBooks + "]";
	}



}
