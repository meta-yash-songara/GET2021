package com.metacube.EmployeeSort;

public class EmployeeSort {
	
	Node head, last, sorted;

	public void insert(Employee emp){
		Node temp = new Node(emp);
		
		if(head == null){
			head = temp;
			last = head;
			return;
		}
		
		last.next = temp;
		last = temp;
	}
	
	public Node getHead(){
		return head;
	}
	
	public String getEmpListAsString(Node node){
		String res = "";
		
		while(node != null){
			res += node.employee.getName() + ","
					+ node.employee.getAge() + ","
					+ node.employee.getSalary() + ",";
			node = node.next;
		}
		
		return res;
	}
	
	public void insertionSort(Node node){
		sorted = null;
		Node cur = node;
		
		while(cur != null){
			Node next = cur.next;
			sort(cur);
			cur = next;
		}
		
		head = sorted;
	}
	
	private void sort(Node node){
		if(sorted == null || compareEmployees(sorted.employee, node.employee)){
			node.next = sorted;
			sorted = node;
		}else{
			Node cur = sorted;
			
			while(cur.next != null && (cur.next.employee.getSalary() > node.employee.getSalary())){
				cur = cur.next;
			}
			
			node.next = cur.next;
			cur.next = node;
		}
	}
	
	private boolean compareEmployees(Employee emp1, Employee emp2){
		boolean res = (emp1.getSalary() < emp2.getSalary() || 
				(emp1.getSalary() == emp2.getSalary() && emp1.getAge() > emp2.getAge()));
		
		return res;
	}
}
