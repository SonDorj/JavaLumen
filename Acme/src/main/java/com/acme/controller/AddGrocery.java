package com.acme.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.acme.model.Grocery;
import com.acme.service.IInventoryService;
import com.acme.service.InventoryServiceImpl;


/**
 * Servlet implementation class LoadAllGrocery
 * @author Sonam AD35997
 */
@WebServlet("/addGrocery")
public class AddGrocery extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddGrocery() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try (IInventoryService iInventoryService = new InventoryServiceImpl()){
			String name = request.getParameter("name");
			String price = request.getParameter("price");
			String stock = request.getParameter("stock");
			if(stock.isBlank())
				stock = "1";
			if(!(name.isBlank()||price.isBlank()||stock.isBlank()) && (iInventoryService.addGrocery(new Grocery(name,Double.parseDouble(price),Integer.parseInt(stock))))) {
					request.setAttribute("added", true);
				}
			request.getRequestDispatcher("/homeController").forward(request, response);
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
			request.getRequestDispatcher("/homeController").forward(request, response);
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
