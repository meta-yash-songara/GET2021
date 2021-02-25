package com.example.JobScheduler;

import java.util.Scanner;

public class JobScheduler {
	
	// Function to calculate waiting time
	public static void calcWaitingTime(int[][] processData, int numOfProcess,
										int[] waitingTime)
	{
		waitingTime[0] = 0;
		
		for(int i = 1; i < numOfProcess; i++){
			if(processData[i][0] < processData[i -1][1]){
				waitingTime[i] = processData[i - 1][1] - processData[i][0];
			}else{
				waitingTime[i] = 0;
			}
		}
	}
	
	// Function to calculate Turn around time
	public static void calcTurnAroundTime(int[][] processData, int numOfProcess,
										int[] waitingTime, int[] turnAroundTime){
		
		for(int i = 0; i < numOfProcess; i++){
			turnAroundTime[i] = processData[i][1] + waitingTime[i];
		}
		
	}
	
	// Function to calculate Completion Time
	public static void calcCompletionTime(int[][] processData, int numOfProcess,
										int[] completionTime){
		
		completionTime[0] = processData[0][1];
		
		for(int i = 1; i < numOfProcess; i++){
			if(processData[i][0] < processData[i - 1][1]){
				completionTime[i] += processData[i][1];
			}else{
				completionTime[i] += processData[i][0] + processData[i][1];
			}
		}
		
	}
	
	// Function to get Average Waiting Time
	public static float calcAvgWaitingTime(int[] waitingTime){
		int result = 0;
		
		for(int i: waitingTime)
			result += i;
		
		return result/waitingTime.length;
	}
	
	// Function to get Max Waiting Time
	public static int getMaxWaitingTime(int[] waitingTime){
		int max = waitingTime[0];
		
		for(int i: waitingTime)
			if(i > max)
				max = i;
		
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		int totalProcessCount = 0;
		
		System.out.print("Enter total number of processes : ");
		totalProcessCount = scn.nextInt();
		
		int[][] processAtAndBt = new int[totalProcessCount][2];
		int[] waitingTime = new int[totalProcessCount];
		int[] turnAroundTime = new int[totalProcessCount];
		int[] completionTime = new int[totalProcessCount];
		
		System.out.println("  " + " At " + "Bt");
		
		for(int i = 0; i < totalProcessCount; i++){
			System.out.print((i + 1) + ") ");
			processAtAndBt[i][0] = scn.nextInt();
			processAtAndBt[i][1] = scn.nextInt();
		}
		
		calcWaitingTime(processAtAndBt, totalProcessCount, waitingTime);
		
		calcTurnAroundTime(processAtAndBt, totalProcessCount, waitingTime, turnAroundTime);
		
		calcCompletionTime(processAtAndBt, totalProcessCount, completionTime);
		
		System.out.println("+-------+-------+-------+-------+");
		System.out.println("| Id\t| Wt\t| Tat\t| Ct\t|");
		System.out.println("+-------+-------+-------+-------+");
		
		for(int i = 0; i < totalProcessCount; i ++)
			System.out.println("| " +(i + 1) + "\t| " +
								waitingTime[i] + "\t| " +
								turnAroundTime[i] + "\t| " +
								completionTime[i] + "\t|");
		
		System.out.println("+-------+-------+-------+-------+");
		
		System.out.println("Average Waiting Time : " + calcAvgWaitingTime(waitingTime));
		
		System.out.println("Max Waiting Time : " + getMaxWaitingTime(waitingTime));
		
		System.out.println("-------------------------------");
		
		System.out.println("Thank you for using Job Scheduler :)");
	}

}
