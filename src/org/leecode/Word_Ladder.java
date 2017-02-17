package org.leecode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Word_Ladder {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
	    wordList.add(endWord);
        Queue<String> queue = new LinkedList<String>();
        queue.add(beginWord);
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String cur = queue.remove();
                if(cur.equals(endWord)){ return level + 1;}
                for(int j = 0; j < cur.length(); j++){
                    char[] word = cur.toCharArray();
                    for(char ch = 'a'; ch < 'z'; ch++){
                        word[j] = ch;
                        String check = new String(word);
                        if(!check.equals(cur) && wordList.contains(check)){
                            queue.add(check);
                            wordList.remove(check);
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
	//.....................
	public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        //corner case
        if (wordList == null || wordList.size() == 0)
            return 0;
        Queue<String> q = new LinkedList<String>();
        Set<String> set = new HashSet<String>();//record all visited word
        set.add(beginWord);
        q.offer(beginWord);
        int level = 1;
        while (!q.isEmpty()){
            level++;
            int size = q.size();//key point: the size of queue will be change, so get it beforehand
            for (int i = 0; i < size; i++){
                String word = q.poll();
                List<String> nextWords = getNextWords(word, wordList);
                for (String next : nextWords){
                    if (set.contains(next))//key point
                        continue;
                    if (next.equals(endWord)){
                        return level;
                    }
                    q.offer(next);
                    set.add(next);
                }
            }
        }
        return 0;
    }
    //get next words list
    private List<String> getNextWords(String word, List<String> wordList){
        List<String> res = new ArrayList<String>();
        for (char c = 'a'; c < 'z'; c++){
            for (int i = 0; i < word.length(); i++){
                if (c == word.charAt(i))
                    continue;
                String next = replace(word, i, c);
                if (wordList.contains(next))
                    res.add(next);
            }
        }
        return res;   
    }
  //replace the index char with c
    private String replace(String word, int index, char c){
        char[] res = word.toCharArray();
        res[index] = c;
        return String.valueOf(res);
    }
}
