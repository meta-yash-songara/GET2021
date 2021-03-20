package com.metacube.MinScore;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMinScore {

	@Test
	public void testMinScore(){
		
		// 4 is no of bowler's
		MinScore minScore = new MinScore(3);
		
		//
		Bowler bowler1 = new Bowler("Bumrah", 4);
		Bowler bowler2 = new Bowler("Hardik", 2);
		Bowler bowler3 = new Bowler("Chahal", 3);
		
		Bowler[] bowlers = new Bowler[3];
		bowlers[0] = bowler1;
		bowlers[1] = bowler2;
		bowlers[2] = bowler3;
		
		minScore.insertBowlers(bowlers);
		
		String[] res = new String[] {
				"Bumrah",
				"Bumrah",
				"Chahal",
				"Chahal",
				"Hardik",
				"Bumrah",
				"Bumrah",
				"Chahal",
				"Hardik"
		};
		
		assertArrayEquals(res, minScore.getBowlerSequence(9));
	}
	
}
