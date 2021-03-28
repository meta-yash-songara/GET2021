package com.metacube.EmployeeSort;

import static org.junit.Assert.*;

import org.junit.Test;

public class EmployeeSortTest {

	@Test
	public void testEmpSort(){
		EmployeeSort employeeSort = new EmployeeSort();
		
		employeeSort.insert(new Employee("Yash", 20, 40));
		employeeSort.insert(new Employee("Neha", 23, 100));
		employeeSort.insert(new Employee("Shailesh", 19, 10));
		employeeSort.insert(new Employee("Manish", 21, 10));
		
		employeeSort.insertionSort(employeeSort.getHead());
		
		String expectedResult = "Neha,23,100," +
						"Yash,20,40," +
						"Manish,21,10," +
						"Shailesh,19,10,";
		
		assertEquals(expectedResult, employeeSort.getEmpListAsString(employeeSort.getHead()));	
	}
	
}
