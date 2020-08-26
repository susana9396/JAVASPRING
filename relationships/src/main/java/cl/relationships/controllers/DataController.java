package cl.relationships.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cl.relationships.models.License;
import cl.relationships.models.Person;
import cl.relationships.services.PersonService;

@Controller
public class DataController {

	private final PersonService personService;

	public DataController(PersonService personService) {
		this.personService = personService;
	}

	@RequestMapping("/persons/new")
	public String index(@ModelAttribute("person") Person persona) {
		return "/persons/person.jsp";
	}

	@RequestMapping(value="/persons", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("person") Person persona, BindingResult result) {
		if (result.hasErrors()) {
			return "/persons/person.jsp";
		} else {
			personService.createPerson(persona);
			return "redirect:/persons/new";
		}    
	}

	@RequestMapping("/licenses/new")
	public String index(@ModelAttribute("license") License licencia, Model model) {
		List<Person> personas =	personService.findAll();
		model.addAttribute("persons", personas);

		return "/licenses/license.jsp";
	}    

	@RequestMapping(value="/licenses", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("license") License licencia, BindingResult result) {
		if (result.hasErrors()) {
			return "/licenses/license.jsp";
		} else {
			personService.createLicense(licencia);
			return "redirect:/licenses/new";
		}    
	}
	@RequestMapping("/persons/{id}")
	public String index(@PathVariable("id") Long id, Model m) {
		Person	p=personService.findOne(id);
		if (p==null) {
			return "redirect:/persons/new";
		} else {
			m.addAttribute("persons", p);

			return "/persons/showdata.jsp";
		}

	}
}