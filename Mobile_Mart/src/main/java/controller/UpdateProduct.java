package controller;

import java.io.IOException;
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
@WebServlet("/updateProduct")
public class UpdateProduct extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("product-id"));
		String name = request.getParameter("product-name");
		String price = request.getParameter("product-price");
		String description = request.getParameter("product-description");
		int stock = Integer.parseInt(request.getParameter("product-stock"));
		
		Part productImage = request.getPart("product-image");
		
		String photoPath;
		
		if(productImage!=null && productImage.getInputStream().available() > 0) {
			System.out.println("Image Selected.");
			photoPath="product-" + UUID.randomUUID().toString() + ".png";	
		}
		else {
			System.out.println("No image selected");
			photoPath=request.getParameter("old-image");
		}
		
		Product product = new Product(id, name, price, description, stock, photoPath);
		String message = new UserDAO().updateProduct(product);

		HttpSession session = request.getSession();
		session.setAttribute("updateStatus", message);

		if ((message.equals("Product updated successfully!")) &&  productImage!= null
				&& productImage.getInputStream().available() > 0) {
			String path = getServletContext().getInitParameter("photoPath");
			String fullPath = path + photoPath;
			productImage.write(fullPath);
		}
		response.sendRedirect(request.getContextPath() + "/viewproduct");
	}

}
