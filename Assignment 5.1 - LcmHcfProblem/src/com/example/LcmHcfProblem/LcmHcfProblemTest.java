package com.example.LcmHcfProblem;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class LcmHcfProblemTest {

	@Test
	public void findLcm(){
		LcmHcfProblem lcmHcfProblem = new LcmHcfProblem();
		int result = lcmHcfProblem.findLcm(25, 67);
		assertEquals(1675, result);
	}
	
	@Test
	public void findHcf(){
		LcmHcfProblem lcmHcfProblem = new LcmHcfProblem();
		int result = lcmHcfProblem.findGcm(30, 90);
		assertEquals(30, result);
	}
	
}
