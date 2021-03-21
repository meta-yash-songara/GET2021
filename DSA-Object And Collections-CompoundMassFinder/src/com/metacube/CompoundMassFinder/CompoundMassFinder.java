package com.metacube.CompoundMassFinder;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class CompoundMassFinder {
	
	Map<Character, Integer> compoundMass = new HashMap<Character, Integer>();
	
	public CompoundMassFinder() {
		// TODO Auto-generated constructor stub
		compoundMass.put('C', 12);
		compoundMass.put('H', 1);
		compoundMass.put('O', 16);
		compoundMass.put('(', 0);
	}
	
	public int getCompoundMass(String compound){
		int result = 0;
		int sum = 0;
		
		compound = compound.toUpperCase();
		
		Stack<Integer> stack = new Stack<Integer>();
		for(int i = 0; i < compound.length(); i++){
			if(compound.charAt(i) == ')'){
				while(stack.peek() != 0)
					sum += stack.pop();
				
				stack.push(sum);
			}else if(Character.isDigit(compound.charAt(i))){
				int temp = 0;
				String base = "";
				
				while((i + temp) < compound.length() &&
						Character.isDigit(compound.charAt(i + temp))){
					base = base.concat(compound.charAt(i + temp) + "");
					temp++;
				}
				
				int baseInt = Integer.parseInt(base);
				i = i + (--temp);
				stack.push((stack.pop()) * baseInt);
			}else {
				stack.push(compoundMass.get(compound.charAt(i)));
			}
		}
		
		while(!stack.isEmpty()){
			result += stack.pop();
		}
		
		return result;
	}

}
