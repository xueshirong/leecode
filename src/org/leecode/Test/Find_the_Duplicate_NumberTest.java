package org.leecode.Test;

import org.junit.Test;
import org.leecode.Find_the_Duplicate_Number;

public class Find_the_Duplicate_NumberTest {
	Find_the_Duplicate_Number p = new Find_the_Duplicate_Number();
	@Test
	public void testFindDuplicate() {
		p.findDuplicate1(new int[]{1,2,3,4,5,6,7,8,6,9});
	}

}
