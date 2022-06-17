package manager;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connect.DBconnect;
import dao.Dao;
import entity.Account;
import entity.Category;
import entity.Product;

/**
 * Servlet implementation class ManagerProduct
 */
@WebServlet("/manager")
public class ManagerProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> list = new ArrayList<>();
		Dao dao = new Dao();
		List<Category> listC = dao.getAllCategory();	
//		HttpSession session = request.getSession();
//	    Account a = (Account) session.getAttribute("acc");
//	    int id = a.getId();
		try {
			Connection conn = DBconnect.getConnect();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM webbanhang.product");
//			 HttpSession session = request.getSession();
//		     Account a = (Account) session.getAttribute("acc");
//		     int id = a.getId();
//		     List<Product> list = dao.getProductBySellID(id);
//		        request.setAttribute("listPr", list);
//		        request.getRequestDispatcher("ManagerProduct.jsp").forward(request, response);
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String imagine = rs.getString("imagine");
				Double price = rs.getDouble("price");
				String title = rs.getString("title");
				String description = rs.getString("description");
				
				Product pr = new Product();
				pr = new Product();
				pr.setId(id);
				pr.setName(name);
				pr.setImagine(imagine);
				pr.setPrice(price);
				pr.setTitle(title);
				pr.setDescription(description);			
				list.add(pr);
				
			}
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBconnect.closeConnect();
		}
		request.setAttribute("cardC", listC);
		request.setAttribute("listPr", list);
		request.getRequestDispatcher("ManagerProduct.jsp").forward(request, response);
	}
	

}
