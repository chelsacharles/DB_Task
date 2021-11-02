package com.example.repo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Expense;
import com.example.model.Response;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Integer> {
	
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value="select  name, email from employee where id in (select emp_id from expense where category_id = (select id from category where category = ?1) ) and unit_id in (select id from unit where unit = ?2);", nativeQuery = true)
    public List<Response> getUnitExpense(String category, String unit);
	
	
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value="select  name, email from employee where id in (select emp_id from expense where category_id = (select id from category where category = ?1) and project_id in (select id from project where project = ?2) );", nativeQuery = true)
    public List<Response> getProjectExpense(String category, String project);
	 
}




 


