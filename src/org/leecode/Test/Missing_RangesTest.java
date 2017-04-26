package org.leecode.Test;

import org.junit.Test;
import org.leecode.Missing_Ranges;

public class Missing_RangesTest {
	Missing_Ranges p = new Missing_Ranges();
	@Test
	public void testFindMissingRanges() {
		p.findMissingRanges(new int[]{-2147483648,-2147483648,0,2147483647,2147483647}, -2147483648, 2147483647);
	}

}
