package org.leecode.Test;

import org.junit.Test;
import org.leecode.Evaluate_Reverse_Polish_Notation;

public class Evaluate_Reverse_Polish_NotationTest {
	Evaluate_Reverse_Polish_Notation p = new Evaluate_Reverse_Polish_Notation();
	@Test
	public void testEvalRPN() {
		p.evalRPN(new String[]{"2", "1", "+", "3", "*"});
	}

}
