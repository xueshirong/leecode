package org.leecode.Test;

import org.junit.Test;
import org.leecode.Median_of_two_Sorted_Arrays;

public class Median_of_two_Sorted_ArraysTest {
	Median_of_two_Sorted_Arrays p = new Median_of_two_Sorted_Arrays();
	@Test
	public void testFindMedianSortedArrays() {
		int[] a = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22};
		int[] b = new int[]{0,6};
		p.findMedianSortedArrays(a, b);
	}

}
