import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.ListBookHelper;
import controller.ListDetailsHelper;
import model.BookClass;
import model.Customer;
import model.ListDetails;

public class ListTester {

	public static void main(String[] args) {
		ListBookHelper lih = new ListBookHelper();
		
		System.out.println(lih.displayAllBook());

	}

}
