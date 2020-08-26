package cl.relationships.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.relationships.models.License;
import cl.relationships.models.Person;
import cl.relationships.repositories.LicenseRepo;
import cl.relationships.repositories.PersonRepo;

@Service
public class PersonService {

	@Autowired
	private PersonRepo personRepo;
	@Autowired
	private LicenseRepo licenseRepo;	

	public List<Person> findAll(){
		return personRepo.findAll();

	}

	public Person findOne(Long id) {
		Optional<Person> opt = personRepo.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		}
		return null;
	}


	//Creando una persona
	public Person createPerson(Person b) {
		return personRepo.save(b);
	}

	//Creando una licencia
	public License createLicense(License l) {

		l.setNumber(String.valueOf(new Date().getTime()));
		return licenseRepo.save(l);
	}



}
