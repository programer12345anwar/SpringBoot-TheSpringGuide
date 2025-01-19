package com.thymeleaf.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

 

//@RestController  <!--The issue arises because you're using the @RestController annotation, which is intended to return data directly (e.g., JSON or plain text), not to render views. To return an HTML page as a view, you need to use the @Controller annotation instead.-->
@Controller
public class MyControler {
	
	//http://localhost:8080/about
	@GetMapping("/about")
	//@RequestMapping(value = "/about" , method = GET)<!-- you just need to use @Controller ,here not any issue-->
	public String about(Model model) {
		System.out.println("inside about method");
		model.addAttribute("name","md anwar alam");
		model.addAttribute("currentDate", new Date());
		model.addAttribute("a",12);
		model.addAttribute("b",13);
		return "about";//about.html will will be searched
	}
	
	//handling iteration
	
	@GetMapping("/example-loop")
	public String iterateHandler(Model m) {
		//create a list
		List<String> names = List.of("anwar","sadique","sarwar","naved");//ctrl+1 ,first put cursor to the last and press ctrl+1 it will give suggessions and put enter
		//send data--> data is send by Model model
		m.addAttribute("names", names);
		return "iterate";//iterate.html will be loaded
	}
	
	//condition handler statements
	
	@GetMapping("/condition")
	public String conditionalHandler(Model model) {
		System.out.println("initializing conditional handler");
		
		 
		model.addAttribute("isActive",true);//here isactive used as a key ,if you want to use as a variable ,for that first declare and then directly use without double quote
		model.addAttribute("gender", "F");
		
		List<Integer> list=List.of(233);
		model.addAttribute("myList", list);
		
		return "condition";//condition.html
	}
	
	//handler for including fragment
	
	@GetMapping("/services")
	public String serviceHandler(Model model) {
		System.out.println("this is service");
		model.addAttribute("title","i like to eat mango");
		model.addAttribute("subtitle",LocalDateTime.now().toString());
		return "service";//service.html page will be searched and loaded if not then resource not found exception
	}
	
	//for new about
	@GetMapping("/newabout")
	public String newAbout() {
		
		return "newAbout";
	}
	
	//for contact
		@GetMapping("/contact")
		public String contact() {
			
			return "contact";
		}


}
