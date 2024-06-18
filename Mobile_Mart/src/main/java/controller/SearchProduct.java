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

@WebServlet("/SearchProduct")
public class SearchProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String searchKeyword=request.getParameter("searchKeyword");
		if(searchKeyword.isEmpty()) {
			response.sendRedirect(request.getContextPath()+"/ShowProduct");
		}else {
			
			ArrayList<Product> products=new UserDAO().searchProducts(searchKeyword);
			request.setAttribute("products", products);
			request.getRequestDispatcher("/view/JSP/Homepage.jsp").forward(request,response);
		}
	}

}
