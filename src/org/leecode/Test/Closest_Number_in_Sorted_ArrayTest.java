package org.leecode.Test;

import org.junit.Test;
import org.leecode.Closest_Number_in_Sorted_Array;

public class Closest_Number_in_Sorted_ArrayTest {
	Closest_Number_in_Sorted_Array p = new Closest_Number_in_Sorted_Array();
	@Test
	public void testClosestNumber() {
		int[] A = new int[]{1,4,6,10,20};
		p.closestNumber(A, 21);
	}

}
