package cl.relationships.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.relationships.models.Person;
import cl.relationships.services.PersonService;

@RestController
public class PersonaApiController {

	@Autowired
	private PersonService personService;

	@GetMapping("/")
	public List<Person> findAll(){
		return personService.findAll();
	}

}
