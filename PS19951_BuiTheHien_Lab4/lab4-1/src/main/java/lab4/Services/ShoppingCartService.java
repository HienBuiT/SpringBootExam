package lab4.Services;

import java.util.Map;

import lab4.Entities.Product;

public interface ShoppingCartService {
	
	//Them mat hang vao gio hang hoac tang so luong len 1 neu da ton tai
	void addProduct(Integer id);
	
	//Xoa mat hang ra khoi gio hang
	void removeProduct(Integer id);
	
	//Thay doi so luong len cua mat hang trong gio hang
	void updateProduct(Integer id, int qty);
	
	//Xoa tat ca mat hang trong gio hang
	void clear();
	
	//Lay tat ca cac mat hang trong gio
	Map<Integer, Product> getProduct();
	
	//Lay tong so luong cac mat hang trong gio
	int getCount();
	
	// Lay tong so tien tat ca cac mat hang trong gio
	double getAmount();
}
