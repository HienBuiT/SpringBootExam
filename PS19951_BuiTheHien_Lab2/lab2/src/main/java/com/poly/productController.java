package com.poly;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.model.Product;



@Controller
public class productController {
	@GetMapping("/product/form")
	public String form() {
		return "product/productForm";
	}
	
	@PostMapping("/product/save")
	public String save(Product p,Model model) {
		model.addAttribute("product",p);
		return "product/productForm";
	}
	
}
