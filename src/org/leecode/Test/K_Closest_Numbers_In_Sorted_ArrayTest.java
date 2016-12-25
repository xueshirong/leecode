package org.leecode.Test;

import org.junit.Test;
import org.leecode.K_Closest_Numbers_In_Sorted_Array;

public class K_Closest_Numbers_In_Sorted_ArrayTest {
	K_Closest_Numbers_In_Sorted_Array p = new K_Closest_Numbers_In_Sorted_Array();
	@Test
	public void testKClosestNumbers() {
		p.kClosestNumbers(new int[]{1,4,6,10,20}, 21, 4);
	}

}
