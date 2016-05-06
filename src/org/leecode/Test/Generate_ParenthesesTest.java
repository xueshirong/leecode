package org.leecode.Test;

import org.junit.Before;
import org.junit.Test;
import org.leecode.Generate_Parentheses;

public class Generate_ParenthesesTest {
	Generate_Parentheses p = new Generate_Parentheses();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGenerateParenthesis() {
		p.generateParenthesis(3);
	}

}
