package com.example.ArrOperation;

public class ArrOperation {

	public int maxMirror(int[] arr) {
		try {
			if (arr.length == 0) {
				throw new Exception("Empty Array.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		int result = 0;
		for (int i = 0; i <= arr.length - 2; i++) {
			int j = arr.length - 1;
			int k = i;
			int tempMaxMirror = 0;
			for (; ((j - k) > 1); j--) {
				if (arr[k] == arr[j]) {
					k++;
					tempMaxMirror++;
				}
			}
			if ((k - j) <= 1 && arr[k] == arr[j]) {
				tempMaxMirror++;
				if (k == j) {
					tempMaxMirror = 2 * tempMaxMirror - 1;
				} else {
					tempMaxMirror = 2 * tempMaxMirror;
				}
			}
			if (tempMaxMirror > result) {
				result = tempMaxMirror;
			}
		}
		return result;
	}

	public int countClumps(int[] arr) {
		try {
			if (arr.length == 0) {
				throw new Exception("Empty Array.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		int result = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			if (i > 0) {
				if (arr[i] == arr[i + 1] && arr[i - 1] != arr[i]) {
					i = i + 1;
					result++;
				}
			} else {
				if (arr[i] == arr[i + 1]) {
					i = i + 1;
					result++;
				}
			}
		}
		return result;
	}

	public int[] fixXY(int[] arr, int X, int Y) {
		boolean flag = true;
		int totalX = 0;
		int totalY = 0;
		try {
			if (arr.length == 0) {
				flag = false;
			}
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == X) {
					totalX++;
					if (i < arr.length - 1) {
						if (arr[i] == arr[i + 1]) {
							flag = false;
						}
					}
				} else if (arr[i] == Y) {
					totalY++;
				}
			}
			if (totalX != totalY) {
				flag = false;
			}
			if (arr[arr.length - 1] == X) {
				flag = false;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if (flag) {
			for (int i = 0; i < arr.length - 1; i++) {
				if (arr[i] == X) {
					for (int j = 0; j < arr.length; j++) {
						if (((j == 0) && arr[j] == Y)
								|| (j > 0 && arr[j] == Y && arr[j - 1] != X)) {
							int temp = arr[i + 1];
							arr[i + 1] = arr[j];
							arr[j] = temp;
						}
					}
				}
			}
		}
		return arr;
	}

	public int splitArray(int[] arr){
		try {
			if (arr.length == 0) {
				throw new Exception("Array Empty.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		int pos = -1;
		for (int i = 0; i < arr.length; i++) {		
			int sumLeft = 0;
			for (int k = 0; k <= i; k++) {
				sumLeft = sumLeft + arr[k];
			}
			int sumRight = 0;
			for (int j = i + 1; j < arr.length; j++) {
				sumRight = sumRight + arr[j];
			}
			if (sumLeft == sumRight) {	
				pos = i + 1;
				break;
			}
		}
		return pos;
	}

}
