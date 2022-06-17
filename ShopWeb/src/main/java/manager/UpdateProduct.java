package manager;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connect.DBconnect;
import entity.Product;

/**
 * Servlet implementation class UpdateProduct
 */
@WebServlet("/loadproduct")
public class UpdateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Product pr = null;
//		Home home = new Home();
//		List<Product> list = home.list;
//		for (int i = 0; i < list.size(); i++) {
//			if(list.get(i).getId().contains(id)) {
//				request.setAttribute("detail", list.get(i));
//			}
		try {
			String idPr = request.getParameter("pri");
			System.out.println(idPr);
			Connection conn = DBconnect.getConnect();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM webbanhang.product where id = ?");
			ps.setString(1, idPr);
			ResultSet rs = ps.executeQuery();
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
			
		}
		request.setAttribute("pro", pr);
		request.getRequestDispatcher("/Edit.jsp").forward(request, response);
	}

	
}
