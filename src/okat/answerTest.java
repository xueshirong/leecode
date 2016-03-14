package okat;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class answerTest {
	answer an = new answer();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testIsValidSocket() {
		an.isValidSocket("123.1.3.1:78");
	}

}
