package com.saptha.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.saptha.model.Customer;

@Controller
public class CustomerOperationController {
	
	@GetMapping("/")
	public String showFormPage(@ModelAttribute("cust")Customer cust) {
		return "customer_register_form";
	}
	
	@PostMapping("/register")
	public String processFormPage(Map<String,Object> map,@ModelAttribute("cust")Customer cust) {
		System.out.println(cust);
		map.put("formData", cust);
		return "show_result";
	}
	
	@InitBinder
	public void myBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("dd-MM-yyyy"), true));
	}
}
