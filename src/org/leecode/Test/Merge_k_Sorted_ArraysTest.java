package org.leecode.Test;

import org.junit.Test;
import org.leecode.Merge_k_Sorted_Arrays;

public class Merge_k_Sorted_ArraysTest {
	Merge_k_Sorted_Arrays p = new Merge_k_Sorted_Arrays();
	@Test
	public void testMergeKSortedArrays() {
		int[][] arrays = new int[][]{
			{1,3,6,8},
			{2,5,6},
			{3,5,7,9}
		};
		int[] res = p.mergeKSortedArrays(arrays);
		for (int i : res)
			System.out.print(i + " ");
	}

}
