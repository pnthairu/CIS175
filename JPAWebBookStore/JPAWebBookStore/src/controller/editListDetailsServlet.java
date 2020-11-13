package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BookClass;
import model.Customer;
import model.ListDetails;

/**
 * Servlet implementation class editListDetailsServlet
 */
@WebServlet("/editListDetailsServlet")
public class editListDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editListDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ListDetailsHelper dao = new ListDetailsHelper();
		ListBookHelper lih = new ListBookHelper();
		CustomerHelper sh = new CustomerHelper();
		
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		ListDetails listToUpdate = dao.searchForListkDetailsById(tempId);

		String newListName = request.getParameter("listName");

		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		
		String customerName = request.getParameter("customerName");
		//find our add the new customer
		Customer newCustomer = sh.findCustomer(customerName);

		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException ex) {
			ld = LocalDate.now();
		}

		try {
			//items are selected in list to add
			String[] selectedItems = request.getParameterValues("allItemsToAdd");
			List<BookClass> selectedItemsInList = new ArrayList<BookClass>();

			for (int i = 0; i < selectedItems.length; i++) {
				System.out.println(selectedItems[i]);
				BookClass c = lih.searchForBookById(Integer.parseInt(selectedItems[i]));
				selectedItemsInList.add(c);

			}
			listToUpdate.setListOfBooks(selectedItemsInList);
		} catch (NullPointerException ex) {
			// no items selected in list - set to an empty list
			List<BookClass> selectedItemsInList = new ArrayList<BookClass>();
			listToUpdate.setListOfBooks(selectedItemsInList);
		}

		listToUpdate.setListName(newListName);
		listToUpdate.setRentDate(ld);
		listToUpdate.setCustomer(newCustomer);

		dao.updateList(listToUpdate);

		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
	}
	
}
