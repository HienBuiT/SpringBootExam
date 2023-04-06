package com.poly.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.dao.ProductDAO;
import com.poly.entity.Products;
import com.poly.entity.Report;
import com.poly.service.SessionService;


@Controller
public class productController {
	@Autowired
	ProductDAO dao;
	@Autowired
	SessionService session;
	@GetMapping("/product/sort")
	public String sort(Model model,@RequestParam Optional<String> field) {
		
		Sort sort =Sort.by(Direction.ASC,field.orElse("price")); 
		model.addAttribute("field",field.orElse("price").toUpperCase());
		List<Products> products = dao.findAll(sort);
		model.addAttribute("products",products);
		return "product/index";
	}
	@GetMapping("/product/page")
	public String paginate(Model model, @RequestParam Optional<Integer> page) {
		Pageable pageable = PageRequest.of(page.orElse(0), 5);
		Page<Products> pages = dao.findAll(pageable);
		model.addAttribute("page", pages);
		return "/pagination/index";		
	}
	@GetMapping("/product/search")
	public String search(Model model,@RequestParam("min") Optional<Double> min,
			@RequestParam("max") Optional<Double> max) {
		double minPrice=min.orElse(Double.MIN_VALUE);
		double maxPrice=max.orElse(Double.MAX_VALUE);
		List<Products> items = dao.findByPrice(minPrice, maxPrice);
		model.addAttribute("items",items);
		return "/product/search";
	}
	@GetMapping("/product/search-page")
	public String seachAndPage(Model model,
			@RequestParam("keywords") Optional<String> kw,
			@RequestParam("p") Optional<Integer> p) {
		String kwords = kw.orElse(session.get("keywords",""));
		session.set("keywords", kwords);
		Pageable pageable = PageRequest.of(p.orElse(0),5);
		Page<Products> page=dao.findByKeywords("%"+kwords+"%", pageable);
		model.addAttribute("page",page);
		return "/product/search-page";
	}
	@GetMapping("/report/inventorybycategory")
	public String inventory(Model model){
		List<Report> items= dao.getInventoryByCategories();
		model.addAttribute("items",items);
		return "/report/inventorybycategory";
		
	}
	@GetMapping("/product/search1")
	public String search1(Model model,@RequestParam("min") Optional<Double> min,
			@RequestParam("max") Optional<Double> max) {
		double minPrice=min.orElse(Double.MIN_VALUE);
		double maxPrice=max.orElse(Double.MAX_VALUE);
		List<Products> items = dao.findByPriceBetween(minPrice, maxPrice);
		model.addAttribute("items",items);
		return "/product/search";
	}
	@GetMapping("/product/search-page1")
	public String seachAndPage1(Model model,
			@RequestParam("keywords") Optional<String> kw,
			@RequestParam("p") Optional<Integer> p) {
		String kwords = kw.orElse(session.get("keywords",""));
		session.set("keywords", kwords);
		Pageable pageable = PageRequest.of(p.orElse(0),5);
		Page<Products> page;
		try {
			Double numberKwords = Double.parseDouble(kwords);
			page = dao.findAllByPriceIs(numberKwords, pageable);
		} catch (Exception e) {
			page = dao.findAllByNameLike("%" + kwords + "%", pageable);
		}

		model.addAttribute("page",page);
		return "/product/search-page1";
	}
}
