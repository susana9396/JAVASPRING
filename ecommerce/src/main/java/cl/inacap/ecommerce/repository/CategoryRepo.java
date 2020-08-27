package cl.inacap.ecommerce.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.inacap.ecommerce.models.Category;

@Repository
public interface CategoryRepo  extends CrudRepository <Category, Long>{
	List<Category> findAll();
}
