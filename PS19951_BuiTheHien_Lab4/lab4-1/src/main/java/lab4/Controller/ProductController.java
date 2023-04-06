package lab4.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lab4.Utils.DataSharing;

@Controller
public class ProductController {
	@GetMapping("/product")
	public String getProduct(Model model) {
		model.addAttribute("product", DataSharing.products.values());
		return "product";
	}
}
