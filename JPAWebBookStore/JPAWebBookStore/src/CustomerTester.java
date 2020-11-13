import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.ListDetailsHelper;
import model.BookClass;
import model.Customer;
import model.ListDetails;

public class CustomerTester {

	public static void main(String[] args) {
		
		Customer Samantha = new Customer("Tabitha");
		ListDetailsHelper ldh = new ListDetailsHelper();
		BookClass sam = new BookClass("1144OP6", "Tabitha Kahari", "Nursing School", 160.0);
		BookClass nat = new BookClass("N55887I", "Schola Kaharu", "Law Firm", 110.10);
		List<BookClass> samBooks = new ArrayList<BookClass>(); 		
		
		samBooks.add(sam);
		samBooks.add(nat);
		
		ListDetails samanthaList = new ListDetails("Tabitha's BookList", LocalDate.now(), Samantha);
		samanthaList.setListOfBooks(samBooks);
		ldh.insertNewListDetails(samanthaList);
		List<ListDetails> allLists = ldh.getLists();
		for(ListDetails a: allLists) {
		System.out.println(a.toString());
		}

	}

}
