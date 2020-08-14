package cl.inacap.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HolaHumano {
	@RequestMapping("")
	public String human(@RequestParam(value="name", defaultValue = "Human" ,required = false) String name,
			            @RequestParam(value="lastname", defaultValue = "", required = false) String lastname) {
		
			return "<h1>Hello " + name + " " + lastname + "&nbsp"+  "<a href='http://localhost:8080/'> Go Back  </a>" +"</h1> "
					
					+ "<br>"+  
			      
				   "<h2>Welcome to SpringBoot</h2>";
		
		
		
	}

}
