package controller;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.Product;
import model.UserDAO;

@SuppressWarnings("serial")
@MultipartConfig
@WebServlet("/addProduct")
public class AddProduct extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("product-name");
		String price = request.getParameter("product-price");
		String description = request.getParameter("product-description");
		int stock = Integer.parseInt(request.getParameter("product-stock"));
		String photoPath = "product-" + UUID.randomUUID().toString() + ".png";

		HttpSession session = request.getSession();

		Product product = new Product(name, price, description, stock, photoPath);
		String msg = new UserDAO().addProduct(product);

		Part productImage = request.getPart("product-image");

		session.setAttribute("addStatus", msg);

		if (msg.equals("Product added successfully!") && productImage != null
				&& productImage.getInputStream().available() > 0) {
			String path = getServletContext().getInitParameter("photoPath");
			String fullPath = path + photoPath;
			productImage.write(fullPath);
		}
		response.sendRedirect(request.getContextPath() + "/viewproduct");
	}

}
