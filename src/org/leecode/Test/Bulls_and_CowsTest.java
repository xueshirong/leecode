package org.leecode.Test;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.leecode.Bulls_and_Cows;

public class Bulls_and_CowsTest {
	Bulls_and_Cows bc = new Bulls_and_Cows();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetHint() {
		String secret = "1234";
		String guess = "0111";
		bc.getHint(secret, guess);
		
	}

}
