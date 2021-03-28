package com.metacube.dictionary;

public class TreeNode {
	
	String key;
	String data;
	TreeNode left;
	TreeNode right;
	TreeNode parent;
	
	public TreeNode(String key, String data) {
		// TODO Auto-generated constructor stub
		this.key = key;
		this.data = data;
		left = right = null;
	}

}
