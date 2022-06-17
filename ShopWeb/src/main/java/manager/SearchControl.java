package manager;

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
import entity.Product;

/**
 * Servlet implementation class SearchControl
 */
@WebServlet("/search")
public class SearchControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		List<Product> list = new ArrayList<Product>();
		String search = request.getParameter("search");
		try {
			Connection conn = DBconnect.getConnect();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM webbanhang.product where title like ?");
			ps.setString(1,"%"+ search + "%");
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
		request.setAttribute("searchname", search);
		request.setAttribute("card", list);
		request.getRequestDispatcher("/Home.jsp").forward(request, response);
	}

}
