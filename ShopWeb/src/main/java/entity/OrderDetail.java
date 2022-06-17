package entity;

public class OrderDetail {
	private int oid,pid;
	private int quantity;
	private double price;
	
	
	public int getOid() {
		return oid;
	}


	public void setOid(int oid) {
		this.oid = oid;
	}


	public int getPid() {
		return pid;
	}


	public void setPid(int pid) {
		this.pid = pid;
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


	public OrderDetail(int oid, int pid, int quantity, double price) {
		this.oid = oid;
		this.pid = pid;
		this.quantity = quantity;
		this.price = price;
	}


	public OrderDetail() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "OrderDetail [oid=" + oid + ", pid=" + pid + ", quantity=" + quantity + ", price=" + price + "]";
	}

}
