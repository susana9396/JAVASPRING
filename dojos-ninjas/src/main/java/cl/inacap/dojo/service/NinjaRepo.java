package cl.inacap.dojo.service;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.inacap.dojo.models.Ninja;


@Repository
public interface NinjaRepo extends CrudRepository <Ninja, Long> {
	List<Ninja> findAll();
}
