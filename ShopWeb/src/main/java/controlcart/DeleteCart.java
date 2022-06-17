package controlcart;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Cart;
import entity.Item;

/**
 * Servlet implementation class DeleteCart
 */
@WebServlet("/deletecart")
public class DeleteCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cart cart = null;
		String id = request.getParameter("id");
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("cart");// luu tam vao session
		  if (obj != null) {
	            cart = (Cart)obj;
	        } else {
	            cart = new Cart();
	        }
		  	cart.removeItem(Integer.parseInt(id));
		  	List<Item> list = cart.getItems();
		  	session.setAttribute("cart", cart);
		  	session.setAttribute("size", list.size());
		  	request.getRequestDispatcher("Cart.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
