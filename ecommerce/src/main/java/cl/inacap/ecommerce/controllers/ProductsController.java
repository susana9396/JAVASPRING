package cl.inacap.ecommerce.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cl.inacap.ecommerce.models.Category;
import cl.inacap.ecommerce.models.Product;
import cl.inacap.ecommerce.service.AppService;



@Controller
@RequestMapping("/products")
public class ProductsController {
	
	@Autowired
	private AppService appService;
	
	@GetMapping("/new")
	public String form(@ModelAttribute ("productatr") Product product) {
		return "/tienda/newproduct.jsp";
	}
	
	@PostMapping("/new" )
	public String save(@Valid @ModelAttribute("productatr") Product product, BindingResult result) {
		if (result.hasErrors()) {
			return "/tienda/newproduct.jsp";
		} else {

			appService.createProduct(product);
			return "redirect:/products/new";
		}	
	}
	
	@GetMapping("/{id}")
	public String show(@PathVariable("id") Long id, Model m) {

			
			Product p=appService.findProduct(id);
			if (p==null) {
				return "redirect:/products/new";
			} else {
				List <Category> a=appService.allCategories();
				m.addAttribute("categories", a);
				m.addAttribute("product", p);
				return "/tienda/showproduct.jsp";
			}
		
	
	}
	
	@PostMapping("/{id}" )
	public String productForm(@RequestParam(name="categories") Category cat , @PathVariable("id") Long productId) {
		 
			appService.addCategory(cat, productId);
			return "redirect:/products/" + productId ;
		
	}
	
}
