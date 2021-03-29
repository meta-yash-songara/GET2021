package com.metacube.InfixEval;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class InfixEvalTest {

	@Test
	public void checkInfixToPostfixEvalMethod(){
		
		InfixEval infixEval = new InfixEval();
		
		assertEquals("3", infixEval.PostfixEvaluation(infixEval.infixToPostfix("1 + 2")));
		
	}
	
}
