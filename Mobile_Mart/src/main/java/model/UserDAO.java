package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.function.IntBinaryOperator;

import org.apache.catalina.User;
import org.eclipse.jdt.internal.compiler.lookup.ImplicitNullAnnotationVerifier;

import model.PasswordEncryption;

public class UserDAO {

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/mobilemarts?useSSl=false";
		String username = "root";
		String password = "mysql123";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, username, password);
		return con;
	}

	public String registerUser(model.User user) {
		try {
			Connection con = getConnection();
			String query = "INSERT INTO user (name, address, email, phone, pass1, role, photo_path) VALUES (?, ?, ?, ?, ?, ?, ?)";
			System.out.println("Running");
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, user.getName());
			pst.setString(2, user.getAddress());
			pst.setString(3, user.getEmail());
			pst.setString(4, user.getPhone());
			pst.setString(5, user.getPass1());
			pst.setString(6, user.getRole());
			pst.setString(7, user.getPhotoPath());

			int rows = pst.executeUpdate();
			System.out.println("Query executed");
			con.close();

			if (rows != 0) {
				return "Registration Successful!";
			} else {
				return "Registration Failed !";
			}

		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			return e.getMessage();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return e.getMessage();
		}
	}

	public model.User fetchUserDetails(int userId) {
		Connection connection = null;
		model.User user = null;
		try {
			connection = getConnection();
			String query = "SELECT * FROM user WHERE id=?";
			PreparedStatement pst = connection.prepareStatement(query);
			pst.setInt(1, userId);
			ResultSet table = pst.executeQuery();
			while (table.next()) {
				String name = table.getString(2);
				String email = table.getString(4);
				String phone = table.getString(5);
				String address = table.getString(3);
				String password = table.getString(6);
				String role = table.getString(7);
				String photopath = table.getString(8);
				String decPassword = PasswordEncryption.decrypt(password);

				user = new model.User(name, address, email, phone, decPassword, role, photopath);

			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public model.User validateLogin(String email, String pass) {
		model.User user = null;
		try {
			Connection connection = getConnection();
			String query = "SELECT * FROM user where email=? and pass1=?";
			PreparedStatement pst = connection.prepareStatement(query);
			String encryptedPassword = PasswordEncryption.encrypt(pass);
			pst.setString(1, email);
			pst.setString(2, encryptedPassword);

			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				int id = rs.getInt(1);
				String role = rs.getString(7);
				String userImage = rs.getString(8);
				user = new model.User(id, role, userImage);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public ArrayList<String> fetchUsers() {
		Connection connection = null;
		ArrayList<String> emails = new ArrayList<>();
		try {
			connection = getConnection();
			String query = "SELECT email FROM user";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet table = pst.executeQuery();
			while (table.next()) {
				String email = table.getString(1);
				emails.add(email);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return emails;
	}

	public String getUserRole(String id) {
		String role = null;
		try {
			Connection connection = getConnection();
			String query = "SELECT role FROM user WHERE email=?";
			PreparedStatement pst = connection.prepareStatement(query);
			pst.setString(1, id);

			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				role = rs.getString("role");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return role;
	}

	public String addProduct(Product product) {
		try {
			Connection con = getConnection();
			String query = "INSERT INTO product (name, price, description, stock, imagePath) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, product.getName());
			pst.setString(2, product.getPrice());
			pst.setString(3, product.getDescription());
			pst.setInt(4, product.getStock());
			pst.setString(5, product.getProductImage());

			int rows = pst.executeUpdate();
			con.close();

			if (rows != 0) {
				return "Product added successfully!";
			} else {
				return "Failed to add product!";
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			return e.getMessage();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return e.getMessage();
		}

	}

	public String updateProduct(Product product) {
		try {
			Connection con = getConnection();
			String query = "UPDATE product SET name=?, price=?, description=?, stock=?, imagePath=? WHERE id=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, product.getName());
			pst.setString(2, product.getPrice());
			pst.setString(3, product.getDescription());
			pst.setInt(4, product.getStock());
			pst.setString(5, product.getProductImage());
			pst.setInt(6, product.getId());

			int rows = pst.executeUpdate();
			con.close();

			if (rows != 0) {
				return "Product updated successfully!";
			} else {
				return "Failed to update product!";
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			return e.getMessage();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return e.getMessage();
		}

	}

	public String deleteProduct(int productId) {
		try {
			Connection con = getConnection();
			String query = "DELETE FROM product WHERE id=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, productId);
			int rows = pst.executeUpdate();
			con.close();
			if (rows != 0) {
				return "Successfully Deleted!";
			} else {
				return "Something is wrong";
			}

		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			return e.getMessage();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return e.getMessage();
		}

	}

	public ArrayList<Product> fetchProducts() {
		Connection connection = null;
		ArrayList<Product> productList = new ArrayList<>();
		try {
			connection = getConnection();
			String query = "SELECT * FROM product";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet table = pst.executeQuery();
			while (table.next()) {
				int Id = table.getInt(1);
				String name = table.getString(2);
				String description = table.getString(3);
				String price = table.getString(4);
				int stock = table.getInt(5);
				String productImagePath = table.getString(6);

				Product product = new Product(Id, name, description, price, stock, productImagePath);
				productList.add(product);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return productList;
	}

	public ArrayList<Product> searchProducts(String keyWord) {
		Connection connection = null;
		ArrayList<Product> productList = new ArrayList<>();
		try {
			connection = getConnection();
			String query = "SELECT * FROM product where name LIKE ? OR price LIKE ?";
			PreparedStatement pst = connection.prepareStatement(query);
			pst.setString(1, "%" + keyWord + "%");
			pst.setString(2, keyWord);
			ResultSet table = pst.executeQuery();
			while (table.next()) {
				int Id = table.getInt(1);
				String name = table.getString(2);
				String description = table.getString(3);
				String price = table.getString(4);
				int stock = table.getInt(5);
				String productImagePath = table.getString(6);

				Product product = new Product(Id, name, description, price, stock, productImagePath);
				productList.add(product);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return productList;
	}

	public Product fetchProductById(int product_Id) {
		Product product = null;
		Connection connection = null;
		try {
			connection = getConnection();
			String query = "SELECT * FROM product where id=?";
			PreparedStatement pst = connection.prepareStatement(query);
			pst.setInt(1, product_Id);
			ResultSet table = pst.executeQuery();
			while (table.next()) {
				int Id = table.getInt(1);
				String name = table.getString(2);
				String description = table.getString(3);
				String price = table.getString(4);
				int stock = table.getInt(5);
				String productImagePath = table.getString(6);

				product = new Product(Id, name, description, price, stock, productImagePath);

			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return product;
	}

	public int addToCart(Cart cart) {
		try {
			Connection con = getConnection();
			String query = "INSERT INTO cart(user_id,product_id) VALUES(?,?)";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, cart.getUserId());
			pst.setInt(2, cart.getProductId());

			int rows = pst.executeUpdate();
			con.close();

			return rows;
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}

	public ArrayList<Cart> fetchCartDetails(int userId) {
		Connection connection = null;
		ArrayList<Cart> cartItems = new ArrayList<>();
		try {
			connection = getConnection();
			String query = " SELECT c.id, p.name,p.price,p.stock,p.imagePath FROM Cart c JOIN Product p ON c.product_id=p.id WHERE user_id=? ORDER BY id DESC";
			PreparedStatement pst = connection.prepareStatement(query);
			pst.setInt(1, userId);
			ResultSet table = pst.executeQuery();
			while (table.next()) {
				int id = table.getInt(1);
				String name = table.getString(2);
				String price = table.getString(3);
				int stock = table.getInt(4);
				String productImagePath = table.getString(5);

				Cart cart = new Cart(id, name, productImagePath, price, stock);
				cartItems.add(cart);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cartItems;
	}

	public String deleteCartItem(int cartId) {
		try {
			Connection con = getConnection();
			String query = "DELETE FROM cart WHERE id=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, cartId);
			int rows = pst.executeUpdate();
			con.close();
			if (rows != 0) {
				return "Successfully Deleted Cart Item !";
			} else {
				return "Something is wrong";
			}

		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			return e.getMessage();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return e.getMessage();
		}

	}

	public String updateUser(model.User user) {
		try {
			Connection con = getConnection();
			String query = "Update user set name=?,address=?,phone=?, photo_path=? where email=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, user.getName());
			pst.setString(2, user.getAddress());
			pst.setString(3, user.getPhone());
			pst.setString(4, user.getPhotoPath());
			pst.setString(5, user.getEmail());

			int rows = pst.executeUpdate();
			con.close();

			if (rows != 0) {
				return "Profile updated successfully!";
			} else {
				return "Failed to update profile!";
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			return e.getMessage();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return e.getMessage();
		}

	}

	public model.Cart getCartById(int cartId) {
		model.Cart cart = null;
		try {
			Connection con = getConnection();
			String query = "SELECT user_id,product_id FROM cart WHERE id=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, cartId);
			ResultSet table = pst.executeQuery();
			while (table.next()) {
				int userId = table.getInt(1);
				int productId = table.getInt(2);
				cart = new Cart(userId, productId);
			}
			con.close();
			return cart;
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return cart;
	}

	public int addToOrder(Order order) {
		try {
			Connection con = getConnection();
			String query = "INSERT INTO `order`(user_id,product_id,order_date,status) VALUES(?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, order.getUserId());
			pst.setInt(2, order.getProdoctId());
			pst.setString(3, order.getOrderDate());
			pst.setString(4, order.getStatus());

			int rows = pst.executeUpdate();
			con.close();

			return rows;
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}

	public int deleteOrder(Order order) {
		try {
			Connection con = getConnection();
			String query = "DELETE FROM `order` WHERE id=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, order.getUserId());
			pst.setInt(2, order.getProdoctId());
			pst.setString(3, order.getOrderDate());
			pst.setString(4, order.getStatus());
			int rows = pst.executeUpdate();
			con.close();

			return rows;
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}

	public ArrayList<Order> fetchOrderDetails() {
		Connection connection = null;
		ArrayList<Order> orderList = new ArrayList<>();
		try {
			connection = getConnection();
			String query = "SELECT o.id, u.name, o.order_date, p.name,p.price, o.status FROM `order` o JOIN user u ON o.user_id = u.id JOIN product p on o.product_id=p.id;";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet table = pst.executeQuery();
			while (table.next()) {
				int orderId = table.getInt(1);
				String customerName = table.getString(2);
				String orderDate = table.getString(3);
				String productName = table.getString(4);
				Float productPrice = table.getFloat(5);
				String status = table.getString(6);

				Order details = new Order(orderId, customerName, orderDate, productName, productPrice, status);
				orderList.add(details);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return orderList;
	}

	public ArrayList<Order> fetchUserOrders(int userID) {
		Connection connection = null;
		ArrayList<Order> orderList = new ArrayList<>();
		try {
			connection = getConnection();
			String query = "SELECT o.id, u.name, o.order_date, p.name, p.price, o.status FROM `order` o JOIN user u ON o.user_id = u.id JOIN product p on o.product_id=p.id WHERE u.id =?;";
			PreparedStatement pst = connection.prepareStatement(query);
			pst.setInt(1, userID);
			ResultSet table = pst.executeQuery();
			while (table.next()) {
				int orderId = table.getInt(1);
				String customerName = table.getString(2);
				String orderDate = table.getString(3);
				String productName = table.getString(4);
				Float productPrice = table.getFloat(5);
				String status = table.getString(6);

				Order details = new Order(orderId, customerName, orderDate, productName, productPrice, status);
				orderList.add(details);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return orderList;
	}

	public int UpdateOrderStatus(int orderId) {
		int status = 0;
		Connection con = null;
		try {
			con = getConnection();
			String query = "Update `order` SET status=? WHERE id=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, "Delivered");
			pst.setInt(2, orderId);
			status = pst.executeUpdate();
			return status;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return status;
	}

}
