package org.leecode.Test;

import org.junit.Test;
import org.leecode.Partition_Array;

public class Partition_ArrayTest {
	Partition_Array p = new Partition_Array();
	@Test
	public void testPartitionArray() {
		int[] nums = new int[]{3,2,2,1};
		p.partitionArray(nums, 4);
	}

}
