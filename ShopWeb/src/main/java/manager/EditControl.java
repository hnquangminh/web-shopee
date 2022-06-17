package manager;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connect.DBconnect;

/**
 * Servlet implementation class EditControl
 */
@WebServlet("/edit")
public class EditControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			String edit = request.getParameter("edit");
			String id = request.getParameter("id");
			String imagine = request.getParameter("name");
			String name = request.getParameter("imagine");
			String price = request.getParameter("price");
			String title = request.getParameter("title");
			String description = request.getParameter("description");
			Connection conn = DBconnect.getConnect();
			PreparedStatement ps = conn.prepareStatement("UPDATE webbanhang.product SET name =?, imagine=?, price=?, title=?, description =? where id=?;");
			ps.setInt(6, Integer.parseInt(id));
			ps.setString(1, name);
			ps.setString(2, imagine);
			ps.setDouble(3, Double.parseDouble(price));
			ps.setString(4, title);
			ps.setString(5, description);
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBconnect.closeConnect();
		}
		ManagerProduct manager = new ManagerProduct();
		manager.doGet(request, response);
	}


}
