package com.acme.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.acme.exceptions.GroceryNotFoundException;
import com.acme.model.Grocery;
import com.acme.service.IInventoryService;
import com.acme.service.InventoryServiceImpl;


/**
 * Servlet implementation class LoadAllGrocery
 * @author Sonam AD35997
 */
@WebServlet("/nameSearch")
public class NameSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static IInventoryService iInventoryService = new InventoryServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NameSearch() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Grocery> groceries;
		try {
			HttpSession session = request.getSession();
			String user = (String)session.getAttribute("user");
			if(user==null||user.isEmpty()||user.isBlank()) {
				response.sendRedirect("login.jsp");
			}
			else {
				String name= request.getParameter("grocery");
				if(!(name==null||name.isBlank()||name.isEmpty())) {
					groceries=iInventoryService.getByName(name);
					if(groceries!=null) {
						request.setAttribute("groceries", groceries);
						request.setAttribute("size", groceries.size());
						request.getRequestDispatcher("home.jsp").forward(request, response);
					}
				}
				else {
					request.getRequestDispatcher("/homeController").forward(request, response);
				}
			}
		} catch (GroceryNotFoundException | IOException e) {
			request.getRequestDispatcher("/homeController").forward(request, response);
			e.printStackTrace();
		} 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doGet(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

}
