package com.metacube.InfixEval;

public class InfixEval {
	
	Stack infixToPostfixConversionStack = new Stack();
	Stack postfixEvaluationStack = new Stack();
	
	public String infixToPostfix(String infix){
			
		StringBuffer result = new StringBuffer(" ");
		String[] infixArr = infix.split(" ");	
		
		for(int i = 0; i < infixArr.length; i++){
			
			String temp1 = infixArr[i];
			int j = 0;
			
			if(j < temp1.length() && temp1.charAt(j) >= '0' && temp1.charAt(j) <= '9'){
				StringBuffer buffer = new StringBuffer("");
				
				while(j < temp1.length() && temp1.charAt(j) >= '0' && temp1.charAt(j) <= '9'){
					
					buffer.append(temp1.charAt(j));
					j++;
					
				}
				
				result.append(buffer);
				result.append(" ");
			}else if("(".equals(temp1))
				infixToPostfixConversionStack.push(temp1);
			else if (")".equals(temp1)){
				
				while(!infixToPostfixConversionStack.isEmpty() && !"(".equals(infixToPostfixConversionStack.peek())){
					result.append(infixToPostfixConversionStack.pop());
					result.append(" ");
				}
				
				if("(".equals(infixToPostfixConversionStack.peek()))
					infixToPostfixConversionStack.pop();
				
			} else {
				
				while(!infixToPostfixConversionStack.isEmpty() && Precedence(temp1) >= Precedence(infixToPostfixConversionStack.peek())){
					result.append(infixToPostfixConversionStack.pop());
					result.append(" ");
				}
				
				infixToPostfixConversionStack.push(temp1);
				
				while(infixToPostfixConversionStack.isEmpty() || Precedence(temp1) < Precedence(infixToPostfixConversionStack.peek()))
					infixToPostfixConversionStack.push(temp1);
				
			}
			
		}
		
		while(!infixToPostfixConversionStack.isEmpty()){
			result.append(infixToPostfixConversionStack.pop());
			result.append(" ");
		}
		
		System.out.println(result.toString());
		
		return result.toString();
	}
	
	private int Precedence(String op){
		switch(op){
		case "/":
		case "*": return 1;
		
		case "+":
		case "-": return 2;
		
		case "<":
		case ">":
		case ">=":
		case "<=": return 3;
		
		case "==":
		case "!=": return 4;
		
		case "&&": return 5;
		
		case "||": return 6;
		
		case "(": return 7;
		
		default: return -1;
		}
	}
	
	public String PostfixEvaluation(String postfixExp){
		String[] postfixArr = postfixExp.split(" ");
	
		for(int i = 1; i < postfixArr.length; i++){
			String temp = postfixArr[i];
			int j = 0;
			
			if(temp.charAt(j) >= '0' && temp.charAt(j) <= '9'){
				StringBuffer buffer = new StringBuffer("");
				
				while(j < temp.length() && temp.charAt(j) >= '0' && temp.charAt(j) <= '9'){
					buffer.append(temp.charAt(j));
					j++;
				}
				
				postfixEvaluationStack.push(buffer.toString());
			}else{
				String res = evaluateOp(temp, postfixEvaluationStack.pop(), postfixEvaluationStack.pop());
				
				if(res != null)
					postfixEvaluationStack.push(res);
			}
		}
		
		return postfixEvaluationStack.pop();
	}
	
	public String evaluateOp(String operator, String fn, String sn){
		
		int firstOperand = Integer.parseInt(fn);
		int secondOperand = Integer.parseInt(sn);
		
		Integer intRes = null;
		Boolean boolRes = null;
		
		switch(operator){
		
		case "+": intRes = firstOperand + secondOperand;
					break;
					
		case "-": intRes = firstOperand - secondOperand;
					break;
		
		case "/": try{
			intRes = firstOperand / secondOperand;
					}catch(ArithmeticException e){
						System.out.println("Arithmetic Exception Caught !!!");
					}
					break;
					
		case "*": intRes = firstOperand * secondOperand;
					break;
					
		case "<": boolRes = firstOperand > secondOperand;
					break;
					
		case ">": boolRes = firstOperand < secondOperand;
					break;
					
		case "<=": boolRes = secondOperand <= firstOperand;
					break;
				
		case ">=": boolRes = secondOperand >= firstOperand;
					break;
					
		case "==": boolRes = secondOperand == firstOperand;
					break;
					
		case "!=": boolRes = secondOperand != firstOperand;
					break;
		
		case "&&": boolRes = Boolean.parseBoolean(sn) && Boolean.parseBoolean(fn);
					break;
					
		case "||": boolRes = Boolean.parseBoolean(sn) || Boolean.parseBoolean(fn);
					break;
					
		default: System.out.println("Operator not available !!!!");
		
		}
		
		if(intRes != null)
			return Integer.toString(intRes);
		
		if(boolRes != null)
			return Boolean.toString(boolRes);
		
		return null;
	}

}
