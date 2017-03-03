package org.leecode.Test;

import java.util.List;

import org.junit.Test;
import org.leecode.Design_Twitter;

public class Design_TwitterTest {

	@Test
	public void testDesign_Twitter() {
		Design_Twitter twitter = new Design_Twitter();
		twitter.postTweet(1, 1);		
		List<Integer> list = twitter.getNewsFeed(1);
		System.out.println(list);
		twitter.follow(2, 1);
		list = twitter.getNewsFeed(2);
		System.out.println(list);
		twitter.postTweet(2, 1);
		list = twitter.getNewsFeed(2);
		System.out.println(list);
	}

}
