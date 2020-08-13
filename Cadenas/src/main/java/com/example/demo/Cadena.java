package com.example.demo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Cadena {
	@RequestMapping("/")
	public String raiz(){
		return "Hello client!!";
	}
	@RequestMapping("/random")
	public String random(){
		return "Spring boot id great!!";
	}

}
