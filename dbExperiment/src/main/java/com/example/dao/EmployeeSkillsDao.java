package com.example.dao;

import java.util.List;

import com.example.model.Response;




public interface EmployeeSkillsDao {

	public List<Response> getSkilledPeople(List<String> skills, int rating, int experience);
	
	List<Response> getSkillCount();
	
	List<Response> getProjectExpense(String category, String project);
	
	List<Response> getUnitExpense(String category, String unit);
	
	
	

}
