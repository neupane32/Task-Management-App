package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.Session;

import model.UserDAO;

@WebServlet("/UpdateStatus")
public class UpdateStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int orderId = Integer.parseInt(request.getParameter("orderId"));

		int status = new UserDAO().UpdateOrderStatus(orderId);

		if (status != 0) {
			response.sendRedirect(request.getContextPath() + "/showOrders");
		} else {
			response.sendRedirect(request.getContextPath() + "/showOrders");
		}
	}

}
