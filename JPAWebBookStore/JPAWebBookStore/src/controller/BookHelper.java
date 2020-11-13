package controller;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import model.BookClass;
import model.ListDetails;

public class BookHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("BookStore");

	// Method to add new book
	public void insertBook(BookClass li) {		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<BookClass> showAllIBooks() {
		EntityManager em = emfactory.createEntityManager();
		List<BookClass> allItems = em.createQuery("SELECT i FROM ListItem i").getResultList();
		return allItems;
	}
	
	// display all books
	public List<BookClass> displayAllBook(){
		EntityManager em = emfactory.createEntityManager();
		List<BookClass> allBooks = em.createQuery("SELECT i	FROM BookClass i").getResultList();
		return	allBooks;
	}
	
	// method to delete books
	public void	deleteBook(BookClass toDelete){
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<BookClass> typedQuery = em.createQuery("select li from BookClass li where li.bookAuthor = :selectedAuthor and li.bookTitle = :selectedTitle", BookClass.class);
		
		//Substitute parameter with actual data from the toDelete item
		//typedQuery.setParameter("selectedISBN", toDelete.getISBN());
		typedQuery.setParameter("selectedAuthor", toDelete.getBookAuthor());
		typedQuery.setParameter("selectedTitle", toDelete.getBookTitle());
		//typedQuery.setParameter("selectedPrice", toDelete.getPrice());
		
		//we only want one result
		typedQuery.setMaxResults(1);
		
		//get the result and save it into a	new	list item
		BookClass result = typedQuery.getSingleResult();
		
		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		}
	
	// Method to search by book id
	
	public BookClass searchForBookById(int idToEdit) {		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		BookClass found = em.find(BookClass.class, idToEdit);
		em.close();
		return found;
	}

	// method to update exiting books details
	public void updateBooks(BookClass bookToUpdate) {		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();		
		
		em.merge(bookToUpdate);
		em.getTransaction().commit();
		em.close();
	}

	// method to search book by author
	public List<BookClass> searchForBooksByAuthor(String authorName) {		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<BookClass> typedQuery = em.createQuery("select li from BookClass li where li.bookAuthor = :selectedAuthor", BookClass.class);
		typedQuery.setParameter("selectedAuthor", authorName);

		List<BookClass> foundBooks = typedQuery.getResultList();
		em.close();
		return foundBooks;
	}

	// method to search book by title
	public List<BookClass> searchForBookByTitle(String bookName) {		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<BookClass> typedQuery = em.createQuery("select li from BookClass li where li.bookTitle = :selectedTitle", BookClass.class);
		typedQuery.setParameter("selectedTitle", bookName);
		List<BookClass> foundBooks = typedQuery.getResultList();
		em.close();
		return foundBooks;
	}
	
	public void cleanUp(){
		emfactory.close();
	}

}
