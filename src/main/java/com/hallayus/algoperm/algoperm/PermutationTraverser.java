package com.hallayus.algoperm.algoperm;

import java.util.Arrays;
import java.util.HashMap;

public class PermutationTraverser {
	
	private Integer[] permutation;
	private final int size;
	
	private HashMap<Integer,Integer> frequencies;
	
	public PermutationTraverser(int s)
	{
		this.size = s;
		permutation = new Integer[s];
	}
	
	public HashMap<Integer,Integer> getOperationCount(Algorithm a){
		frequencies = new HashMap<Integer,Integer>();
		
		Integer[] l = new Integer[size];
		
		for(int i = 0; i < size; i++)
		{
			l[i] = i;
		}
		
		permute(l,1,a);
		
		//System.out.println("test");
		
		return frequencies;
	}
	
	
	
	private void permute(Integer[] list, int permSize, Algorithm a)
	{
		
		int k = size - permSize;
		for(int i = 0; i <= k; i++)
		{
			swap(list,i,k);
			permutation[permSize - 1] = list[k];
			permute(list,permSize + 1,a);
			swap(list,i,k);
		}
		
		if(permSize == size)
		{
			
			int ops = a.getOperations(permutation);
			//System.out.println(Arrays.toString(permutation) + ": " + ops);
			
			if(frequencies.get(ops) == null)
			{
				frequencies.put(ops, 1);
			}
			else
			{
				int val = frequencies.get(ops);
				frequencies.remove(ops);
				frequencies.put(ops, val + 1);
				
			}
		}
	}
	
	private Integer[] swap(Integer[] a,int i, int j)
	{
		Integer tmp = a[i]; 
		a[i] = a[j];
		a[j] = tmp;
		return a;
	}
}
