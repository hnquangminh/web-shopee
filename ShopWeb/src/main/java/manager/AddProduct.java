package manager;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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
 * Servlet implementation class AddProduct
 */
@WebServlet("/add")
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ManagerProduct manager = new ManagerProduct();
		Dao dao = new Dao();
		List<Category> listC = dao.getAllCategory();	
		try {
			request.setCharacterEncoding("utf-8");
			String name = request.getParameter("name");
			String imagine = request.getParameter("imagine");
			String price = request.getParameter("price");
			String title = request.getParameter("title");
			String description = request.getParameter("description");
			String category = request.getParameter("category");
			Connection conn = DBconnect.getConnect();
			PreparedStatement ps = conn.prepareStatement("INSERT INTO  webbanhang.product VALUES (null,?,?,?,?,?,?);");
			ps.setString(1, name);
			ps.setString(2, imagine);
			ps.setDouble(3, Double.parseDouble(price));
			ps.setString(4, title);
			ps.setString(5, description);
			ps.setString(6, category);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBconnect.closeConnect();
		}
		request.setAttribute("cardC", listC);
		manager.doGet(request, response);
	}


}
