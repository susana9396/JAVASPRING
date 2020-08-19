package cl.inacap.demo.controllers;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.inacap.demo.models.Activity;

@Controller
public class Main {
	
	
	@RequestMapping ("/")
	public String index( Model model, HttpSession session) {
		ArrayList<Activity> activities = (ArrayList<Activity>) session.getAttribute("activities");
		Integer gold = (Integer) session.getAttribute("gold");
		
		if(activities == null) {
			activities = new ArrayList<Activity>();
			session.setAttribute("activities", activities);
		}	
		if(gold == null) {
			gold = 0;
			session.setAttribute("gold", 0);
		}
		
		
		model.addAttribute("activities", activities);
		model.addAttribute("gold", gold);
		
		return "index.jsp";
	}
	
	
	@PostMapping ("/")
	public String Gold( @RequestBody() String boton, HttpSession session) {
		ArrayList<Activity> activities = (ArrayList<Activity>) session.getAttribute("activities");
		Integer gold = (Integer) session.getAttribute("gold");
		SimpleDateFormat formatter = new SimpleDateFormat("(MMMM, dd, yyyy, h:mm aa)");
		Date date = new Date();
		String fecha= formatter.format(date);
		String lugar = boton.substring(0, boton.indexOf("=") );
		Random random = new Random();
		Activity ac = new Activity();
		String clase = "green";
		int n = 0;
		String text = "you entered a ";
		String gained = "gained";
		
		switch(lugar) {
			case "farm":
				n = random.nextInt(10)+10;
				text += lugar+" and "+ gained+" gold "+n+", "+ fecha;
				ac.setMensaje(text);
				ac.setColor(clase);
				activities.add(ac);
				break;
				
			case "cave":
				n = random.nextInt(5)+5;
				text += lugar+" and "+ gained+" gold "+n+", "+ fecha ;
				ac.setMensaje(text);
				ac.setColor(clase);
				activities.add(ac);
				break;
				
			case "house":
				n = random.nextInt(3)+2;
				text += lugar+" and "+ gained+" gold "+n+", "+ fecha;
				ac.setMensaje(text);
				ac.setColor(clase);
				activities.add(ac);
				break;
				
			case "casino":
				n = random.nextInt(50);
				if(random.nextInt(2) == 1) {
					n = -n;
					gained = "lost";
					clase = "red";
				}
				text += lugar+" and "+ gained+" gold "+n+", "+ fecha;
				ac.setMensaje(text);
				ac.setColor(clase);
				activities.add(ac);
				break;
				
			case "spa":
				n = random.nextInt(15)+5;
				n = -n;
				gained = "lost";
				clase = "red";
				text += lugar+" and "+ gained+" gold "+n+", "+ fecha;
				ac.setMensaje(text);
				ac.setColor(clase);
				activities.add(ac);
				break;
		}
		gold += n;
		session.setAttribute("gold", gold);
		session.setAttribute("activities", activities);
		if(gold < 0) {
			return "redirect:/jail";
		}
		return "redirect:/";
		
	}
	
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping("/jail")
	public String carcel() {
		return "jail.jsp";
		
	}
	
	
}
