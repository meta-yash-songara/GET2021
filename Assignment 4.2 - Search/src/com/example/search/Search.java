package com.example.search;

public class Search {
	public int start = 0;
	public int end = 0;
	
	public int linearSearch(int[] arr, int ele){
		
		if(end < start)
			return -1;
		
		if(arr[start] == ele)
			return start;
		else
			++start;
		
		return linearSearch(arr, ele);
		
	}
	
	public int binarySearch(int[] arr, int ele){
		
		if(end >= start){
			int mid = start + (end - start) / 2;
			
			if(arr[mid] == ele){
				return mid;
			}

			if(arr[mid] > ele){
				end = mid - 1;
			}else{
				start = mid + 1;
			}
			
			return binarySearch(arr, ele);
			
		}
		
		return -1;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}