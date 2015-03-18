package com.hallayus.algoperm.algoperm;

import org.junit.Assert;
import org.junit.Test;

import com.hallayus.algoperm.algoperm.algorithms.InsertionSort;

import junit.framework.TestCase;

public class InsertionSortTest extends TestCase {
	
	@Test
	public void test1()
	{
		Integer[] testcase = {1,4,3,2,5};
		
		InsertionSort sort = new InsertionSort();
		int ops = sort.getOperations(testcase);
		
		Assert.assertEquals(7,ops);

	}
	
	@Test
	public void test2()
	{
		
	}
}
