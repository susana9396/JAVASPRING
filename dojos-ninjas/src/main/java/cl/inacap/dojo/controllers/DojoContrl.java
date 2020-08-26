package cl.inacap.dojo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cl.inacap.dojo.models.Dojo;
import cl.inacap.dojo.models.Ninja;
import cl.inacap.dojo.service.DojoService;

@Controller
public class DojoContrl {


	@Autowired
	private final DojoService dojoService;

	public DojoContrl(DojoService dojoService) {
		this.dojoService=dojoService;
	}


	@RequestMapping("/dojos/new")
	public String nbook(@ModelAttribute("dojos") Dojo dojo) {
		return "/pages/newDojo.jsp";
	}

	@RequestMapping(value="/dojos/new", method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result ) {

		if (result.hasErrors()) {
			return "/pages/newDojo.jsp";
		} else {

			dojoService.createDojo(dojo);
			return "redirect:/dojos/new";
		}	
	}

	@RequestMapping("/ninjas/new")
	public String index(@ModelAttribute("ninja") Ninja ninja, Model m) {
		m.addAttribute("dojos", dojoService.findAlld());

		return "/pages/newNinja.jsp";
	}    

	@RequestMapping(value="/ninjas/new", method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result ) {			

		if (result.hasErrors()) {
			return "/pages/newNinja.jsp";
		} else {

			dojoService.createNinja(ninja);
			return "redirect:/ninjas/new";
		}
	}

	@RequestMapping("/dojos/{id}")
	public String index (@PathVariable("id") Long id, Model m) {
		Dojo d=dojoService.findDojo(id);
		if (d==null) {
			return "redirect:/dojos/new";
		} else {
			m.addAttribute("dojo", d);

			return "/pages/show.jsp";
		}
	}
}