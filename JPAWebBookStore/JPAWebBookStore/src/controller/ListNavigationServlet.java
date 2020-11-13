package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListDetails;

/**
 * Servlet implementation class listNavigationServlet
 */
@WebServlet("/listNavigationServlet")
public class ListNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListNavigationServlet() {
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
		String act = request.getParameter("doThisToList");

		if (act == null) {
			// no button has been selected
			getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);

		} else if (act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				ListDetails listToDelete = dao.searchForListkDetailsById(tempId);
				dao.deleteBook(listToDelete);

			} catch (NumberFormatException e) {
				System.out.println("Forgot to click a button");
			} finally {
				getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
			}

		} else if (act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				ListDetails listToEdit = dao.searchForListkDetailsById(tempId);
				request.setAttribute("listToEdit", listToEdit);
				request.setAttribute("month", listToEdit.getRentDate().getMonthValue());
				request.setAttribute("date", listToEdit.getRentDate().getDayOfMonth());
				request.setAttribute("year", listToEdit.getRentDate().getYear());
				
				ListBookHelper daoForItems = new ListBookHelper();				
				request.setAttribute("allBooks", daoForItems.showAllIBooks());							
				if(daoForItems.showAllIBooks().isEmpty()){
						request.setAttribute("allBooks", " ");
				}
				getServletContext().getRequestDispatcher("/edit-list.jsp").forward(request, response);
			} catch (NumberFormatException e) {
				getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
			} 

		} else if (act.equals("add")) {
			
			ListBookHelper dao1 = new ListBookHelper();			
			request.setAttribute("allBooks", dao1.showAllIBooks());			
			if(dao1.showAllIBooks().isEmpty()){
					request.setAttribute("allBooks", " ");
			}
			getServletContext().getRequestDispatcher("/new-list.jsp").forward(request, response);
		}
	}

}
