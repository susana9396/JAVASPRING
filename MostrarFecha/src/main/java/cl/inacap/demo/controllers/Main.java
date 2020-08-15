package cl.inacap.demo.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Main {
	
	
	@RequestMapping("/")
	public String hola() {
		return "index.jsp";
	}
		
	@RequestMapping("/date")
	public String fecha(Model model){
		SimpleDateFormat formatter = new SimpleDateFormat("EEEE, dd MMMM, yyyy");
		Date date = new Date();
		String fechaFinal = formatter.format(date);
		model.addAttribute("fecha1", fechaFinal);
		return "date.jsp";
	}
	
	@RequestMapping("/time")
	public String hora(Model model){
		SimpleDateFormat formatter = new SimpleDateFormat("H mm aa");
		Date date = new Date();
		String horaFinal = formatter.format(date);
		model.addAttribute("hora1", horaFinal);
		return "time.jsp";
	}
	
	

}
