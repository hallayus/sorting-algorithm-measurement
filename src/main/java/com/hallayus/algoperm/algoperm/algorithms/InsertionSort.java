package com.hallayus.algoperm.algoperm.algorithms;

import com.hallayus.algoperm.algoperm.Algorithm;

public class InsertionSort implements Algorithm{
	
	public int getOperations(Integer[] l) {
		int count = 0;
		for(int i = 1; i < l.length; i++)
		{
			Integer obj = l[i];
			int j = i;
			count++;
			while(j > 0 && obj < l[j - 1])
			{
				l[j] = l[j - 1];
				j--;
				//count operations
				count++;
			}
			l[j] = obj;
		}
		//System.out.println(Arrays.toString(l));
		//count operations
		return count;
	}

	public String getName() {
		return "Insertion Sort";
	}
	
	
}
