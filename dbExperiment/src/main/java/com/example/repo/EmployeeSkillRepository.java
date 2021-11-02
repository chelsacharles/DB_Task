package com.example.repo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Employeeskills;
import com.example.model.Response;


@Repository
public interface EmployeeSkillRepository extends JpaRepository<Employeeskills, Integer> {
	
	
	@Transactional
	@Modifying(clearAutomatically = true)
//	@Query(value="select emp_id, rating from emp_skills where id in (select id from skills where skill = ?1 or skill =?2) and rating>?3 and emp_id in (SELECT id from employee where DATE_PART('year', CURRENT_DATE) - DATE_PART('year', date(career_start_date))>?4);", nativeQuery = true)
	@Query(value="select emp_id, rating from emp_skills where id in (select id from skills where skill = '.net') and rating>1 and emp_id in (SELECT id from employee where DATE_PART('year', CURRENT_DATE) - DATE_PART('year', date(career_start_date))>2);", nativeQuery = true)
//   public List<Response> getSkilledpeople(String skill, String skill2, int rating, int experience);
	
	 public List<Response> getSkilledpeople(List<String> skill, int rating, int experience);
	
	
	
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value="SELECT skill,count FROM skills JOIN (SELECT skill_id, COUNT(*) FROM emp_skills GROUP BY skill_id)  AS skill_count ON skills.id = skill_count.skill_id;", nativeQuery = true)
    public List<Response> getSkillCount();
	 
}




 


