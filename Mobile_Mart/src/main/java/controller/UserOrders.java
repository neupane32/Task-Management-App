package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Order;
import model.UserDAO;

@SuppressWarnings("serial")
@WebServlet("/UserOrders")
public class UserOrders extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		int userId = (int) session.getAttribute("userId");
		
		ArrayList<Order> orderList = new UserDAO().fetchUserOrders(userId);
		request.setAttribute("orderList", orderList);
		request.getRequestDispatcher("/view/JSP/ShowUserOrders.jsp").forward(request, response);
	}
}
