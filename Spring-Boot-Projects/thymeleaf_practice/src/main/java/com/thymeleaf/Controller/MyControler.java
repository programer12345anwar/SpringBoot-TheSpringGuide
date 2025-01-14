package com.thymeleaf.Controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//@RestController
@Controller
public class MyControler {
	
	//http://localhost:8080/about
	//@GetMapping("/about")
	@RequestMapping(value = "/about" , method = GET)
	public String about() {
		System.out.println("inside about method");
		return "about";//about.html will will be searched
	}

}
