package cl.inacap.dojo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.inacap.dojo.models.Dojo;
import cl.inacap.dojo.service.DojoService;

@RestController
public class DojoApiContrl {

	@Autowired
	
	private DojoService dojoService;
	
	@RequestMapping("/Api/allDojos")
	public List<Dojo> findAll(){
		return dojoService.findAlld();
	}
}
