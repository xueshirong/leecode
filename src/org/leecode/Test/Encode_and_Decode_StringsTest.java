package org.leecode.Test;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.leecode.Encode_and_Decode_Strings;

public class Encode_and_Decode_StringsTest {
	Encode_and_Decode_Strings p = new Encode_and_Decode_Strings();
	@Test
	public void testEncode() {
		fail("Not yet implemented");
	}

	@Test
	public void testDecode() {
		List<String> s = new ArrayList<String>();
		s.add("");
		p.decode(p.encode(s));
	}

}
