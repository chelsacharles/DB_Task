package com.example.model;

public class Response {
	
	private String name;
	private String email;
	private String skill;
	private int emp_id;
	private int count;
	private int rating;
	
	
	public Response(String name, String email, String skill, int emp_id, int count, int rating) {
		super();
		this.name = name;
		this.email = email;
		this.skill = skill;
		this.emp_id = emp_id;
		this.count = count;
		this.rating = rating;
	}
	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	
	

}
