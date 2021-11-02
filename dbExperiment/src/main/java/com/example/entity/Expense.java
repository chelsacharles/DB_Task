package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

	
	@Entity
	@Table(name = "expense")
	public class Expense {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	    private int emp_id;
	    private String title;
	    private int project_id;
	    private int category_id;
	    private String bill_no;
	    private int amount;
	    
		public Expense( int emp_id, String title, int project_id, int category_id, String bill_no, int amount) {
			super();
			
			this.emp_id = emp_id;
			this.title = title;
			this.project_id = project_id;
			this.category_id = category_id;
			this.bill_no = bill_no;
			this.amount = amount;
		}
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
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public int getProject_id() {
			return project_id;
		}
		public void setProject_id(int project_id) {
			this.project_id = project_id;
		}
		public int getCategory_id() {
			return category_id;
		}
		public void setCategory_id(int category_id) {
			this.category_id = category_id;
		}
		public String getBill_no() {
			return bill_no;
		}
		public void setBill_no(String bill_no) {
			this.bill_no = bill_no;
		}
		public int getAmount() {
			return amount;
		}
		public void setAmount(int amount) {
			this.amount = amount;
		}
		public Expense() {
			super();
		}
	    
		
	}
