package org.leecode.Test;

import org.junit.Test;
import org.leecode.Longest_Increasing_Subsequence;

public class Longest_Increasing_SubsequenceTest {
	Longest_Increasing_Subsequence p = new Longest_Increasing_Subsequence();
	@Test
	public void testLengthOfLIS() {
		int[] nums = new int[]{9,3,6,2,7};
		//p.lengthOfLIS(nums);
		p.longestIncreasingSubsequence(nums);
	}

}
