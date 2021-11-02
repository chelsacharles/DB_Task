package com.example.entity;
import java.util.Date;

import javax.persistence.*;
 
@Entity
@Table(name = "employee")
public class Employee {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private Date career_start_date;
    private Integer designation_id;
    private Integer unit_id;
    
    
  
  public Employee(Integer id, String name, String email, Date career_start_date, Integer designation_id,
      Integer unit_id) {
    super();
    this.id = id;
    this.name = name;
    this.email = email;
    this.career_start_date = career_start_date;
    this.designation_id = designation_id;
    this.unit_id = unit_id;
  }
  
  
  public Employee() {
    super();
  }


  public Integer getEmp_id() {
    return id;
  }
  public void setEmp_id(Integer id) {
    this.id = id;
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
  public Date getCareer_start_date() {
    return career_start_date;
  }
  public void setCareer_start_date(Date career_start_date) {
    this.career_start_date = career_start_date;
  }
  public Integer getDesignation_id() {
    return designation_id;
  }
  public void setDesignation_id(Integer designation_id) {
    this.designation_id = designation_id;
  }
  public Integer getUnit_id() {
    return unit_id;
  }
  public void setUnit_id(Integer unit_id) {
    this.unit_id = unit_id;
  }
    

  
 
}