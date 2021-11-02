package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Employee;



@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
//	@Transactional
//	@Modifying(clearAutomatically = true)
//	@Query(value="INSERT INTO employee (id, name, career_start_date, email, designation_id, unit_id) values (?1, ?2, ?3, ?4, ?5, ?6)", nativeQuery = true)
//    public void saveEmployee(int id, String name, String career_start_date, String email, int designation_id, int unit_id);
//	 
}




 


