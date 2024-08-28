package com.coffeetalk.servlet;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coffeetalk.dao.UserDAO;
import com.coffeetalk.model.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/user")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO dao;
       
    /**
     * @throws SQLException 
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() throws SQLException {
        super();
        this.dao = new UserDAO();
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
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		User user = new User(username, email, password);
		
		boolean createUser = false;
		
		try {
			createUser = this.dao.create(user);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		if(!createUser) {
			request.setAttribute("createUserError", true);
			request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
			return;
		}
		
		request.setAttribute("createUserSuccess", true);
		request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
	}

}
