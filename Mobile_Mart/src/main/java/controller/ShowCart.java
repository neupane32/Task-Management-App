package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cart;
import model.UserDAO;

@SuppressWarnings("serial")
@WebServlet("/ShowCart")
public class ShowCart extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		int userId = (int) session.getAttribute("userId");
		

		ArrayList<Cart> cartItems = new UserDAO().fetchCartDetails(userId);
		request.setAttribute("cartItems", cartItems);
		
		
		request.getRequestDispatcher("/view/JSP/Cart.jsp").forward(request, response);
	}
}
