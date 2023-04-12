package com.poly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.poly.model.Product;

@Controller
public class productController2 {
	List<Product> arl = new ArrayList<Product>();
	@GetMapping("/product2/form")
	public String doGetForm(Model model) {
		Product p = new Product();
		p.setName("iphone");
		p.setPrice(50000.0);
		model.addAttribute("product1",p);
		model.addAttribute("message", "Hello World");
		return "product/form";
	}
	@PostMapping("/product2/save")
	public String save(Product p,Model model) {
		arl.add(p);
		model.addAttribute("product2",p);
		return "product/form";
	}
	@GetMapping("/product2/edit/{name}")
	public String edit(@PathVariable String name,Model model) {
			Product prd = new Product();
			prd.setName(name);
			prd.setPrice(5000.0);
			model.addAttribute("productEdit",prd);
		return "product/form";
	}
	@ModelAttribute("item")
	public List<Product> getItem(){
		return arl;
	}
	
}
