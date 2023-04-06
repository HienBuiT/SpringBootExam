package com.poly;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class sanPhamController {
	@GetMapping("/sanpham")
	public String doGetSanPham() {
		return "sanpham";
	}
	
	@GetMapping("/sanpham/{tensp}")
	public String doGetTenSP(@PathVariable String tensp,Model model) {
		model.addAttribute("sanpham",tensp);
		return "sanpham";
	}
}
