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
import com.acme.exceptions.NegativeStockException;
import com.acme.exceptions.StockLimitExceededException;
import com.acme.model.Grocery;
import com.acme.service.IInventoryService;
import com.acme.service.InventoryServiceImpl;


/**
 * Servlet implementation class LoadAllGrocery
 * @author Sonam AD35997
 */
@WebServlet("/getBill")
public class GetBill extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetBill() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try (IInventoryService inventoryService = new InventoryServiceImpl();){
				HttpSession session = request.getSession();
				List<Grocery> cart = (List<Grocery>) session.getAttribute("cart");
				if(cart == null) {
					cart = new ArrayList<>();
				}
				for(Grocery item: cart) {
					inventoryService.sellGrocery(item.getGroceryId(), 1);
				request.setAttribute("bag", cart);
				request.setAttribute("Amount", session.getAttribute("total"));
				session.setAttribute("cart",null);
				session.setAttribute("total",null);
				request.getRequestDispatcher("/billPage.jsp").forward(request, response);
			}
		} catch (NumberFormatException | IOException | GroceryNotFoundException | StockLimitExceededException | NegativeStockException  e) {
			e.printStackTrace();
			request.getRequestDispatcher("/clientController").forward(request, response);
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
