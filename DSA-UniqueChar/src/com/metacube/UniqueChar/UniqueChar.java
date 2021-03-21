package com.metacube.UniqueChar; 

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class UniqueChar {
	
	// For Caching old results
	HashMap<String, Integer> stringsAlreadyChecked = new HashMap<String, Integer>();
	
	// For counting unique character's
	Set<Character> uniqueCharSet;
	
	public int getUniqueCharCount(String str){
		
		if(stringsAlreadyChecked.containsKey(str))
			return stringsAlreadyChecked.get(str);
		else{
			uniqueCharSet = new HashSet<Character>();
			
			for(int i = 0; i < str.length(); i++){
				if(str.charAt(i) == ' ')
					continue;
				
				uniqueCharSet.add(str.charAt(i));
			}
			
			stringsAlreadyChecked.put(str, uniqueCharSet.size());
		}
		
		
		return uniqueCharSet.size();
	}

}
