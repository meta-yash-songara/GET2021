package com.metacube.Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeSortByName{
	
	public int empId;
	public String empName;
	public String empAdd;
	
	List<EmployeeSortByName> employeeList = new ArrayList<EmployeeSortByName>();
	
	public EmployeeSortByName() {
		// TODO Auto-generated constructor stub
	}

	public EmployeeSortByName(int empId, String empName, String empAdd) {
		this.empId = empId;
		this.empName = empName;
		this.empAdd = empAdd;
	}
	
	public void addEmployee(EmployeeSortByName emp){
		employeeList.add(emp);
	}
	
	public List<EmployeeSortByName> sortEmployeesByName(){
		Collections.sort(employeeList, new Comparator<EmployeeSortByName>() {
			@Override
			public int compare(EmployeeSortByName arg0, EmployeeSortByName arg1) {
				// TODO Auto-generated method stub
				return (arg0.empName).compareTo(arg1.empName);
			}
		});
		
		return employeeList;
	}

}
