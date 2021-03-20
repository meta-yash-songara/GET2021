package com.metacube.Cmd;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Node {

	String folder_name;
	Node root;
	List<Node> child = new ArrayList<Node>();
	
	Timestamp ts;
	
	public Node(String folder_name) {
		// TODO Auto-generated constructor stub
		this.folder_name = folder_name;
	}
	
}
