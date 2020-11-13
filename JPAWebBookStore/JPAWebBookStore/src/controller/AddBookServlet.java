package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.BookClass;

/**
 * Servlet implementation class AddBookServlet
 */
@WebServlet("/addBookServlet")
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String ISBN = request.getParameter("ISBN");
		String bookAuthor = request.getParameter("bookAuthor");
		String bookTitle = request.getParameter("bookTitle");	
		String price;		
		double newPrice = Double.parseDouble(request.getParameter("price"));	
		
		BookClass li = new BookClass(ISBN, bookAuthor, bookTitle, newPrice);
		BookHelper dao = new BookHelper();
		dao.insertBook(li);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		
	}

}
