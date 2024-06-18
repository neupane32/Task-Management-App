package model;

public class Product {
	private int Id;
	private String name;
	private String price;
	private String description;
	private int stock;
	private String productImage;

	public Product(int Id, String name, String price, String description, int stock, String productImage) {
		this.Id = Id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.stock = stock;
		this.productImage = productImage;
	}

	public Product(String name, String price, String description, int stock, String productImage) {
		this.name = name;
		this.price = price;
		this.description = description;
		this.stock = stock;
		this.productImage = productImage;
	}

	public int getId() {
		return Id;
	}

	public void setId(int Id) {
		this.Id = Id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String imagePath) {
		this.productImage = imagePath;
	}
}
