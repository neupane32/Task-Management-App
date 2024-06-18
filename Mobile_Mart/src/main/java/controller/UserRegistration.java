package controller;

import java.io.IOException;
import java.util.ArrayList;
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
import controller.UserRegistration;

@SuppressWarnings("serial")
@MultipartConfig
@WebServlet("/userRegister")
public class UserRegistration extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String pass1 = request.getParameter("pass1");
		String pass2 = request.getParameter("pass2");
		boolean isDuplicateEmail = false;

		ArrayList<String> existingEmails = new UserDAO().fetchUsers();

		for (String existingEmail : existingEmails) {
			if (existingEmail.equals(email)) {
				isDuplicateEmail = true;
				break;
			}
		}

		if (isDuplicateEmail == false) {
			if (!pass1.equals(pass2)) {
				response.sendRedirect(
						request.getContextPath() + "/view/JSP/Register.jsp?error=Password does not match !");
			} else {
				String encPassword = PasswordEncryption.encrypt(pass1);
				String photoPath = "user-" + UUID.randomUUID().toString() + ".png";
				String role = "user";

				Part userPhoto = request.getPart("userPhoto");

				User user = new User(name, address, email, phone, encPassword, role, photoPath);
				String message = new UserDAO().registerUser(user);

				HttpSession session = request.getSession();
				session.setAttribute("userRegistrationStatus", message + "Login Now");

				if (message.equals("Registration Successful!") && userPhoto != null
						&& userPhoto.getInputStream().available() > 0) {
					String path = getServletContext().getInitParameter("photoPath");
					String fullPath = path + photoPath;
					userPhoto.write(fullPath);
				}
				response.sendRedirect(request.getContextPath() + "/view/JSP/UserLogin.jsp");
			}
		} else {
			response.sendRedirect(
					request.getContextPath() + "/view/JSP/Register.jsp?error=Email is already registered !");
		}

	}

}
