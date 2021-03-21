package com.metacube.Employee;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class EmployeesTest {
	
	@Test
	public void testEmployeesClass(){
		Employee employees = new Employee();
		
		Employee employee1 = new Employee(1, "Yash", "Sanchore");
		Employee employee2 = new Employee(3, "Neha", "Abu Road");
		Employee employee3 = new Employee(2, "Vijay", "Raniwara");
		
		employees.addEmployee(employee1);
		employees.addEmployee(employee2);
		employees.addEmployee(employee3);
		
		// Output will be false because employee1 has an unique 
		// hashcode which is already existing in employee class
		assertEquals(false, employees.addEmployee(employee1));
	}
	
	@Test
	public void testEmployeeSortByIdClass(){
		EmployeeSortById employees = new EmployeeSortById();
		
		EmployeeSortById employee1 = new EmployeeSortById(1, "Yash", "Sanchore");
		EmployeeSortById employee2 = new EmployeeSortById(3, "Neha", "Abu Road");
		EmployeeSortById employee3 = new EmployeeSortById(2, "Vijay", "Raniwara");
		
		employees.addEmployee(employee1);
		employees.addEmployee(employee2);
		employees.addEmployee(employee3);
		
		//Correct Order Expected
		List<EmployeeSortById> resultList = new ArrayList<EmployeeSortById>();
		resultList.add(employee1);
		resultList.add(employee3);
		resultList.add(employee2);
		
		assertEquals(resultList, employees.sortEmployeesById());
	}
	
	@Test
	public void testEmployeeSortByNameClass(){
		EmployeeSortByName employees = new EmployeeSortByName();
		
		EmployeeSortByName employee1 = new EmployeeSortByName(1, "Yash", "Sanchore");
		EmployeeSortByName employee2 = new EmployeeSortByName(3, "Neha", "Abu Road");
		EmployeeSortByName employee3 = new EmployeeSortByName(2, "Vijay", "Raniwara");
		
		employees.addEmployee(employee1);
		employees.addEmployee(employee2);
		employees.addEmployee(employee3);
		
		// Correct Order Expected
		List<EmployeeSortByName> resultList = new ArrayList<EmployeeSortByName>();
		resultList.add(employee2);
		resultList.add(employee3);
		resultList.add(employee1);
		
		assertEquals(resultList, employees.sortEmployeesByName());
	}

}
