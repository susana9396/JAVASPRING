package cl.inacap.dojo.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.inacap.dojo.models.Dojo;
import cl.inacap.dojo.models.Ninja;
import cl.inacap.dojo.repository.DojoRepo;

@Service
public class DojoService {
	@Autowired
	private DojoRepo dojoRepo;

	@Autowired
	private NinjaRepo ninjaRepo;

	public List <Dojo> findAlld(){
		return dojoRepo.findAll();
	}

	public List <Ninja> findAlln(){
		return ninjaRepo.findAll();
	}

	public Dojo findDojo(Long id) {
		Optional<Dojo> optDojo = dojoRepo.findById(id);
		if(optDojo.isPresent()) {
			return optDojo.get();
		} else {
			return null;
		}
	}

	public void createDojo(@Valid Dojo dojo) {
		dojoRepo.save(dojo);

	}

	public void createNinja(@Valid Ninja ninja) {
		ninjaRepo.save(ninja);

	}




}
