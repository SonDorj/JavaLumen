package com.acme.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.acme.service.IUserService;
import com.acme.service.UserServiceImpl;


/**
 * Servlet implementation class LoadAllGrocery
 * @author Sonam AD35997
 */
@WebServlet("/deleteUser")
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUser() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try (IUserService userService = new UserServiceImpl()){
			String username = request.getParameter("username");
			if(!username.isBlank() && (userService.deleteUser(username))) {
					request.setAttribute("deleted", true);
				}
			request.getRequestDispatcher("/userController").forward(request, response);
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
			request.getRequestDispatcher("/userController").forward(request, response);
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
