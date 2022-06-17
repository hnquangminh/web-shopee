package entity;

// Hóa Đơn
public class Orders {
	private int id;
	private String date;
	private int customerid;
	private double totalmoney;
	
	
	

	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getDate() {
		return date;
	}




	public void setDate(String date) {
		this.date = date;
	}




	public int getCustomerid() {
		return customerid;
	}




	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}




	public double getTotalmoney() {
		return totalmoney;
	}




	public void setTotalmoney(double totalmoney) {
		this.totalmoney = totalmoney;
	}




	public Orders(int id, String date, int customerid, double totalmoney) {
		this.id = id;
		this.date = date;
		this.customerid = customerid;
		this.totalmoney = totalmoney;
	}




	public Orders() {
		// TODO Auto-generated constructor stub
	}




	@Override
	public String toString() {
		return "Orders [id=" + id + ", date=" + date + ", customerid=" + customerid + ", totalmoney=" + totalmoney
				+ "]";
	}

}
