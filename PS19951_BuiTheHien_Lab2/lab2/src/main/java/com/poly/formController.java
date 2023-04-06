package com.poly;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class formController {
	@GetMapping("/pheptinh/form")
	public String doGetForm() {
		return "form";
	}
	
	
	@PostMapping("/pheptinh")
	public String doGetPhepTinh1(@RequestParam("a") int a,@RequestParam("b") int b,Model model) {
		int ketqua=a+b;
		model.addAttribute("kq",ketqua);
		return "ketqua";
	}
}
