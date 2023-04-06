package lab4.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Cloneable{
	private int id;
	private String name;
	private double price;
	private int quantity;
	private String image;
	
	public Product orderProduct(int quantity) {
		Product prod = null;
		if(quantity <= this.quantity) {
			try {
				prod = (Product) this.clone();
				prod.setQuantity(quantity);
				this.quantity -= quantity;
			} catch (CloneNotSupportedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return prod;
	}
}
