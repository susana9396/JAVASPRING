package cl.inacap.lenguajes.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.inacap.lenguajes.models.Language;

@Repository
public interface LangRepo extends CrudRepository <Language, Long>{
	List <Language> findAll();
}
