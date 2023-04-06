package lab4.Utils;

import java.util.HashMap;

import lab4.Entities.Product;

public class DataSharing {
	public static HashMap<Integer, Product> products = new HashMap<>();
	
	static {
		products.put(1, new Product(1,"Laptop Dell Inspriron",15000000,15,"dell.jpg"));
		products.put(2, new Product(2,"Laptop Asus TUF",18000000,10,"asustuf.jpg"));
		products.put(3, new Product(3,"Laptop Asus ROG",25000000,25,"asusrog.jpg"));
		products.put(4, new Product(4,"Iphone 13 Pro Max",32000000,30,"iphone13.jpg"));
		products.put(5, new Product(5,"Samsung 22 Ultra",28000000,27,"samsung22.jpg"));
	}
}
