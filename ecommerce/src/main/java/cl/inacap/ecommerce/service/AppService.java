package cl.inacap.ecommerce.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.inacap.ecommerce.models.Category;
import cl.inacap.ecommerce.models.Product;
import cl.inacap.ecommerce.repository.CategoryRepo;
import cl.inacap.ecommerce.repository.ProductRepo;

@Service
public class AppService {
	
    @Autowired
	private  CategoryRepo categoryRepo;
   
  
    @Autowired
	private  ProductRepo productRepo;
  
 
	
    public List<Product> allProducts(){
    	return productRepo.findAll();
    }

    
    public List<Category> allCategories(){
    	return categoryRepo.findAll();
    }


	public  Product createProduct(@Valid Product product) {
		return productRepo.save(product);
		
	}


	public Category createCategory(@Valid Category category) {
		return categoryRepo.save(category);
		
	}


	public Product findProduct(Long id) {
		Optional <Product> opProduct= productRepo.findById(id);
		if(opProduct.isPresent()) {
			return opProduct.get();
			
		}
		return null;
		
	}


	public Category findCategory(Long id) {
		Optional <Category> opCategory= categoryRepo.findById(id);
		if(opCategory.isPresent()) {
			return opCategory.get();
			
		}
		return null;
	}


	public Product addCategory(@Valid Category category, Long id) {
		Product product= findProduct(id);
		if(product==null) {
			return null;
		}
		product.getCategories().add(category);
		return productRepo.save(product);
	}


	public Category addProduct(Product prod, Long productId) {
		Category category=findCategory(productId);
		if(category==null) {
			return null;
		}
		category.getProducts().add(prod);
		return categoryRepo.save(category);
	}
	
	

}
