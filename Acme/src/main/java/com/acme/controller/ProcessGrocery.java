package com.acme.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.acme.exceptions.GroceryNotFoundException;
import com.acme.service.IInventoryService;
import com.acme.service.InventoryServiceImpl;


/**
 * Servlet implementation class LoadAllGrocery
 * @author Sonam AD35997
 */
@WebServlet("/processGrocery")
public class ProcessGrocery extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessGrocery() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try (IInventoryService iInventoryService = new InventoryServiceImpl()){
			String updateButton = request.getParameter("update");
			String deleteButton = request.getParameter("delete");
			
			if(!(deleteButton==null || deleteButton.isBlank()) && (iInventoryService.deleteGrocery(Integer.parseInt(deleteButton)))) {
					request.setAttribute("deleted", true);
					request.getRequestDispatcher("/homeController").forward(request, response);
								
			}
			else {
				request.setAttribute("groceryId", updateButton);
				request.getRequestDispatcher("/updateItem.jsp").forward(request, response);
			}
		} catch (NumberFormatException | IOException | GroceryNotFoundException e) {
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
