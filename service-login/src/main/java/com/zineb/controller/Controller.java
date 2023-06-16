package com.zineb.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.zineb.entity.Login;
import com.zineb.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
public class Controller {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/")
	public ModelAndView first() {
		return  new ModelAndView("login");
	}
	
	@GetMapping("/index")
	public ModelAndView index() {
		return  new ModelAndView("index");
	}
	
	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("user", new Login());
		return mv;
	}
	
	@PostMapping("/login")
	public ModelAndView login(@ModelAttribute("user") Login user ) {
		Login oauthUser = service.login(user.getUsername(), user.getPassword());
		
		System.out.println(oauthUser);
		if(Objects.nonNull(oauthUser)) {
			return new ModelAndView("index");
		}
		else { 			
			return new ModelAndView("redirect:/login"); 
		}
	}
	
	@RequestMapping(value= {"/logout"}, method = RequestMethod.POST)
	public ModelAndView logoutDo(HttpServletRequest request, HttpServletResponse response ) {
		
		return new ModelAndView("redirect:/login");
	}

}
