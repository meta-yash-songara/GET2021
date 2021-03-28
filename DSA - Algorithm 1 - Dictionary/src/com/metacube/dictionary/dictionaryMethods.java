package com.metacube.dictionary;

import java.util.List;

public interface dictionaryMethods {
	
	public boolean addData(String key, String data) throws Exception;
	public boolean deleteData(String key) throws Exception;
	public String getDataAt(String key);
	public List<Data> getAllData();
	public List<Data> getFromAndTo(String fromKey, String toKey);

}
