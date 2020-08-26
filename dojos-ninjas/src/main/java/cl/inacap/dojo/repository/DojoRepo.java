package cl.inacap.dojo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.inacap.dojo.models.Dojo;

@Repository
public interface DojoRepo extends CrudRepository<Dojo, Long> {
   List<Dojo> findAll();
}
