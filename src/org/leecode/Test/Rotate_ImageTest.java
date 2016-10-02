package org.leecode.Test;

import org.junit.Test;
import org.leecode.Rotate_Image;

public class Rotate_ImageTest {
	Rotate_Image p = new Rotate_Image();
	@Test
	public void testRotate() {
		p.rotate(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
	}

}
