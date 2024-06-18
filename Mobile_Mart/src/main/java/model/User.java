package model;

public class User {
	private int loggedInId;
	private String loggedInRole;
	private String userImage;

	public User(int id, String role, String userImage) {
		this.loggedInId = id;
		this.loggedInRole = role;
		this.userImage = userImage;
	}

	public int getLoggedInId() {
		return loggedInId;
	}

	public void setLoggedInId(int loggedInId) {
		this.loggedInId = loggedInId;
	}

	public String getLoggedInRole() {
		return loggedInRole;
	}

	public void setLoggedInRole(String loggedInRole) {
		this.loggedInRole = loggedInRole;
	}

	public String getUserImage() {
		return userImage;
	}

	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}

	private String name;
	private String address;
	private String email;
	private String phone;
	private String pass1;
	private String role;
	private String photoPath;

	public User(String name, String address, String email, String phone, String pass1, String role, String photoPath) {
		this.name = name;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.pass1 = pass1;
		this.role = role;
		this.photoPath = photoPath;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPass1() {
		return pass1;
	}

	public void setPass1(String pass1) {
		this.pass1 = pass1;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

}
