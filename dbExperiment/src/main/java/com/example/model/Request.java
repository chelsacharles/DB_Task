package com.example.model;

import java.util.List;

public class Request {
	

	private String project;
	private String unit;
//	private String skill;
	private List<String> skills;
	private String category;
	private int rating;
	private int start;
	private int end;
	private int experience;
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
//	public String getSkill() {
//		return skill;
//	}
//	public void setSkill(String skill) {
//		this.skill = skill;
//	}
	
	public String getCategory() {
		return category;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	
	public List<String> getSkills() {
		return skills;
	}
	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
	//	public Request(String project, String unit, String skill, String category, int rating, int experience) {
//		super();
//		this.project = project;
//		this.unit = unit;
//		this.skill = skill;
//		this.category = category;
//		this.rating = rating;
//		this.experience = experience;
//	}
	public Request(String project, String unit, List<String> skills, String category, int rating, int experience) {
	super();
	this.project = project;
	this.unit = unit;
	this.skills = skills;
	this.category = category;
	this.rating = rating;
	this.experience = experience;
}
	public Request() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}