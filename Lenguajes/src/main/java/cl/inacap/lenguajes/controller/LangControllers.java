package cl.inacap.lenguajes.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cl.inacap.lenguajes.models.Language;
import cl.inacap.lenguajes.service.LangService;




@Controller
public class LangControllers {
	private final LangService langService;

	public LangControllers(LangService langService) {
		this.langService=langService;
	}
	
	@RequestMapping("/languages")
	public String dashboard(@ModelAttribute("newL") Language lang, Model m) {
		List<Language> l=langService.all();
		m.addAttribute("lang", l);	
		return "index.jsp";
	}
	
	@RequestMapping(value="/languages", method=RequestMethod.POST)
	public String newL(@Valid @ModelAttribute("newL") Language lang, BindingResult result, Model m) {
		
		if(result.hasErrors()) {
			return "index.jsp";
		
		}else {
		
		langService.addL(lang);
		return "redirect:/languages";
	  }
	
	}
	@RequestMapping("/languages/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		
		Language l = langService.findL(id);
		model.addAttribute("lang", l);
		return "edit.jsp";
	}

	@RequestMapping(value = "/languages/edit/{id}", method = RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("lang") Language lang, BindingResult result) {
		
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
			langService.update(lang);
			return "redirect:/languages";
		}
	}
	
	@RequestMapping(value = "/languages/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		
		langService.delete(id);
		return "redirect:/languages";
	}
	
	@RequestMapping("/languages/{id}")
	public String view(@PathVariable("id") Long id, Model model) {
		
		Language l = langService.findL(id);
		if (l == null) {
			return "redirect:/languages";
		}
		model.addAttribute("lang", l);
		return "show.jsp";
	}

	
}
