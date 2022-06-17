package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import entity.Category;
import entity.Product;

/**
 * Servlet implementation class Home
 */
@WebServlet("/home")
public class Home extends HttpServlet {
private static final long serialVersionUID = 1L;
      static List <Product> listP = new ArrayList <Product>();
      static List <Category> listC = new ArrayList<Category>();
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//			Product list1 = new Product("1","GIÃ€Y CHáº Y Bá»˜","./img/imagine 1.jpg",3500000,"GiÃ y Cháº¡y Bá»™ Nam Hoka Mach 4","Mach 4 lÃ  bÆ°á»›c nháº£y vá»�t lá»›n nháº¥t cá»§a dÃ²ng sáº£n pháº©m nÃ y, xÃ¢y dá»±ng vÃ  láº¥y cáº£m há»©ng tá»« Rocket X vÃ  Carbon X. Ä�Æ°á»£c thiáº¿t káº¿ cho cÃ¡c cháº·ng Ä‘Æ°á»�ng dÃ i, Ä‘Ã´i giÃ y huáº¥n luyá»‡n hÃ ng ngÃ y nÃ y mang Ä‘áº¿n cho báº¡n nhá»¯ng dáº·m Ä‘Æ°á»�ng trÃ n Ä‘áº§y nÄƒng lÆ°á»£ng dÆ°á»›i chÃ¢n.");
//			Product list2 = new Product("2","GIÃ€Y CHáº Y Bá»˜","./img/imagine 2.jpg",3990000,"GiÃ y Cháº¡y Bá»™ Nam Hoka Mach Supersonic","Hoka Mach Supersonic lÃ  Ä‘Ã´i giÃ y phong cÃ¡ch vá»›i thiáº¿t káº¿ Ä‘Æ¡n giáº£n, mang láº¡i sá»± thoáº£i mÃ¡i tá»‘i Æ°u cho ngÆ°á»�i sá»­ dá»¥ng. ThÃ¢n giÃ y Ä‘Æ°á»£c lÃ m tá»« cháº¥t liá»‡u váº£i Ä‘an dá»‡t há»�a tiáº¿t jacquard vá»›i phá»‘i mÃ u báº¯t máº¯t táº¡o Ä‘iá»ƒm nháº¥n cho trang phá»¥c thÆ°á»�ng ngÃ y.");
//			Product list3 = new Product("3","GIÃ€Y CHáº Y Bá»˜","./img/imagine 3.jpg",3850000,"GiÃ y Cháº¡y Bá»™ Nam Hoka Clifton Edge","Clifton Edge Ä‘Æ°á»£c thiáº¿t káº¿ Ä‘á»ƒ giÃºp báº¡n cáº£m tháº¥y nhÆ° thá»ƒ báº¡n cÃ³ thá»ƒ cháº¡y mÃ£i mÃ£i. Vá»›i sá»± káº¿t há»£p cá»§a Ä‘á»‡m Ä‘Ã¡p á»©ng vÃ  lá»›p foam má»�m nháº¥t, nháº¹ nháº¥t cá»§a HOKA, Ä‘Ã´i giÃ y nÃ y há»— trá»£ cho nhá»¯ng bÆ°á»›c chÃ¢n linh hoáº¡t.");
//			Product list4 = new Product("4","GIÃ€Y CHáº Y Bá»˜","./img/imagine 5.jpg",880000,"GiÃ y Thá»ƒ Thao Nam Biti's Hunter X Layered","Cáº£i tiáº¿n thiáº¿t káº¿ Ä‘á»™c Ä‘Ã¡o vá»›i xu hÆ°á»›ng #layer tá»« nhá»¯ng â€œÄ‘Æ°á»�ng cáº¯tâ€� cháº¥t liá»‡u Ä‘an xen, láº§n Ä‘áº§u tiÃªn cÃ³ máº·t táº¡i gia Ä‘Ã¬nh Thá»£ SÄƒn. Sá»Ÿ há»¯u cÃ´ng nghá»‡ vÆ°á»£t trá»™i chuáº©n Hunter X, sáºµn sÃ ng cÃ¹ng báº¡n khuáº¥y Ä‘á»™ng mÃ¹a hÃ¨ sÃ´i Ä‘á»™ng.");
//			Product list5 = new Product("5","GIÃ€Y CHáº Y Bá»˜","./img/imagine 6.jpg",8550000,"GiÃ y thá»ƒ thao Nam Biti's Hunter Running","GiÃ y thá»ƒ thao Nam Biti's Hunter Running DSMH03900 - CÃ´ng nghá»‡ Ä�áº¿ LiteBounce: CÃ´ng nghá»‡ Ä‘áº¿, hai lá»›p Ä‘á»™c quyá»�n dÃ nh riÃªng cho giÃ y cháº¡y, lÃ  sá»± káº¿t há»£p tuyá»‡t vá»�i giá»¯a Ä‘á»™ Ãªm vÃ  lá»±c Ä‘áº©y máº¡nh máº½, nhÆ° má»™t \"lÃ² xo\" háº¥p thá»¥ vÃ  pháº£n há»“i lá»±c nhá»‹p hÃ ng, giÃºp cho ngÆ°á»�i cháº¡y luÃ´n sung sá»©c.");
//			Product list6 = new Product("6","GIÃ€Y CHáº Y Bá»˜","./img/imagine 4.jpg",2195000,"GiÃ y Thá»ƒ Thao Ná»¯ New Balance 574 Classic","574 khÃ´ng chá»‰ lÃ  má»™t Ä‘Ã´i giÃ y. Vá»›i nhá»¯ng Ä‘Æ°á»�ng nÃ©t gá»�n gÃ ng, phá»‘i mÃ u Ä‘á»™c Ä‘Ã¡o vÃ  kiá»ƒu dÃ¡ng cá»• Ä‘iá»ƒn vÃ  Ä‘Æ°á»£c lÃ m tá»« cháº¥t liá»‡u cáº£i tiáº¿n, Ä‘Ã´i giÃ y sneaker nÃ y lÃ  biá»ƒu tÆ°á»£ng cá»§a sá»± khÃ©o lÃ©o vÃ  Ä‘á»™c Ä‘Ã¡o - báº¥t ká»ƒ báº¡n phá»‘i há»£p nÃ³ vá»›i báº¥t ká»³ phong cÃ¡ch nÃ o.");
//			list.add(list1);
//			list.add(list2);
//			list.add(list3);
//			list.add(list4);
//			list.add(list5);
//			list.add(list6);
//			Category listC1 = new Category("1","Thá»�i Trang");
//			Category listC2 = new Category("2","Ä�á»“ Gia Dá»¥ng");
//			Category listC3 = new Category("3","Ä�á»“ Ná»™i Tháº¥t");
//			Category listC4 = new Category("4","Ä�á»“ Ä�iá»‡n Tá»­");
//			Category listC5 = new Category("5","Thá»±c Pháº©m");
//			listC.add(listC1);
//			listC.add(listC2);
//			listC.add(listC3);
//			listC.add(listC4);
//			listC.add(listC5);	
//			for (Product pr:list) {
//				System.out.println(list);
//			}
//			for (Category ct:listC) {
//				System.out.println(listC);
//			}	
//			request.setAttribute("card", list);
//			request.setAttribute("cardC", listC);
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/Home.jsp");	
//			dispatcher.forward( request, response);
		        Dao dao = new Dao();
		        List<Product> listP = dao.getAllProduct();
		        List<Category> listC = dao.getAllCategory();		        
		        request.setAttribute("card", listP);
		        request.setAttribute("cardC", listC);
				for (Product pr:listP) {
					System.out.println(listP);
				}
				for (Category ct:listC) {
					System.out.println(listC);
				}	
		        request.getRequestDispatcher("Home.jsp").forward(request, response);
		}
		
			
		}




