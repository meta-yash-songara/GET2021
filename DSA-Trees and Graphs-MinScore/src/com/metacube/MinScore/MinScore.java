package com.metacube.MinScore;

public class MinScore {

	static int index = 0;
	
	private Bowler[] heap;
	private int size;
	
	public MinScore(int maxSize) {
		// TODO Auto-generated constructor stub
		this.size = -1;
		heap = new Bowler[maxSize];
	}
	
	private int getParent(int i){
		return i / 2;
	}
	
	private int getLeftC(int i){
		return (2 * i) + 1;
	}
	
	private int getRightC(int i){
		return (2 * i) + 2;
	}
	
	private void swap(int pos1, int pos2){
		Bowler temp;
		temp = heap[pos1];
		heap[pos1] = heap[pos2];
		heap[pos2] = temp;
	}
	
	private boolean isLeafNode(int i){
		if(i >= (size / 2) && i <= size)
			return true;
					
		return false;
	}
	
	public String[] getBowlerSequence(int ballsCount){
		String[] res = new String[ballsCount];
		
		while(size != -1){
			res[index] = heap[0].getName();
			index++;
			
			if(heap[0].getBallsCount() >= 1){
				int ballCount = heap[0].getBallsCount();
				heap[0].setBallsCount(ballCount - 1);
				
				if((ballCount - 1) == 0){
					heap[0] = heap[size];
					size = size - 1;
				}
			}
			
			placeMaxHeapElement(0);
		}
		
		return res;
	}
	
	private void placeMaxHeapElement(int i){
		if(isLeafNode(i))
			return;
		
		if(heap[i].getBallsCount() < heap[getLeftC(i)].getBallsCount() ||
				heap[i].getBallsCount() < heap[getRightC(i)].getBallsCount()){
			
			if(heap[getLeftC(i)].getBallsCount() > heap[getRightC(i)].getBallsCount()){
				swap(i, getLeftC(i));
				placeMaxHeapElement(getLeftC(i));
			}else{
				swap(i, getRightC(i));
				placeMaxHeapElement(getRightC(i));
			}
			
		}
	}
	
	public void insertBowlers(Bowler[] arr){
		for(int i = 0; i < arr.length; i++){
			heap[++size] = arr[i];
			int cur = size;
			
			while(heap[cur].getBallsCount() > heap[getParent(cur)].getBallsCount()){
				swap(cur, getParent(cur));
				cur = getParent(cur);
			}
		}
	}
	
}





















