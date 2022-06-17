package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import connect.DBconnect;
import entity.Account;
import entity.Cart;
import entity.Category;
import entity.Item;
import entity.Orders;
import entity.Product;

public class Dao {
	Connection conn = null;
	PreparedStatement ps = null;
	PreparedStatement ps1 = null;
	PreparedStatement ps2 = null;
	ResultSet rs = null;

	public List<Category> getAllCategory() {
		List<Category> list = new ArrayList<>();
		String query = "SELECT * FROM webbanhang.category";
		try {
			conn = new DBconnect().getConnect(); // mo ket noi voi sql
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Category(rs.getString(1), rs.getString(2)));
			}
		} catch (Exception e) {
		}
		return list;
	}

	public List<Product> getAllProduct() {
		List<Product> list = new ArrayList<>();
		String query = "SELECT * FROM webbanhang.product";
		try {
			conn = new DBconnect().getConnect(); // mo ket noi voi sql
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6), rs.getString(7)));
			}
		} catch (Exception e) {
		}
		return list;
	}

	public Product getProductByID(int id) {
		String query = "SELECT * FROM webbanhang.product where id = ?";
		try {
			conn = new DBconnect().getConnect(); // mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6), rs.getString(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBconnect.closeConnect();
		}
		return null;
	}

//		 
	public List<Product> getProductBySellID(int id) {
		List<Product> list = new ArrayList<>();
		String query = "select * from product\n" + "where id = ?";
		try {
			conn = new DBconnect().getConnect();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6), rs.getString(7)));
			}
		} catch (Exception e) {
		}
		return list;
	}

	public int getTotalProduct() {
		String query = "SELECT count(*) from Product ;";
		try {
			conn = new DBconnect().getConnect();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBconnect.closeConnect();
		}
		return 0;
	}

	public Account login(String user, String pass) {
		String query = "select * from  webbanhang.Account where user = ? and pass = ?";
//		                + "where [user] = ?"
//		                + "and pass = ?";
		try {
			conn = new DBconnect().getConnect();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setString(1, user);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBconnect.closeConnect();
		}
		return null;
	}

	// tạo hóa đơn cho thanh toán
	public void addOrder(Account user, Cart cart) {
		LocalDate curDate = java.time.LocalDate.now();
		String date = curDate.toString();
		String query = "INSERT INTO webbanhang.Orders VALUES (null,?,?,?)";
		String query1 = "SELECT MAX(id) from webbanhang.Orders order by id desc";
		try {
			// add vào bảng order
			conn = new DBconnect().getConnect();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setString(1, date);
			ps.setInt(2, user.getId());
			ps.setDouble(3, cart.getTotalMoney());
			ps.executeUpdate();
			// lấy ra cái id vừa mới add
			ps1 = conn.prepareStatement(query1);
			rs = ps1.executeQuery();
			// add nó vào Order Detail
			while (rs.next()) {
				int oid = rs.getInt(1);
				for (Item item : cart.getItems()) {
					String query2 = "INSERT INTO webbanhang.OrderDetail VALUES(?,?,?,?)";
					ps2 = conn.prepareStatement(query2);
					ps2.setInt(1, oid);
					ps2.setInt(2, item.getProduct().getId());
					ps2.setInt(3, item.getQuantity());
					ps2.setDouble(4, item.getPrice());
					ps2.executeUpdate();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBconnect.closeConnect();
		}
	}
	public List<Product> pagginProduct(int index){
		List<Product> list = new ArrayList<Product>();
		String query = "SELECT * FROM webbanhang.Product ORDER BY id LIMIT 9 OFFSET 0;";
		try {
			conn = new DBconnect().getConnect();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, (index-1)*9);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6), rs.getString(7)));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBconnect.closeConnect();
		}
		return list;
	}

	public static void main(String[] args) {
		Dao dao = new Dao();
		List<Category> listC = dao.getAllCategory();
		List<Product> listP = dao.getAllProduct();
		for (Category o : listC) {
			System.out.println(o);
		}
		for (Product o : listP) {
			System.out.println(o);
		}
		List<Product> listP1 = dao.pagginProduct(9);
		for (Product pr : listP) {
			System.out.println("Danh sách sản phẩm"+pr);
		}
		Product pr = dao.getProductByID(2);
		System.out.println(pr);
	}

}
