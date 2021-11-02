package com.example.daoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.dao.EmployeeSkillsDao;
import com.example.model.Response;


@Repository
public class EmployeeSkillsDaoimpl implements EmployeeSkillsDao{

	@Autowired
	private JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	
	@SuppressWarnings("deprecation")
	@Override
	public List<Response> getSkilledPeople(List<String> skills, int rating, int experience) {
		
		BeanPropertyRowMapper<Response> rowMapResponse = new BeanPropertyRowMapper<>(
				Response.class);
		List<Response> skillPeople = null;
		try {
			skillPeople = template.query("select emp_id, rating from emp_skills where skill_id in (select id from skills where skill = '.net') and rating>1 and emp_id in (SELECT id from employee where DATE_PART('year', CURRENT_DATE) - DATE_PART('year', date(career_start_date))>2)", new Object[]{},
					rowMapResponse);
			System.out.println(skillPeople.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return skillPeople;
	}


	@Override
	public List<Response> getSkillCount() {
		BeanPropertyRowMapper<Response> rowMapResponse = new BeanPropertyRowMapper<>(
				Response.class);
//		return template.query(
//				"select emp_id, rating from emp_skills where id in (select id from skills where skill = '.net') and rating>1 and emp_id in (SELECT id from employee where DATE_PART('year', CURRENT_DATE) - DATE_PART('year', date(career_start_date))>2);",
//				new Object[] {},rowMapResponse);
		
		List<Response> skillPeople = null;
		try {
			skillPeople = template.query("SELECT skill,count FROM skills JOIN (SELECT skill_id, COUNT(*) FROM emp_skills GROUP BY skill_id)  AS skill_count ON skills.id = skill_count.skill_id", new Object[]{},
					rowMapResponse);
			System.out.println(skillPeople.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return skillPeople;
	}


	@Override
	public List<Response> getProjectExpense(String category, String project) {
		BeanPropertyRowMapper<Response> rowMapResponse = new BeanPropertyRowMapper<>(
				Response.class);
//		return template.query(
//				"select emp_id, rating from emp_skills where id in (select id from skills where skill = '.net') and rating>1 and emp_id in (SELECT id from employee where DATE_PART('year', CURRENT_DATE) - DATE_PART('year', date(career_start_date))>2);",
//				new Object[] {},rowMapResponse);
		
		List<Response> skillPeople = null;
		try {
			skillPeople = template.query("select name, email from employee where id in (select emp_id from expense where category_id = (select id from category where category = 'Covid vaccination') and project_id in (select id from project where project = 'Decathlon'))", new Object[]{},
					rowMapResponse);
			System.out.println(skillPeople.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return skillPeople;
	}


	@Override
	public List<Response> getUnitExpense(String category, String unit) {
		BeanPropertyRowMapper<Response> rowMapResponse = new BeanPropertyRowMapper<>(
				Response.class);
//		return template.query(
//				"select emp_id, rating from emp_skills where id in (select id from skills where skill = '.net') and rating>1 and emp_id in (SELECT id from employee where DATE_PART('year', CURRENT_DATE) - DATE_PART('year', date(career_start_date))>2);",
//				new Object[] {},rowMapResponse);
		
		List<Response> skillPeople = null;
		try {
			skillPeople = template.query("select  name, email from employee where id in (select emp_id from expense where category_id = (select id from category where category = 'Covid vaccination' ) ) and unit_id in (select id from unit where unit = 'Enterprise Consulting')", new Object[]{},
					rowMapResponse);
			System.out.println(skillPeople.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return skillPeople;
	}

}
