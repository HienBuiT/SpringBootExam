package com.poly.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.entity.Products;
import com.poly.entity.Report;

public interface ProductDAO extends JpaRepository<Products, Integer>{
	@Query("SELECT o FROM Products o WHERE o.price BETWEEN ?1 AND ?2")
	List<Products> findByPrice(double minPrice, double maxPrice);

	List<Products>findByPriceBetween(double minPrice,double maxPrice);
	
	
	@Query("SELECT o FROM Products o WHERE o.name LIKE ?1")
	Page<Products>findByKeywords(String keywords,Pageable pageable);
	Page<Products>findAllByNameLike(String keywords,Pageable pageable);
	
	@Query("select new Report (p.categories, sum (p.price), count (p)) " +
	        "from Products p group by p.categories order by sum (p.price) desc")
    List<Report> getInventoryByCategories();
	Page<Products> findAllByPriceIs(Double keywords, Pageable pageable);
}
