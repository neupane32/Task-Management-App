package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserDAO;

@SuppressWarnings("serial")
@WebServlet("/deleteCartItem")
public class DeleteCartItem extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int productId = Integer.parseInt(request.getParameter("cartId"));
		String msg = new UserDAO().deleteCartItem(productId);

		HttpSession session = request.getSession();

		session.setAttribute("deleteCart", msg);

		System.out.println(msg);

		response.sendRedirect(request.getContextPath() + "/ShowCart");
	}
}