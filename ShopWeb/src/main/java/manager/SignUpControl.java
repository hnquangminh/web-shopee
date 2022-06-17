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

/**
 * Servlet implementation class SignUpControl
 */
@WebServlet("/signup")
public class SignUpControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("user");
		String password = request.getParameter("pass");
		String repass = request.getParameter("repass");
		if (!password.equals(repass)) {
			request.setAttribute("mess", "Passwords do not match");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		} else {
			try {
				Connection conn = DBconnect.getConnect();
				PreparedStatement ps = conn.prepareStatement("SELECT * FROM webbanhang.account where user = ?");
				ps.setString(1, username);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					request.setAttribute("mess", "this account still exists");
					request.getRequestDispatcher("Login.jsp").forward(request, response);
				} else {
					try {
						Connection conn1 = DBconnect.getConnect();
						PreparedStatement ps1 = conn1
								.prepareStatement("INSERT INTO  webbanhang.account VALUES (null,?,?,0)");
						ps1.setString(1, username);
						ps1.setString(2, password);
						ps1.executeUpdate();
					} catch (Exception e) {
						e.printStackTrace();
					}
					request.getRequestDispatcher("home").forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
