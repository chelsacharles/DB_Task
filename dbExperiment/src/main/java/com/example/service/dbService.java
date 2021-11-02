package com.example.service;

import org.springframework.stereotype.Service;



@Service
public interface dbService {
	
	
	String addUserExpenses(int start, int end);
	
	String addUserSkills(int start, int end);
	
	String addUser();

	String addUserExpensesjmeter(int emp_id, String title, int project_id, int category_id, String bill_no, int amount);

	

	

}