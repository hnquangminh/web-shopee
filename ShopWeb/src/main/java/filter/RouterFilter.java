package filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Objects;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connect.DBconnect;
import entity.Account;

/**
 * Servlet Filter implementation class RouterFilter
 */
//@WebServlet(urlPatterns = "/manager")
@WebFilter("/manager")
public class RouterFilter extends HttpFilter implements Filter {

	private Object sessionVal;

	/**
	 * @see HttpFilter#HttpFilter()
	 */
	public RouterFilter() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
//		HttpServletRequest httpReq = (HttpServletRequest) request;
//		HttpServletResponse httpResp = (HttpServletResponse) response;
//		HttpSession session = httpReq.getSession();
//		String username = (String)session.getAttribute("acc");
		// lay duong dan tren trang
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpSession session = httpReq.getSession();
		Account acc = (Account) session.getAttribute("acc");
		// khi enter se day vao trang nao day
		HttpServletResponse httpResp = (HttpServletResponse) response;
		String path = httpReq.getServletPath();
//		Account acc = (Account) session.getAttribute("acc");
//		String path = httpReq.getServletPath();
//		Account account = findAccount(acc.getUser());
//		System.out.println(account.getAdmin());
//		System.out.println(account.getUser());
//		System.out.println(acc.getUser());
//		if ((account.getAdmin() == 0 || account == null) && Objects.equals(path, "/manager")) {
//			httpResp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
//		} else if (account.getAdmin() == 1 && Objects.equals(path, "/manager")) {
//			chain.doFilter(request, response);
//		}
//		if(Objects.isNull(sessionVal) && !Objects.equals(path, "/login" )) {
////			httpResp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
////		}else {
////			chain.doFilter(httpReq, httpResp);
		if(Objects.nonNull(acc) && acc.getAdmin()== 1 && path.contains("manager") ) {
			// TH login va login account la admin: OK
			chain.doFilter(httpReq, httpResp);
		}else if(Objects.nonNull(acc) && acc.getAdmin()== 1 &&(path.contains("home")) ) {
			// TH login account la admin va login vao page home : error
			httpResp.sendRedirect("404.jsp");
		}else if(Objects.nonNull(acc) && acc.getAdmin() == 0 && path.contains("manager")){
			// TH login account la user va login vao trang admin
			httpResp.sendRedirect("404.jsp");
		}else if(Objects.nonNull(acc) && acc.getAdmin() == 0 && (path.contains("home"))){
			// TH login account la user va login vao trang user
			chain.doFilter(httpReq, httpResp);
		}else if(Objects.isNull(acc) && path.contains("manager")){
			// TH ko login nhung dang nhap vao trang admin
			httpResp.sendRedirect("404.jsp");
		}else {
			chain.doFilter(httpReq, httpResp);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	public Account findAccount(String username) {
		Account ac = new Account();
		try {
			Connection conn = DBconnect.getConnect();
			PreparedStatement ps = conn.prepareStatement("Select * from  webbanhang.Account where user = ?");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				ac.setUser(rs.getString("user"));
				ac.setPass(rs.getString("pass"));
				ac.setAdmin(rs.getInt("admin"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBconnect.closeConnect();
		}
		return ac;
	}
}
