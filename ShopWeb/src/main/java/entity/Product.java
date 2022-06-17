package entity;

public class Product{
	private int id;
	private String name;
	private String imagine;
	private double price;
	private String title;
	private String description;
	private String cid;
	private int quantity;

	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getImagine() {
		return imagine;
	}


	public void setImagine(String imagine) {
		this.imagine = imagine;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getCid() {
		return cid;
	}


	public void setCid(String cid) {
		this.cid = cid;
	}


	public Product() {
		// TODO Auto-generated constructor stub
	}
	

	public Product(int id, String name, String imagine, double price, String title, String description, String cid) {
		this.id = id;
		this.name = name;
		this.imagine = imagine;
		this.price = price;
		this.title = title;
		this.description = description;
		this.cid = cid;
	}
	
	
	public Product(int id, String name, String imagine, double price, String title, String description, String cid,
			int quantity) {
		this.id = id;
		this.name = name;
		this.imagine = imagine;
		this.price = price;
		this.title = title;
		this.description = description;
		this.cid = cid;
		this.quantity = quantity;
	}

	

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", imagine=" + imagine + ", price=" + price + ", title=" + title
				+ ", description=" + description + ", cid=" + cid + "]";
	}
	
	




	

}
