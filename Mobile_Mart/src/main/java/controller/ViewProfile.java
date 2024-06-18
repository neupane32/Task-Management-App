package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import model.UserDAO;

@SuppressWarnings("serial")
@WebServlet("/viewProfile")
public class ViewProfile extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int userId = (int) session.getAttribute("userId");
		
		User user = new UserDAO().fetchUserDetails(userId);
		request.setAttribute("user", user);

		
		if (session.getAttribute("loggedInRole").equals("user")) {
			request.getRequestDispatcher("view/JSP/EditProfile.jsp").forward(request, response);

		}

		if (session.getAttribute("loggedInRole").equals("admin")) {
			request.getRequestDispatcher("view/JSP/ViewAdminProfile.jsp").forward(request, response);

		}
	}

}
