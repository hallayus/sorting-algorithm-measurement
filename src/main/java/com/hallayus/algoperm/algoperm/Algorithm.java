package com.hallayus.algoperm.algoperm;

import java.util.ArrayList;

public interface Algorithm {
	public <T extends Comparable> int getOperations(Integer[] permutation);
	public String getName();
}
