package model;

public class Cart {
	// For adding to the cart
	private int userId;
	private int productId;

	public Cart(int userId, int productId) {
		this.userId = userId;
		this.productId = productId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	// For fetching cart details
	private int cartId;
	private String productName;
	private String productImage;
	private String productPrice;
	private int productStock;

	public Cart(int CartId, String productName, String productImage, String productPrice, int productStock) {
		this.cartId = CartId;
		this.productName = productName;
		this.productImage = productImage;
		this.productPrice = productPrice;
		this.productStock = productStock;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductStock() {
		return productStock;
	}

	public void setProductStock(int productStock) {
		this.productStock = productStock;
	}
}
