package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BookClass;

/**
 * Servlet implementation class EditBookServlet
 */
@WebServlet("/editBookServlet")
public class EditBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditBookServlet() {
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
		BookHelper dao = new BookHelper();		
		String ISBN = request.getParameter("ISBN");
		String bookAuthor = request.getParameter("bookAuthor");
		String bookTitle = request.getParameter("bookTitle");
		String price;		
		double newPrice = Double.parseDouble(request.getParameter("price"));
		//double price = Double.parseDouble(request.getParameter("price"));
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		BookClass bookToUpdate = dao.searchForBookById(tempId);
		bookToUpdate.setISBN(ISBN);
		bookToUpdate.setBookAuthor(bookAuthor);
		bookToUpdate.setBookTitle(bookTitle);
		bookToUpdate.setPrice(newPrice);
		
		dao.updateBooks(bookToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllBooksServlet").forward(request, response);
	}

}
