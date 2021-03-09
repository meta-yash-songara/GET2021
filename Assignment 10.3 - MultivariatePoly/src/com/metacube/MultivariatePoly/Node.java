package com.metacube.MultivariatePoly;

public class Node {

	int coeff;
	Node nextTerm;
	Node exp;
	
	public Node(int coeff) {
		// TODO Auto-generated constructor stub
		this.coeff = coeff;
		nextTerm = null;
		exp = null;
		
	}
	
}
