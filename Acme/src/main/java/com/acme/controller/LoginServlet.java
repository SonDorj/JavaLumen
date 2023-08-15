package com.acme.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.acme.dao.IUserDao;
import com.acme.dao.UserDaoImpl;
import com.acme.model.User;


/**
 * Servlet implementation class LoadAllGrocery
 * @author Sonam AD35997
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try (IUserDao iUserDao = new UserDaoImpl();){
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			String user = iUserDao.checkUserExist(new User(username,password));
			if(user==null)
				response.sendRedirect("login.jsp");
			else {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				if(user.equalsIgnoreCase("Admin")) 
					response.sendRedirect("/Acme/homeController");
				else
					response.sendRedirect("/Acme/clientController");
			}
		} catch (IOException e) {
			response.sendRedirect("login.jsp");
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
