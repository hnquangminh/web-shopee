package controlcart;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
import entity.Cart;
import entity.Item;
import entity.Orders;
import entity.Product;

/**
 * Servlet implementation class OrderCart
 */
@WebServlet("/order")
public class OrderCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Dao dao = new Dao();
		Cart cart = null;
		HttpSession session = request.getSession();
		Object object = session.getAttribute("cart");
		if(object != null) {
			cart = (Cart)object;
		} else {
			cart = new Cart();
		}
		Account account = null;
		Object a = (Account) session.getAttribute("acc");
		if (a != null) {
			account = (Account)a;
			dao.addOrder(account, cart);
			session.removeAttribute("cart");
			session.setAttribute("size", 0);
			response.sendRedirect("home");
		} else {
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
