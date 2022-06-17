package main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connect.DBconnect;
import dao.Dao;
import entity.Category;
import entity.Product;

/**
 * Servlet implementation class CategoryControl
 */
@WebServlet("/category")
public class CategoryControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Dao dao = new Dao();
		List<Product> list = new ArrayList<Product>();
        List<Category> listC = dao.getAllCategory();		        
		String categoryid = request.getParameter("cid");
		try {
			Connection conn = DBconnect.getConnect();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM webbanhang.product where cid = ?");
			ps.setString(1,categoryid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Product(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getDouble(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7)));
			}
			conn.close();
			
		} catch (Exception e) {		
		}
		request.setAttribute("cardC", listC);
		request.setAttribute("card", list);
		request.getRequestDispatcher("/Home.jsp").forward(request, response);
	}

}
