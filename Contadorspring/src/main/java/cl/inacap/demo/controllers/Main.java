package cl.inacap.demo.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Main {
	
	@RequestMapping("/")
	public String contar(HttpSession session, Model model) {
        Integer count = (Integer) session.getAttribute("count");
        if (count == null) {
        	count =0;
        }
        count +=1;
        session.setAttribute("count", count);
        model.addAttribute("count", count);
		return "index.jsp";
	}
	
	@RequestMapping("/counter")
	public String counter (HttpSession session, Model model){
		Integer count = (Integer) session.getAttribute("count");
        if (count == null) {
        	count =0;
        }
        session.setAttribute("count", count);
        model.addAttribute("count", count);
        return "contador.jsp";
    }
	
	@RequestMapping("/dos")
	public String contar2(HttpSession session) {
        Integer count = (Integer) session.getAttribute("count");
        if (count == null) {
        	count =0;
        }
        count +=2;
        session.setAttribute("count", count);
		return "index.jsp";
	}
	
	@RequestMapping("/clean")
	public String limpiador(HttpSession session, Model model) {
        Integer count = (Integer) session.getAttribute("count");
        count = 0;
        session.setAttribute("count", count);
        model.addAttribute("count", count);
		return "contador.jsp";
	}
	
	
	

}
