package lab4.Services.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import lab4.Entities.Product;
import lab4.Services.ShoppingCartService;
import lab4.Utils.DataSharing;

@Service
@SessionScope
public class ShoppingCartServiceImpl implements ShoppingCartService {
	private static HashMap<Integer, Product> orders = new HashMap<>();

	// Them mat hang vao gio hang hoac tang so luong len 1 neu da ton tai
	@Override
	public void addProduct(Integer id) {
		Product prod = DataSharing.products.get(id).orderProduct(1);
		if (!orders.containsKey(id)) {
			orders.put(prod.getId(), prod);
		} else if (prod != null) {
			int oldQuantity = orders.get(id).getQuantity();
			orders.get(id).setQuantity(oldQuantity + 1);
		}
	}

	// Xoa mat hang ra khoi gio hang
	@Override
	public void removeProduct(Integer id) {
		Product prod = orders.get(id);
		DataSharing.products.get(id).orderProduct(0 - prod.getQuantity());
		orders.remove(id);
	}

	// Thay doi so luong len cua mat hang trong gio hang
	@Override
	public void updateProduct(Integer id, int qty) {
		Product prod = orders.get(id);
		Product prodCheck = DataSharing.products.get(id).orderProduct(qty - prod.getQuantity());
		// Thay doi hoac xoa san pham
		if (qty > 0) {
			if (prodCheck != null) {
				prod.setQuantity(qty);
			}
		} else {
			orders.remove(id);
		}

	}

	// Xoa tat ca mat hang trong gio hang
	@Override
	public void clear() {
		for (Integer id : orders.keySet()) {
			Product prod = orders.get(id);
			DataSharing.products.get(id).orderProduct(0 - prod.getQuantity());
		}
		orders.clear();
	}

	// Lay tat ca cac mat hang trong gio
	@Override
	public Map<Integer, Product> getProduct() {
		return orders;
	}

	// Lay tong so luong cac mat hang trong gio
	@Override
	public int getCount() {
		int count = 0;
		for (Product prod : orders.values()) {
			count += prod.getQuantity();
		}
		return count;
	}

	// Lay tong so tien tat ca cac mat hang trong gio
	@Override
	public double getAmount() {
		double amount = 0;
		for (Product prod : orders.values()) {
			amount += prod.getPrice() * prod.getQuantity();
		}
		return amount;
	}
}
