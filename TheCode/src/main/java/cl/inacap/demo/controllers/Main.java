package cl.inacap.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class Main {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "index.jsp";
		
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String validateCode(@RequestParam(value = "codigo") String codigo, RedirectAttributes redirectAttributes ) {
		
		if(codigo.equals("bushido")) {
			return "redirect:/code";
		}else {
			redirectAttributes.addFlashAttribute("error", "Entrena mas duro");
			return "redirect:/";
		}
	}
	
	@RequestMapping("/code")
	public String code() {
		return "code.jsp";
	}
}
