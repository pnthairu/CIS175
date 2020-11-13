package model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="library.books")

// Book class
public class BookClass{
	
	// Unit id variable
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	// declaring id variable
	@Column(name="ID")
	private int id;
	
	// declaring name variable
	@Column(name="ISBN")
	private String isbn;
	
	// declaring author variable
	@Column(name="AUTHOR")
	private String bookAuthor;
	
	// declaring title variable
	@Column(name="TITLE")
	private String bookTitle;
	
	// declaring price variable
	@Column(name="PRICE")
	private double price;
	
	// BookClass method with no arguments
	public BookClass() {
		super();
	}
	
	// Book Class method with three arguments
	public BookClass(String isbn, String author, String title) {
		this.isbn = isbn;
		this.bookAuthor = author;
		this.bookTitle = title;
	}
	
	//BookClass with four arguments
	public BookClass(String isbn, String author, String title, double price) {
		super();
		this.isbn = isbn;
		this.bookAuthor = author;
		this.bookTitle = title;
		this.price = price;
		
	}

	// Getter method for id
	public int getId() {
		return id;
	}

	// Setter method for id
	public void setId(int id) {
		this.id = id;
	}

	// getter method for book ISBN number
	public String getISBN() {
		return isbn;
	}

	// setter method for book ISBN number
	public void setISBN(String isbn) {
		this.isbn = isbn;
	}

	// getter method for book author name
	public String getBookAuthor() {
		return bookAuthor;
	}

	// setter method for book author name
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	
	// getter method for book title
	public String getBookTitle() {
		return bookTitle;
	}

	// setter method for book title
	public void setBookTitle(String title) {
		this.bookTitle = title;
	}

	// getter method for book price	
	public double getPrice() {
		return price;
	}
	
	// setter method for book price
	public void setPrice(double price) {
		this.price = price;
	}

	//Method to display isbn, author, title and price of the books
	public String returnItemDetails() {			
		
		return isbn + " " + bookAuthor + " " + bookTitle + " " + price;
	}
	
	//Method to display author and title	
	public String returnAuthorTitle() {
		
		return bookAuthor + " " + bookTitle;
	}

	@Override
	public String toString() {		
		return "BookClass [ISBN=" + isbn + ", bookAuthor=" + bookAuthor + ", bookTitle=" + bookTitle + ", price =" + price +"]";
	}
	
	
}
