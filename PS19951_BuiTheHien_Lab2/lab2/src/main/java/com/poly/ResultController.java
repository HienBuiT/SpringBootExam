package com.poly;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class ResultController {
	@RequestMapping("/abc")
	public String m1() {
		return "a";
	}
	@RequestMapping("/b")
	public String m2(Model model) {
		model.addAttribute("message","i come from b");
		return "forward:/abc";
	}
	@RequestMapping("/c")
	public String m3(RedirectAttributes params){
		params.addAttribute("message","i come from c");
		return "redirect:/abc";
	}
	@ResponseBody
	@RequestMapping("/d")
	public String m4() {
		return "I come from d";
	}

}
