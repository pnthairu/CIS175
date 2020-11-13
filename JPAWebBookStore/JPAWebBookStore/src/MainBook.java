import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import controller.BookHelper;
import model.BookClass;

public class MainBook {
	
	static Scanner in = new Scanner(System.in);
	static BookHelper lih = new BookHelper();

	// method to add new book
	private static void addAnItem(){		
		// user input for Book name
		System.out.print("Please enter the book ISBN: ");			
		String sbno = " ";
		sbno = in.nextLine();
		
		// user input for author first and last names		
		String firstName = "";
		String secondName = "";
		String authorFullName = "";
		authorFullName =  firstName + " " + secondName;
		
		// user input for author full name
		System.out.print("Please enter author full names: ");
		authorFullName = in.nextLine();
		
		// user input for book title
		System.out.print("Please enter the book Title: ");	
		String title = " ";
		title = in.nextLine();
		
		//Price user input
		System.out.print("Please book price: ");	
		double price = 0;
		price = in.nextDouble();

		// adding isbn, author, title and price to the list
		BookClass toAdd = new BookClass(sbno, authorFullName, title, price);
		lih.insertBook(toAdd);
	}
	
	//method to delete book
	private static void deleteLibBook() {
		//user input for isbn number
		System.out.print("Please enter ISBN to be deleted: ");			
		String sbno = " ";
		sbno = in.nextLine();
		
		// user input for author first and last names		
		String firstName = "";
		String secondName = "";
		String authorFullName = "";
		
		// Concatenating  first and last names
		authorFullName =  firstName + " " + secondName;
		
		// user input for author name
		System.out.print("Please enter book author full name to be deleted: ");
		authorFullName = in.nextLine();
		
		//user input for title of the book
		System.out.print("Please enter the book title to delete: ");	
		String title = " ";
		title = in.nextLine();				
				
		BookClass toDelete = new BookClass(sbno, authorFullName, title);
		lih.deleteBook(toDelete);
	}
	
	// Method to edit book details
	private static void editBook() {				
		System.out.println("How would you like to search? ");
		
		// User input to search for a store to be edited
		System.out.println("1 : Search by Author Name");
		
		// User input to search for an item to be edited
		System.out.println("2 : Search by Book Title");
		int searchBy = in.nextInt();
		in.nextLine();
		
		List<BookClass> foundBooks;
			if (searchBy == 1) {
				System.out.print("Enter the author name: ");
				String authorName = in.nextLine();
				foundBooks = lih.searchForBooksByAuthor(authorName);
			} else {
				System.out.print("Enter the book title: ");
				String bookTitle = in.nextLine();
				foundBooks = lih.searchForBookByTitle(bookTitle);
			}
			if (!foundBooks.isEmpty()) {
				System.out.println("Found Results.");
					for (BookClass l : foundBooks) {
					System.out.println(l.getId() + " : " + l.returnAuthorTitle());
					}
					System.out.print("Which ID to edit: ");
					int idToEdit = in.nextInt();

					BookClass toEdit = lih.searchForBookById(idToEdit);
					System.out.println("Retrieved " + toEdit.getBookAuthor() + " from " + toEdit.getBookTitle());
					System.out.println("1 : Update Author");
					System.out.println("2 : Update Title");
					int update = in.nextInt();
					in.nextLine();

					if (update == 1) {
						System.out.print("New author: ");
						String newName = in.nextLine();
						toEdit.setBookAuthor(newName);
					} else if (update == 2) {
						System.out.print("New Title: ");
						String newTitle = in.nextLine();
						toEdit.setBookTitle(newTitle);
				}

					lih.updateBooks(toEdit);
			} else {
					System.out.println("---- No results found");
		}
	}

	public static void main(String[] args) {
		runMenu();		
	}
	
	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("-----------------------------------------------");
		System.out.println("     Paul Thairu Book Store       ");
		System.out.println("-----------------------------------------------");
		while (goAgain) {
			
			System.out.println("\nPlease choose from the options below");
			System.out.println("**************************");
			System.out.println("    1. ADD NEW Book");
			System.out.println("**************************");
			System.out.println("    2. EDIT EXISTING Book ");
			System.out.println("**************************");
			System.out.println("    3. DELECT Book");
			System.out.println("**************************");
			System.out.println("    4. VIEW ALL Books ");
			System.out.println("***************************");
			System.out.println("    5. EXIT ");
			System.out.println("***************************");
			System.out.println("----------------------------------");
			System.out.print("        Your selection: \n");
			System.out.println("----------------------------------");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addAnItem();
			} else if (selection == 2) {
				editBook();
			} else if (selection == 3) {
				deleteLibBook();
			} else if (selection == 4) {			
				viewTheList();					
			} else {
				lih.cleanUp();
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}
		}
	}
	
	// method to view all books in the list
	private static void viewTheList() {
		
			List<BookClass> allBooks = lih.displayAllBook();
			for(BookClass singleItem : allBooks){
				System.out.println("----------------------------------------------------");
				System.out.println(singleItem.returnItemDetails());				
		}	
	}
}
