package com.zineb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class Controller {
	
	@GetMapping("/")
	public ModelAndView login() {
		return new ModelAndView("login");
	}
	
	@GetMapping("index")
	public ModelAndView index() {
		return new ModelAndView("index");
	}
	
	
}
