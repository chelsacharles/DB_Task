package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

	
	@Entity
	@Table(name = "emp_skills")
	public class Employeeskills {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	 
	    private int emp_id;
	    private int skill_id;
	    private int rating;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getEmp_id() {
			return emp_id;
		}
		public void setEmp_id(int emp_id) {
			this.emp_id = emp_id;
		}
		public int getSkill_id() {
			return skill_id;
		}
		public void setSkill_id(int skill_id) {
			this.skill_id = skill_id;
		}
		public int getRating() {
			return rating;
		}
		public void setRating(int rating) {
			this.rating = rating;
		}
		public Employeeskills(int emp_id, int skill_id, int rating) {
			super();
			
			this.emp_id = emp_id;
			this.skill_id = skill_id;
			this.rating = rating;
		}
		public Employeeskills() {
			super();
		}
		
	    
	}
