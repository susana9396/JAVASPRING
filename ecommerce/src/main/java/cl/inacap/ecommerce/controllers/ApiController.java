package cl.inacap.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.inacap.ecommerce.models.Category;
import cl.inacap.ecommerce.models.Product;
import cl.inacap.ecommerce.service.AppService;

@RestController
@RequestMapping("/api")
public class ApiController {
	@Autowired
	private AppService appService;
	
	@GetMapping("/categories")
	public List<Category> allCategories(){
		return appService.allCategories();
	}
	
	@GetMapping("/products")
	public List<Product> allProducts(){
		return appService.allProducts();
	}
}
