package org.leecode.Test;

import org.junit.Before;
import org.junit.Test;
import org.leecode.Product_of_Array_Except_Self;

public class Product_of_Array_Except_SelfTest {
	Product_of_Array_Except_Self pae = new Product_of_Array_Except_Self();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testProductExceptSelf() {
		int[] nums = new int[]{0,0};
		pae.productExceptSelf(nums);
	}

}
