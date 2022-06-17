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
 * Servlet implementation class AddCart
 */
@WebServlet("/addcart")
public class AddCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int quantity = 1;
		Cart cart = null;
		Dao dao = new Dao();
		// Lưu cart vào session
		HttpSession session = request.getSession(true);
		// Buy ném vào giỏ hàng gọi session "cart" trả object <=> cart
		Object object = session.getAttribute("cart");
		if(object != null) {
			//ép object thành cart
			cart = (Cart)object;
		} else {
			cart = new Cart();
		}
		String tid = request.getParameter("id");
//		String tnumber = request.getParameter("number");
//		int id, number;
		try {
//			number = Integer.parseInt(tnumber);
//			id = Integer.parseInt(tid);
			Product pr = dao.getProductByID(Integer.parseInt(tid));
			System.out.println("Product Mã"+ pr);
			Item items = new Item();
			// giá bán
			items.setPrice(pr.getPrice());
			items.setProduct(pr);
			items.setQuantity(quantity);
			// đẩy vào giỏ hàng là cái items
			cart.addItem(items);	
			System.out.println("mã" + items);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBconnect.closeConnect();
		}
		// trả về danh sách các sản phẩm trong cái cart
		List<Item> list = cart.getItems();
		System.out.println(list);
		session.setAttribute("cart", cart);
		session.setAttribute("size", list.size());
		request.getRequestDispatcher("Cart.jsp").forward(request, response);
		
	}

}
