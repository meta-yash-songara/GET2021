package com.example.intset;

public final class IntSet {
	private int[] set;

	public IntSet(int[] set) {

		this.set = new int[set.length];
		for (int i = 0; i < set.length; i++)
			this.set[i] = set[i];

	}

	public IntSet() {
		// TODO Auto-generated constructor stub
	}

	private int[] getSet() {
		int[] tempSet = new int[set.length];
		for (int i = 0; i < set.length; i++)
			tempSet[i] = set[i];

		return tempSet;
	}

	public int getMemberAt(int index) {
		int[] tempSet = getSet();
		return tempSet[index];
	}

	public boolean isMember(int x) {
		int[] tempSet = getSet();

		for (int i = 0; i < tempSet.length; i++)
			if (tempSet[i] == x)
				return true;

		return false;
	}

	public int size() {
		return getSet().length;
	}

	public boolean isSubSet(IntSet s) {
		IntSet tempSet = new IntSet(getSet());

		for (int i = 0; i < s.size(); i++) {
			if (tempSet.isMember(s.getMemberAt(i))) {
				break;
			} else {
				return false;
			}
		}

		return true;
	}

	public int[] getComplement() {
		int[] complimentSet = new int[1000];

		int setPos = 0;
		int resultSetPos = 0;

		for (int i = 0; i < 1000; i++) {

			if (setPos < getSet().length) {

				if (isMember(i + 1)) {

					++setPos;

				} else {

					complimentSet[resultSetPos] = i + 1;
					++resultSetPos;

				}

			} else {
				complimentSet[resultSetPos] = i + 1;
				++resultSetPos;
			}

		}
		
		// Process for removing zero's
		int[] resultSet = new int[resultSetPos];
		System.arraycopy(complimentSet, 0, resultSet, 0, resultSetPos);

		return resultSet;
	}
	
	public int[] union(IntSet set1, IntSet set2){
		int[] unionSet = new int[set1.getSet().length + set2.getSet().length];
		
		int pos = 0;
		for(int item: set1.getSet()){
			unionSet[pos] = item;
			++pos;
		}
			
		for(int item: set2.getSet()){
			boolean isAlreadyExist = false;
			for(int i = 0; i < unionSet.length; i++){
				if(item == unionSet[i]){
					isAlreadyExist = true;
					break;
				}	
			}
			
			if(!isAlreadyExist){
				unionSet[pos] = item;
				++pos;
			}
		}
		
		// Process for removing zeros
		int[] resultSet = new int[pos];
		System.arraycopy(unionSet, 0, resultSet, 0, pos);
		
		return resultSet;
	}
}
