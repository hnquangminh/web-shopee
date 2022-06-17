package entity;

public class Item {
	// sản phẩm ném vào trong giỏ
	private Product product;
	private int quantity;
	
	// giá bán
	private double price;

	
	public Product getProduct() {
		return product;
	}



	public void setProduct(Product product) {
		this.product = product;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public Item(Product product, int quantity, double price) {
		this.product = product;
		this.quantity = quantity;
		this.price = price;
	}

	public Item() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Item [product=" + product + ", quantity=" + quantity + ", price=" + price + "]";
	}


}
