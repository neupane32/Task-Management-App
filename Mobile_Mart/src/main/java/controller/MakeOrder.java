package controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cart;
import model.User;
import model.UserDAO;
import model.Order;

@WebServlet("/MakeOrder")
public class MakeOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int cartId = Integer.parseInt(request.getParameter("cartId"));

		Cart cart = new UserDAO().getCartById(cartId);

		LocalDateTime currentDateTime = LocalDateTime.now();
		DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		int userId = cart.getUserId();
		int productId = cart.getProductId();
		String orderDate = currentDateTime.format(dateformat);
		String status = "Pending";

		Order order = new Order(userId, productId, orderDate, status);
		int orderStatus = new UserDAO().addToOrder(order);

		if (orderStatus != 0) {
			new UserDAO().deleteCartItem(cartId);
			response.sendRedirect(request.getContextPath() + "/ShowCart");
		}
	}

}
