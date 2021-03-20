package com.metacube.MinScore;

public class Bowler {
	
	private String name;
	private int ballsCount;
	
	public Bowler(String name, int ballsCount) {
		this.name = name;
		this.ballsCount = ballsCount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBallsCount() {
		return ballsCount;
	}

	public void setBallsCount(int ballsCount) {
		this.ballsCount = ballsCount;
	}
	
	

}
