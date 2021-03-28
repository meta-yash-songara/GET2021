package com.metacube.EmployeeSort;

public class Node {
	
	Employee employee;
	Node next;
	
	Node(){}
	
	Node(Employee emp){
		employee = emp;
		next = null;
	}

}
