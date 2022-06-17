package controlcart;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connect.DBconnect;
import dao.Dao;
import entity.Cart;
import entity.Item;
import entity.Product;

/**
 * Servlet implementation class ProcessCart
 */
@WebServlet("/process")
public class ProcessCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cart cart = null;
		HttpSession session = request.getSession();
		Object object = session.getAttribute("cart");
		if(object != null) {
			cart = (Cart)object;
		} else {
			cart = new Cart();
		}
		String tid = request.getParameter("id");
		String tnum = request.getParameter("num");
		
		try {
			if((Integer.parseInt(tnum) ==-1) && (cart.getQuanTityById(Integer.parseInt(tid)) <=1)){
				cart.removeItem(Integer.parseInt(tid));
			} else {
				Dao dao = new Dao();
				Product pr = dao.getProductByID(Integer.parseInt(tid));
				Item items = new Item();
				items.setPrice(pr.getPrice());
				items.setProduct(pr);
				items.setQuantity(Integer.parseInt(tnum));
				cart.addItem(items);			
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBconnect.closeConnect();
		}
		List<Item> list = cart.getItems();
		session.setAttribute("cart", cart);
		session.setAttribute("size", list.size());
		request.getRequestDispatcher("Cart.jsp").forward(request, response);
	}


}
