package cl.relationships.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.relationships.models.Person;

@Repository
public interface PersonRepo extends CrudRepository<Person, Long>{

	List<Person> findAll();

}
