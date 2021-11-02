package com.example.serviceimpl;

import com.example.repo.ExpenseRepository;

import com.example.entity.Employee;
import com.example.entity.Employeeskills;
import com.example.entity.Expense;
import com.example.model.Response;
import com.example.repo.EmployeeRepository;
import com.example.repo.EmployeeSkillRepository;
import com.example.service.dbService;
import java.text.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class dbServiceImpl implements dbService  {
	
	
	@Autowired
	private EmployeeRepository employeeRepo;
	
	@Autowired
	private ExpenseRepository expenseRepo;
	
	@Autowired
	private EmployeeSkillRepository employeeSkillRepo;
	
	@Value("${file.firstnames.path}")
	String firstnamesPath;
	
	@Value("${file.lastnames.path}")
	String lastnamesPath;
	

//	ArrayList<String> firstnames = readFile("/home/varsha/Desktop/dbexp/firstnames.txt");
//	ArrayList<String> lastnames = readFile("/home/varsha/Desktop/dbexp/lastnames.txt");
	
	ArrayList<Integer> emp_ids = getEmp_ids();
//	ArrayList<String> names = getUserNameCombinations(firstnames, lastnames);
//	ArrayList<Date> dates = getRandomDates();
//	
	ArrayList<Integer> skill_ids = getSkill_ids();
	ArrayList<String> combinations = getUserSkillCombinations(emp_ids, skill_ids);
	
//	ArrayList<Integer> category_ids = getCategory_ids();
//	ArrayList<String> bill_nos = getBill_nos();
//	ArrayList<String> excombinations = getCombinations(emp_ids,category_ids, bill_nos);

	ArrayList<String> titles = new ArrayList<>(Arrays.asList("work from home reimbursement","certifications reimbursement","travel expense reimbursement",
			"covid vaccination reimbursement","covid medical bill reimbursement","wifi connection reimbursement","medical bill reimbursement","travel kit reimbursement",
			"passport courier reimbursement","domestic travel reimbursement","conveyance reimbursement","team lunch reimbursement","laptop repair reimbursement","covid medicines reimbursement"));
	
	Random rand = new Random();
	
	List<Expense> expenses = new ArrayList<>();
	List<Employeeskills> employeeskills = new ArrayList<>();

	@Override
	public String addUser()
	{
//		List<Employee> employees = new ArrayList<>();
//		for(int i = 0; i< 30000 ; i++)
//		{
//			Employee e = new Employee(emp_ids.get(i), names.get(i), names.get(i)+"@gmail.com", dates.get(i), (int)Math.floor(Math.random()*(30-1+1)+1), (int)Math.floor(Math.random()*(5-1+1)+1));
//			employees.add(e);
//		}
//		employeeRepo.saveAll(employees);
		String s = "Data inserted successfully";
		return s;
	}

	private ArrayList<String> readFile(String path)
	{
		ArrayList<String> names = new ArrayList<>();
		try {
			Scanner s = new Scanner(new File(path));
			while (s.hasNext())
			{
			    names.add(s.next());
			}
			s.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return names;
		
	}
	@Override
	public String addUserExpenses(int start , int end)
	{
//		for(int i=start ; i<end; i++)
//		{
//	    Expense e = new Expense(Integer.parseInt(excombinations.get(i).substring(0, 5)), titles.get(rand.nextInt(titles.size())),(int)Math.floor(Math.random()*(24-1+1)+1),
//					Integer.parseInt(excombinations.get(i).substring(13)), excombinations.get(i).substring(5,13), (int)Math.floor(Math.random()*(10000-1000+1000)+1000));
//			expenses.add(e);
//		}
//		expenseRepo.saveAll(expenses);
		   for(int i=start ; i<end; i++)
		    {
//		      Expense e = new Expense(Integer.parseInt(excombinations.get(i).substring(0, 5)), titles.get(rand.nextInt(titles.size())),(int)Math.floor(Math.random()*(24-1+1)+1),
//		          Integer.parseInt(excombinations.get(i).substring(13)), excombinations.get(i).substring(5,13), (int)Math.floor(Math.random()*(10000-1000+1000)+1000));
//		      expenses.add(e);
		    }
		    PrintWriter writer;
		    try {
		      writer = new PrintWriter("/home/test/DB_Task/test1.csv");
		        for (Expense expense : expenses) {
		                writer.println(expense.getEmp_id()+","+expense.getTitle()+","+expense.getProject_id()+","+expense.getCategory_id()+","+expense.getBill_no()+","+expense.getAmount());
		            }
		            writer.close();
		    } catch (FileNotFoundException e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		    }
		String s = "Data inserted successfully";
		return s;
	}
	
	@Override
	public String addUserExpensesjmeter(int emp_id , String title, int project_id, int category_id, String bill_no, int amount) {
		   Expense e = new Expense(emp_id, title,project_id, category_id, bill_no, amount);
		   expenseRepo.save(e);
		return "Data Inserted Successfully";
	}
	
	private ArrayList<String> getCombinations(ArrayList<Integer> emp_ids, ArrayList<Integer> category_ids, ArrayList<String> bill_nos)
	{
		ArrayList<String> combinations = new ArrayList<>();
		
		for (int i = 0; i < emp_ids.size(); i++)
		{
		  for (int j = 0; j < bill_nos.size(); j++)
		  {
		    for (int k = 0; k < category_ids.size(); k++)
		    {
		       String combination = emp_ids.get(i) +  bill_nos.get(j) + category_ids.get(k);
		       combinations.add(combination);
		       
		    }
		  }
		}
		
		return combinations;
	}
	
	private ArrayList<Date> getRandomDates()
	   {
	     ArrayList<Date> dates = new ArrayList<>();
	     for(int i = 0; i< 30000 ; i++)
	     {
	    
	     LocalDate from = LocalDate.of(2005, 1, 1);
	     LocalDate to = LocalDate.of(2020, 1, 1);
	     long days = from.until(to, ChronoUnit.DAYS);
	     long randomDays = ThreadLocalRandom.current().nextLong(days + 1);
	     LocalDate randomDate = from.plusDays(randomDays);
	     String d = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH).format(randomDate);
	     SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
	     try {
	      Date date = formatter.parse(d);
	      dates.add(date);
	    } catch (ParseException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	    
	     }
	    
	     return dates;
	     
	   }
	
	private ArrayList<String> getUserSkillCombinations(ArrayList<Integer> emp_ids, ArrayList<Integer> skill_ids)
	{
		ArrayList<String> combinations = new ArrayList<>();
		
		for (int i = 0; i < emp_ids.size(); i++)
		{
		  for (int j = 0; j < skill_ids.size(); j++)
		  {
		       String combination = Integer.toString(emp_ids.get(i)) + Integer.toString(skill_ids.get(j));
		       combinations.add(combination);
		  }
		}
		
		return combinations;
	}
	
	private ArrayList<String> getUserNameCombinations(ArrayList<String> firstnames, ArrayList<String> lastnames)
	{
		ArrayList<String> combinations = new ArrayList<>();
		
		for (int i = 0; i < firstnames.size(); i++)
		{
		  for (int j = 0; j < lastnames.size(); j++)
		  {
		       String combination = firstnames.get(i) + "." + lastnames.get(j);
		       combinations.add(combination);
		  }
		}
		
		return combinations;
	}
	
	
	private ArrayList<Integer> getEmp_ids()
	{
		ArrayList<Integer> emp_ids = new ArrayList<>();
		for(int i =50000; i< 80000; i++)
		{
			{
				emp_ids.add(i);
				
			}
			
		}
		return emp_ids;
	}
	
	
	private ArrayList<Integer> getCategory_ids()
	{
		ArrayList<Integer> category_ids = new ArrayList<>();
		for(int i =10; i< 21; i++)
		{
			category_ids.add(i);
		}
		return category_ids;
	}
	
	private ArrayList<String> getBill_nos()
    {
  
		ArrayList<String> bill_nos = new ArrayList<>();
        // chose a Character random from this String
		for(int i=0; i< 100; i++)
		{
			String uuid = UUID.randomUUID().toString();
			if(uuid.length() > 8)
			{
				uuid = uuid.substring(0, 8);
			}
			else if(uuid.length() < 8)
			{
				("00000000" + uuid).substring(uuid.length());
			}
			bill_nos.add(uuid);
		}
		return bill_nos;
		
     }
  
	private ArrayList<Integer> getSkill_ids()
	{
		ArrayList<Integer> skill_ids = new ArrayList<>();
		for(int i = 1; i< 1250; i++)
		{
			skill_ids.add(i);
		}
		return skill_ids;
	}
  
	


	@Override
	public String addUserSkills(int start , int end) {
		
//		System.out.println("hiii");
//		System.out.println(start);
//		System.out.println(end);
		
	for(int i=start ; i<end; i++)
	{
//			Employeeskills e = new Employeeskills(50000, 2, (int)Math.floor(Math.random()*(5-1+1)+1));

			Employeeskills e = new Employeeskills(Integer.parseInt(combinations.get(i).substring(0,5)), Integer.parseInt(combinations.get(i).substring(5)), (int)Math.floor(Math.random()*(5-1+1)+1));
			employeeskills.add(e);
//			employeeSkillRepo.save(e);
	}
		employeeSkillRepo.saveAll(employeeskills);
		String s = "Data inserted successfully";
		return s;
		
	}

}