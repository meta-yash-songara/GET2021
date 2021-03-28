package com.metacube.dictionary;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;

public class Dictionary implements dictionaryMethods{
	
	TreeNode root;
	
	public Dictionary() {
		// TODO Auto-generated constructor stub
	}
	
	public Dictionary(JSONObject dataObj) throws Exception{
		root = null;
		input(dataObj);
	}
	
	private boolean input(JSONObject jsonObject) throws Exception{
		for(Object object: jsonObject.keySet()){
			String key = (String) object;
			String data = (String) jsonObject.get(key);
			addData(key, data);
		}
		return true;
	}
	
	private boolean addAtCorrectPos(String key, String data, TreeNode node){
		if((key.compareTo(node.key)) <= -1){
			if(node.left != null){
				addAtCorrectPos(key, data, node.left);
			}else{
				node.left = new TreeNode(key, data);
				node.left.parent = node;
			}
		}else if(key.compareTo(node.key) >= 1){
			if(node.right != null){
				addAtCorrectPos(key, data, node.right);
			}else{
				node.right = new TreeNode(key, data);
				node.right.parent = node;
			}
		}else{
			node = new TreeNode(key, data);
		}
		return true;
	}
	
	private boolean deleteKey(String key, TreeNode node){
		if(key.compareTo(node.key) <= -1){
			if(node.left != null)
				deleteKey(key, node.left);
		}else if(key.compareTo(node.key) >= 1){
			if(node.right != null)
				deleteKey(key, node.right);
		}else if(key.compareTo(node.key) == 0){
			if(node.left == null && node.right == null){
				if(node.parent.left == node){
					node.parent.left = null;
				}else{
					node.parent.right = null;
				}
			}else if(node.left == null && node.right != null && node.parent != null){
				if(node.parent.left == node)
					node.parent.left = node.right;
				else
					node.parent.right = node.right;
			}else if(node.right == null && node.left != null && node.parent != null){
				if(node.parent.right == node)
					node.parent.right = node.left;
				else
					node.parent.left = node.left;
			}else{
				TreeNode temp = getMin(node.right);
				node.key = temp.key;
				node.data = temp.data;
				deleteKey(temp.key, temp);
			}
		}
		return true;
	}
	
	private TreeNode getMin(TreeNode node){
		while(node.left != null){
			node = node.left;
		}
		return node;
	}
	
	private List<Data> inorderData(TreeNode node, List<Data> dataList){
		if(node != null){
			inorderData(node.left, dataList);
			dataList.add(new Data(node.key, node.data));
			inorderData(node.right, dataList);
		}
		return dataList;
	}
	
	private String getData(String key, TreeNode node){
		if(node == null)
			return null;
		else if(key.compareTo(node.key) == 0)
			return node.data;
		else if(key.compareTo(node.key) <= -1)
			return getData(key, node.left);
		else if(key.compareTo(node.key) >= 1)
			return getData(key, node.right);
		else 
			return null;
	}
	
	public String getDataAsString(List<Data> list){
		String res = "";
		
		for(Data data: list){
			res += data.key + " : " + data.data + ",";
		}
			
		return res;
	}

	@Override
	public boolean addData(String key, String data) throws Exception {
		// TODO Auto-generated method stub
		if(key.length() == 0 || data.length() == 0 || key == null || data == null){
			throw new NullPointerException("Wrong key and data.");
		}
		
		if(root == null){
			root = new TreeNode(key, data);
		}else{
			TreeNode temp = root;
			addAtCorrectPos(key, data, temp);
		}
		
		return false;
	}

	@Override
	public boolean deleteData(String key) throws Exception {
		// TODO Auto-generated method stub
		if(key.length() == 0 || key.equals(null)){
			throw new NullPointerException("Wrong key and data.");
		}
		
		if(root == null){
			System.out.println("Empty Dictionary !!!");
		}else{
			deleteKey(key, root);
		}
		return false;
	}

	@Override
	public String getDataAt(String key) {
		// TODO Auto-generated method stub
		if(root != null){
			return getData(key, root);
		}
		return null;
	}

	@Override
	public List<Data> getAllData() {
		// TODO Auto-generated method stub
		List<Data> result = new ArrayList<Data>();
		if(root != null){
			TreeNode temp = root;
			result = inorderData(temp, result);
		}
		return result;
	}

	@Override
	public List<Data> getFromAndTo(String fromKey, String toKey) {
		// TODO Auto-generated method stub
		List<Data> dataList = getAllData();
		List<Data> result = new ArrayList<Data>();
		
		for(Data data: dataList)
			if(data.key.compareTo(fromKey) >= 1 && data.key.compareTo(toKey) <= -1)
				result.add(data);
		
		return result;
	}

}














