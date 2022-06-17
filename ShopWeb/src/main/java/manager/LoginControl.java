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
import javax.servlet.http.HttpSession;

import connect.DBconnect;
import dao.Dao;
import entity.Account;

@WebServlet("/login")
public class LoginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

     protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("user");
		String password = request.getParameter("pass");
		try {
			Connection conn = DBconnect.getConnect();
			PreparedStatement ps = conn.prepareStatement("Select * from  webbanhang.Account where user = ? and pass = ?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Account a = new Account(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4));
				HttpSession session = request.getSession();
				session.setAttribute("acc", a);
				request.getRequestDispatcher("home").forward(request, response);
			} else {
				request.setAttribute("mess", "Account does not exits!");
				request.getRequestDispatcher("Login.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		} 
	}
	
