package lab4.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lab4.Services.ParamService;
import lab4.Services.SessionService;
import lab4.Services.ShoppingCartService;

@Controller
@RequestMapping("/cart")
public class CartController {
	@Autowired
	ShoppingCartService cart;
	@Autowired
	ParamService param;
	@Autowired
	SessionService session;
	
	@GetMapping("view")
	public String getLogin(Model model) {
		model.addAttribute("cart",cart.getProduct());
		model.addAttribute("amount",cart.getAmount());
		return "cart";
	}
	
	@GetMapping("add/{id}")
	public String addtoCart(@PathVariable int id, Model model) {
		cart.addProduct(id);
		session.set("cartQuantity",cart.getCount());
		model.addAttribute("message","Add success!");
		return "redirect:/product";
	}
	
	@PostMapping("update/{id}")
	public String updateCart(@PathVariable int id, Model model) {
		cart.updateProduct(id, param.getInt("quantity", 0));
		model.addAttribute("message","Update success!");
		return "redirect:/cart/view";
	}
	
	@GetMapping("remove/{id}")
	public String removeFormCart(@PathVariable int id, Model model) {
		cart.removeProduct(id);
		model.addAttribute("message","Add success!");
		return "redirect:/cart/view";
	}
	
	@GetMapping("clear")
	public String clearCart(Model model) {
		cart.clear();
		model.addAttribute("message","Clear success!");
		return "redirect:/cart/view";
	}
}
