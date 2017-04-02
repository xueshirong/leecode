package org.leecode;

public class Single_Number_II {
	//可以为每个位上1的数目计数。然后将该计数%3，剩下的1肯定是单独的数字贡献的。
	public int singleNumber(int[] nums) {
		int result = 0;
		int len = nums.length;
		for (int i = 0; i < 32; i++) {
			int count = 0;
			for (int j = 0; j < len; j++) {
				count += (nums[j] >> i) & 1;
			}
			result += (count % 3) << i;
		}

		return result;
	}
}
