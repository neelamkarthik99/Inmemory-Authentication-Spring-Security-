package com.springsecurity.securityinspringboot.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class qController 
{
	@GetMapping("/")
	public String hello()
	{
		return "hello";
	}	
	
	@GetMapping("/ShowLoginForm")
	public String loginForm()
	{
		return "login-form";
	}
	
	@GetMapping("/manager")
	public String manager()
	{
		return "manager";
	}
	
	@GetMapping("/admin")
	public String admin()
	{
		return "admin";
	}
	
	@GetMapping("/access-denied")
	public String accessDenied()
	{
		return "access-denied";
	}
}