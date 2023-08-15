package com.acme.controller;

import java.io.IOException;
import java.util.ArrayList;
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
@WebServlet("/addToCart")
public class AddCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCart() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try (IInventoryService inventoryService = new InventoryServiceImpl();){
			int groceryId = Integer.parseInt(request.getParameter("addToCart"));
			Grocery grocery = inventoryService.getByID(groceryId);
			if(grocery!=null) {
				HttpSession session = request.getSession();
				List<Grocery> cart = (List<Grocery>) session.getAttribute("cart");
				if(cart == null) {
					cart = new ArrayList<>();
				}
				cart.add(grocery);
				session.setAttribute("cart", cart);
				double total = cart.stream().mapToDouble(Grocery::getPrice).sum();
				session.setAttribute("total", total);
				request.getRequestDispatcher("/clientController").forward(request, response);
			}
		} catch (NumberFormatException | IOException | GroceryNotFoundException e) {
			request.getRequestDispatcher("/clientController").forward(request, response);
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
