package org.leecode.Test;

import org.junit.Before;
import org.junit.Test;
import org.leecode.Container_With_Most_Water;

public class Container_With_Most_WaterTest {
	Container_With_Most_Water cwmw = new Container_With_Most_Water();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testMaxArea() {
		int[] height = new int[]{1,1};
		cwmw.maxArea2(height);
	}
}
