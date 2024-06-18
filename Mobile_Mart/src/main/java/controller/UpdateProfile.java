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

import model.PasswordEncryption;
import model.User;
import model.UserDAO;

@SuppressWarnings("serial")
@MultipartConfig
@WebServlet("/updateProfile")
public class UpdateProfile extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String pass1 = request.getParameter("pass1");
		String role = request.getParameter("role");
		String encPassword = PasswordEncryption.encrypt(pass1);

		Part userImage = request.getPart("user-image");

		String photoPath;

		if (userImage != null && userImage.getInputStream().available() > 0) {
			System.out.println("Image Selected.");
			photoPath = "user-" + UUID.randomUUID().toString() + ".png";
		} else {

			photoPath = request.getParameter("old-image");
		}

		User user = new User(name, address, email, phone, encPassword, role, photoPath);
		String msg = new UserDAO().updateUser(user);
		HttpSession session = request.getSession();

		if ((msg.equals("Profile updated successfully!")) && userImage != null
				&& userImage.getInputStream().available() > 0) {
			String path = getServletContext().getInitParameter("photoPath");
			String fullPath = path + photoPath;
			userImage.write(fullPath);
		}
		session.setAttribute("updateMsg", "Sucessfully updated your profile.");
		response.sendRedirect(request.getContextPath() + "/viewProfile");
	}
}