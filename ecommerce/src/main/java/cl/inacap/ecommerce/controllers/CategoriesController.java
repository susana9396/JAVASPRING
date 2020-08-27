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
@RequestMapping("/categories")
public class CategoriesController {
	
	@Autowired
	private AppService appService;
	
	@GetMapping("/new")
	public String form(@ModelAttribute ("categoryatr") Category category) {
		return "/tienda/newcategory.jsp";
	}
	
	@PostMapping("/new" )
	public String save(@Valid @ModelAttribute("categoryatr") Category category, BindingResult result) {
		if (result.hasErrors()) {
			return "/tienda/newcategory.jsp";
		} else {

			appService.createCategory(category);
			return "redirect:/categories/new";
		}	
	}
	
	
	@GetMapping("/{id}")
	public String show(@PathVariable("id") Long id, Model m) {

			
			Category g=appService.findCategory(id);
			if (g==null) {
				return "redirect:/categories/new";
			} else {
				List <Product> a=appService.allProducts();
				m.addAttribute("products", a);
				m.addAttribute("category", g);
				return "/tienda/showcategory.jsp";
			}		
	
	}
	
	@PostMapping("/{id}" )
	public String categoryForm(@RequestParam(name="product") Product prod , @PathVariable("id") Long categoryId) {
		 
			appService.addProduct(prod, categoryId);
			return "redirect:/categories/" + categoryId ;
		
	}
	
	
}
