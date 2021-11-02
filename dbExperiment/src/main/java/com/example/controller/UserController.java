package com.example.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.EmployeeSkillsDao;
import com.example.model.Request;
import com.example.model.Response;
import com.example.service.dbService;

@RestController
public class UserController {

	
	@Autowired
	dbService dbservices;
	
	
	@Autowired
	EmployeeSkillsDao empdao;

	@GetMapping("/add/user")
	public String addUser() {
	 
		return dbservices.addUser();
	}
	
	
	@PostMapping("/add/userExpenses")
	public String addUserExpenses(@RequestBody Request r) {
		
		return dbservices.addUserExpenses(r.getStart(),r.getEnd());
	}
	@PostMapping("/add/userExpensejmeter")
	public String addUserExpensesjmeter(@RequestParam int emp_id,@RequestParam String title,@RequestParam int project_id,@RequestParam int category_id, @RequestParam String bill_no, @RequestParam int amount) {
		
		return dbservices.addUserExpensesjmeter( emp_id,  title,  project_id,  category_id, bill_no,  amount);
	}
	
	@PostMapping("/add/userSkills")
	public String addUserSkills(@RequestBody Request r) {
		
		return dbservices.addUserSkills(r.getStart(),r.getEnd());
	}
	
	
	@PostMapping("/get/projectExpense")
	public List<Response> getProjectExpense(@RequestBody Request r) {
		
		return empdao.getProjectExpense(r.getCategory(), r.getProject());
	}
	@PostMapping("/get/unitExpense")
	public List<Response> getUnitExpense(Request r) {
		
		return empdao.getUnitExpense(r.getCategory(), r.getUnit());
	}
	
	@PostMapping("/get/skilledPeople")
	public List<Response> getSkilledPeople(Request r) {
		
		return empdao.getSkilledPeople(r.getSkills(), r.getRating(), r.getExperience());
	}
	
	@PostMapping("/get/skillCount")
	public List<Response> getSkillCount() {
		
		return empdao.getSkillCount();
	}
	
	
	

	


}