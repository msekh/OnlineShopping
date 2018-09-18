package com.mtech.onlineshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	
	@RequestMapping(value= {"/", "hoome", "/index"})	
	public ModelAndView index() {
		ModelAndView mv=new ModelAndView("home");
		mv.addObject("greeting", "Welcome Spring web mvc");	
		return mv;
	}

	
	@RequestMapping(value= {"/test/{greeting}"})
	public ModelAndView test(@PathVariable("greeting") String greeting) {
		if(greeting==null) {
			greeting="Hello here";
		}
		ModelAndView mv=new ModelAndView("home");
		mv.addObject("greeting",greeting);
		return mv;	
	}
}
