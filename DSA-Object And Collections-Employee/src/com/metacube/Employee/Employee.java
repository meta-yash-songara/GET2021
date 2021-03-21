package com.metacube.Employee;

import java.util.HashSet;
import java.util.Set;

public class Employee {

	public int empId;
	public String empName;
	public String empAdd;
	
	Set<Employee> uniqueEmployees = new HashSet<Employee>();
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int empId, String empName, String empAdd) {
		this.empId = empId;
		this.empName = empName;
		this.empAdd = empAdd;
	}
	
	public boolean addEmployee(Employee emp){
		return uniqueEmployees.add(emp);
	}
	
	@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		return arg0 instanceof Employee && this.empId == ((Employee)arg0).empId;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.empId;
	}
	
}
