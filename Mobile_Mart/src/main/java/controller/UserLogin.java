package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import model.UserDAO;

@SuppressWarnings("serial")
@WebServlet("/userLogin")
public class UserLogin extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		HttpSession session = request.getSession();
		User loggedInUser = new UserDAO().validateLogin(email, password);

		if (loggedInUser != null) {
			session.setAttribute("userId", loggedInUser.getLoggedInId());
			session.setAttribute("loggedInRole", loggedInUser.getLoggedInRole());
			session.setAttribute("userImage", loggedInUser.getUserImage());

			Cookie loginCookie = new Cookie("loggedInUser",
					loggedInUser.getLoggedInId() + "-" + loggedInUser.getLoggedInRole());

			loginCookie.setMaxAge(30 * 60);
			response.addCookie(loginCookie);

			if (loggedInUser.getLoggedInRole().equals("user")) {
				response.sendRedirect(request.getContextPath() + "/ShowProduct");
			} else if (loggedInUser.getLoggedInRole().equals("admin")) {
				response.sendRedirect(request.getContextPath() + "/viewproduct");
			}
		} else {
			session.setAttribute("loginError", "Login failed. Invalid credentials.");
			response.sendRedirect(request.getContextPath() + "/view/JSP/UserLogin.jsp");
		}
	}
}
