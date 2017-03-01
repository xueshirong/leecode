package org.leecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Word_Search_II {
	//定义一个trie node class
    class TrieNode {
        String c;
        HashMap<Character, TrieNode> subtree;
        boolean isString;
        public TrieNode(){
            subtree = new HashMap<Character, TrieNode>();
            c = "";
            isString = false;
        }
    }
    //定义一个trie 树class，实现insert, find方法
    class TrieTree {
        TrieNode root;
        public TrieTree(){
            root = new TrieNode();
        }
        public void insert(String word){
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if (!cur.subtree.containsKey(c)){
                    cur.subtree.put(c, new TrieNode());
                }
                cur = cur.subtree.get(c);
            }
            cur.c = word;
            cur.isString = true;
        }
        public boolean find(String word){
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if (!cur.subtree.containsKey(c)){
                    return false;
                }
                cur = cur.subtree.get(c);
            }
            return cur.isString;
        }
        public boolean startsWith(String word){
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if (!cur.subtree.containsKey(c)){
                    return false;
                }
                cur = cur.subtree.get(c);
            }
            return true;
        }
    }
    
    //题目要求实现的方法
    //思路：我们可以根据字典中出现的单词构造一棵字典树(Trie)。
    //当从二维矩阵的某一点出发进行深度优先搜索时，搜索路径上的字母构成了单词的前缀，检索字典树，看是否存在该前缀：
    //1.如果不存在该前缀，则回溯并重新搜索(剪枝)；
    //2.如果存在该前缀，则继续搜索，并将搜索路径上出现过的单词进行记录，即为答案。
    TrieTree root;
    List<String> res;
    public List<String> findWords(char[][] board, String[] words) {
        res = new ArrayList<String>();
        root = new TrieTree();
        for (String word : words){
            root.insert(word);
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                searchWord(board, i, j, "", visited);
            }
        }
        return res;
    }
    
    private void searchWord(char[][] board, int i, int j, String s, boolean[][] visited){
    	if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
        if (visited[i][j])  return;
        s += board[i][j];
        if (!root.startsWith(s))    return;
        if (root.find(s)){
            if (!res.contains(s))
                res.add(s);
        }    
        
        // 为了防止循环，将当前字母改变一下
        visited[i][j] = true;
        searchWord(board, i, j + 1, s, visited);
        searchWord(board, i, j - 1, s, visited);
        searchWord(board, i + 1, j, s, visited);
        searchWord(board, i - 1, j, s, visited);
        visited[i][j] = false;
    }
}
