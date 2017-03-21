package org.leecode.Test;

import org.junit.Test;
import org.leecode.Basic_Calculator;

public class Basic_CalculatorTest {
	Basic_Calculator p = new Basic_Calculator();
	@Test
	public void testCalculate() {
		p.calculate("(1+(4+5+2)-3)+(6+8)");
	}

}
