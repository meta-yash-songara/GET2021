package com.metacube.Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeSortById implements Comparable<EmployeeSortById>{
	
	public int empId;
	public String empName;
	public String empAdd;
	
	List<EmployeeSortById> employeeList = new ArrayList<EmployeeSortById>();
	
	public EmployeeSortById() {
		// TODO Auto-generated constructor stub
	}

	public EmployeeSortById(int empId, String empName, String empAdd) {
		this.empId = empId;
		this.empName = empName;
		this.empAdd = empAdd;
	}
	
	public void addEmployee(EmployeeSortById emp){
		employeeList.add(emp);
	}

	@Override
	public int compareTo(EmployeeSortById arg0) {
		// TODO Auto-generated method stub
		return this.empId - arg0.empId;
	}
	
	public List<EmployeeSortById> sortEmployeesById(){
		Collections.sort(employeeList);
		return employeeList;
	}

}
