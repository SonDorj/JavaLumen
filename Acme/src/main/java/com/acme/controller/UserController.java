package com.acme.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.acme.exceptions.UserNotFoundException;
import com.acme.model.User;
import com.acme.service.IUserService;
import com.acme.service.UserServiceImpl;


/**
 * Servlet implementation class LoadAllGrocery
 * @author Sonam AD35997
 */
@WebServlet("/userController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static IUserService iUserService = new UserServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> users;
		try {
			HttpSession session = request.getSession();
			String user = (String)session.getAttribute("user");
			if(user==null||user.isEmpty()||user.isBlank()) {
				response.sendRedirect("login.jsp");
			}
			else {
				
				users=iUserService.getAll();
				request.setAttribute("users", users);
				request.setAttribute("userSize", users.size());
				request.getRequestDispatcher("listUser.jsp").forward(request, response);
			}
		} catch (IOException | UserNotFoundException e) {
			request.getRequestDispatcher("listUser.jsp").forward(request, response);
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
