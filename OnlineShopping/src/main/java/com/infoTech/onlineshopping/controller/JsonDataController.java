package com.infoTech.onlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.infoTech.shoppingbackend.dao.ProductDAO;
import com.infoTech.shoppingbackend.dto.Product;

@Controller
@RequestMapping("/json/data")
public class JsonDataController {

	@Autowired
	private ProductDAO productDAO;
	
	
	@RequestMapping("/all/products")
	@ResponseBody
	public List<Product> getAllProduct(){
		
		return productDAO.listActiveProducts();	
		
	}
	
	
	@RequestMapping("/category/{id}/products")	
	@ResponseBody
	public List<Product> getProductByCategory(@PathVariable int id){
		
		return productDAO.listActiveProductsByCategory(id);
	}
}
