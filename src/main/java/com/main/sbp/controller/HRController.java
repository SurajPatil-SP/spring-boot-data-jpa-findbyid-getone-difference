package com.main.sbp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.sbp.service.HRService;

@RestController
@RequestMapping("/api")
public class HRController {

	@Autowired
	private HRService hrService;
	
	@GetMapping("/save/{id}")
	public String saveEmployee (@PathVariable ("id") long id) {
		hrService.createEmployee2(id);
		return "Employee Saved Successfully";
	}
}
