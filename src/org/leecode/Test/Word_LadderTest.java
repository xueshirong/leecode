package org.leecode.Test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.leecode.Word_Ladder;

public class Word_LadderTest {
	Word_Ladder p  = new Word_Ladder();
	@Test
	public void testLadderLength() {
		String beginWord = "hit";
		String endWord = "cog";
		List<String> wordList = new ArrayList<String>();
		wordList.add("hot");//"hot","dot","dog","lot","log","cog"
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		//wordList.add("cog");
		
		p.ladderLength(beginWord, endWord, wordList);
	}

}
