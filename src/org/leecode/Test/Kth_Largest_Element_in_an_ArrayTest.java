package org.leecode.Test;

import org.junit.Test;
import org.leecode.Kth_Largest_Element_in_an_Array;

public class Kth_Largest_Element_in_an_ArrayTest {
	Kth_Largest_Element_in_an_Array p = new Kth_Largest_Element_in_an_Array();
	@Test
	public void testFindKthLargest2() {
		
		int a = Integer.MAX_VALUE;
		System.out.println(a);
		System.out.println(a + 1);
		if (a + 1 == Integer.MIN_VALUE)
			System.out.println("true");
		else
			System.out.println("false");
		System.out.println(a + 2);
		System.out.println(a + 3);
		System.out.println(a -1 + a - 1);
		
		int[] nums = new int[]{3,2,1,5,6,4};
		p.findKthLargest2(nums, 2);
	}

}
