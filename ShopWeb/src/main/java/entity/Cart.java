package entity;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private List<Item> items;
	

	public List<Item> getItems() {
		return items;
	}


	public void setItems(List<Item> items) {
		this.items = items;
	}
	public Cart() {
		items = new ArrayList<Item>();
	}


	public Cart(List<Item> items) {
		this.items = items;
	}
	
	// lấy ra cái item
	private Item getItemById(int id) {
		for (Item i: items) {
			if(i.getProduct().getId() == id) {
				return i;
			}
		}
		return null;
	}
	
	// 2. trả về số lượng
	// B1 có id rồi tìm đc sp đó
	// B2 lấy đc số lượng của sp trong giỏ
	public int getQuanTityById(int id) {
		return getItemById(id).getQuantity();
	}
	
	// Thêm vào giỏ hàng
	public void addItem (Item t) {
		// trường hơp 1 có ở cart rồi
		// trường hợp 2 chưa có
		if (getItemById(t.getProduct().getId())!= null) {
			Item i = getItemById(t.getProduct().getId());
			// số lượng hiện tại + số lượng mới
			i.setQuantity(i.getQuantity()+t.getQuantity());
		} else {
			items.add(t);
		}
		
	}
	// bỏ đi sản phẩm trong giỏ hàng
	// đưa vào mã sp muốn xóa của giỏ hàng
	public void removeItem(int id) {
		if (getItemById(id) != null) {
			items.remove(getItemById(id));
		}
	}
	
	// Tổng tiền
	public double getTotalMoney() {
		double t =0;
		for (Item i: items) {
			t += i.getQuantity()* i.getPrice();
		}
		return t;
	}


	@Override
	public String toString() {
		return "Cart [items=" + items + "]";
	}
	
	


}
