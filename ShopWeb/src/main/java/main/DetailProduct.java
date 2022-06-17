package main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class DetailProduct
 */
@WebServlet("/detailproduct")
public class DetailProduct extends HttpServlet {
private static final long serialVersionUID = 1L;
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Product pr = null;
		Dao dao = new Dao();
		List<Category> listC = dao.getAllCategory();	
//		Home home = new Home();
//		List<Product> list = home.list;
//		for (int i = 0; i < list.size(); i++) {
//			if(list.get(i).getId().contains(id)) {
//				request.setAttribute("detail", list.get(i));
//			}
		try {
			String idPr = request.getParameter("pri");
			System.out.println(idPr);
			Connection conn = DBconnect.getConnect(); //mở kết nối với sql server
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM webbanhang.product where id = ?"); //ném câu lệnh từ bên đây sang sql server
			ps.setString(1, idPr);
			ResultSet rs = ps.executeQuery(); //chạy câu lệnh query này ( giống chạy ra kết quả bảng trong sql server)
			if(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String imagine = rs.getString("imagine");
				Double price = rs.getDouble("price");
				String title = rs.getString("title");
				String description = rs.getString("description");
				
				pr = new Product();
				pr.setId(id);
				pr.setName(name);
				pr.setImagine(imagine);
				pr.setPrice(price);
				pr.setTitle(title);
				pr.setDescription(description);	
				
			}
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBconnect.closeConnect();
		}
		request.setAttribute("cardC", listC);
		request.setAttribute("pro", pr);
		request.getRequestDispatcher("/DetailPr.jsp").forward(request, response);
		
	}
}