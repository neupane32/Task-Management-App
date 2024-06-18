package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cart;
import model.UserDAO;

@WebServlet("/addToCart")
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		int userId = (int) session.getAttribute("userId");

		int productId = Integer.parseInt(request.getParameter("productId"));
		Cart cart = new Cart(userId, productId);

		int result = new UserDAO().addToCart(cart);

		if (result != 0) {

			response.sendRedirect(request.getContextPath() + "/ShowCart");
		} else {

			response.sendRedirect(request.getContextPath() + "/ShowProduct");
		}

	}

}
