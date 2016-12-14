package org.leecode.Test;

import org.junit.Test;
import org.leecode.Largest_Rectangle_in_Histogram;

public class Largest_Rectangle_in_HistogramTest {
	Largest_Rectangle_in_Histogram p = new Largest_Rectangle_in_Histogram();
	@Test
	public void testLargestRectangleArea() {
		int[] height = new int[]{5,5,1,7,1,1,5,2,7,6};
		p.largestRectangleArea2(height);
	}

}
