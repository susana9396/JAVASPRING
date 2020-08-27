package cl.inacap.ecommerce.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.inacap.ecommerce.models.Product;

@Repository
public interface ProductRepo extends CrudRepository <Product, Long>{
	List<Product> findAll();
}
