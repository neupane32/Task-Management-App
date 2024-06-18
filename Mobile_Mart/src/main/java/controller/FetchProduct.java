package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;
import model.UserDAO;

@SuppressWarnings("serial")
@WebServlet("/viewproduct")
public class FetchProduct extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Product> productList=new UserDAO().fetchProducts();
		request.setAttribute("productList", productList);
		request.getRequestDispatcher("/view/JSP/ViewProduct.jsp").forward(request,response);
	}
}
