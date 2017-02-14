package org.leecode;

public class Shortest_Word_Distance {
	//Given a list of words and two words word1 and word2, 
	//return the shortest distance between these two words in the list.
	//For example:
	//Assume that words = [“practice”, “makes”, “perfect”, “coding”, “makes”].
	//Given word1 = “coding”, word2 = “practice”, return 3.
	//Given word1 = “makes”, word2 = “coding”, return 1.
	//Note: You may assume that word1 does not equal to word2, and word1 and word2 are both in the list
	
	//思路: 需要注意的是可能两个单词都会在字典里出现很多次
	//1. two pointer: idx1, idx2分别用来记录两个word各自的位置
	//2.遍历给定的words数组，如果遍历到的word[i]等于word1的话， 获取idx1的位置，
	//如果idx2不为-1的情况下，取distance = |idx2-idx1|; 
	//因为要找一个最小的distance，所以再做个比较； 同理，遍历到的word[i]等于word
	public int shortestDistance(String[] words, String word1, String word2) {
        if (word1 == word2 || words == null || words.length == 0) return 0;
        int idx1 = -1, idx2 = -1;
        int minDistance = words.length;
        for(int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                idx1 = i;
                if (idx2 != -1) minDistance = Math.min(minDistance, Math.abs(idx1 - idx2));
            } else if (words[i].equals(word2)) {
                idx2 = i;
                if (idx1 != -1) minDistance = Math.min(minDistance, Math.abs(idx1 - idx2));
            }
        }
        return minDistance;
 
    }
}
