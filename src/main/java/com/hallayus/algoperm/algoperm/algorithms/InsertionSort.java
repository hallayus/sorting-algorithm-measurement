package com.hallayus.algoperm.algoperm.algorithms;

import java.util.Arrays;

import com.hallayus.algoperm.algoperm.Algorithm;

public class InsertionSort implements Algorithm{
	
	public <T extends Comparable> int getOperations(Integer[] l) {
		int count = 0;
		
		for(int i = 1; i < l.length; i++)
		{
			Integer obj = l[i];
			int j = i;
			while(j > 0 && obj < l[j - 1])
			{
				l[j] = l[j - 1];
				j--;
				//count operations
				count++;
			}
			l[j] = obj;
			count++;
		}
		System.out.println(Arrays.toString(l));
		//count operations
		return count;
	}

	public String getName() {
		return "Insertion Sort";
	}
	
	
}
