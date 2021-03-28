package com.metacube.dictionary;

public class Data {

	public String key;
	public String data;
	
	public Data(String key, String data) {
		this.key = key;
		this.data = data;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return key + " : " + data + ",";
	}
	
	
	
}
