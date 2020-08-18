package cl.inacap.dojosurvey.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class Data {
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping(value="/result", method=RequestMethod.POST)
	public String showResults(
			@RequestParam(value="name") String nombre, 
			@RequestParam(value="local") String locacion, 
			@RequestParam(value="lang") String lenguaje, 
			@RequestParam(value="comment") String comentarios,
			RedirectAttributes redirectAttributes,
			Model md
			
	) {
		
		if(nombre.equals("") || locacion.equals("") || lenguaje.equals("")) {
			redirectAttributes.addFlashAttribute("error", "Debes llenar todos los campos nombre, locacion y lenguaje");
			return "redirect:/";
		}
		

		md.addAttribute("name", nombre);
		md.addAttribute("location", locacion);
		md.addAttribute("language", lenguaje);
		md.addAttribute("comment", comentarios);
		
		if(lenguaje.equalsIgnoreCase("java")) {
			return "javaresult.jsp";
		}
		return "results.jsp";
	}


}
