package org.leecode;

import java.util.HashMap;
import java.util.Map;

//哈希表法 时间 插入和查询都是O(K) K是词的长度 空间O(NK) N是字典里词的个数
//思路 前缀树的具体讲解请戳这篇博客。这里我们实现树节点时使用了哈希表来映射字母和子节点的关系。
//insert()：对于插入操作，我们遍历字符串同时，根据上一个节点的哈希表来找到下一个节点，直到哈希表中没有相应的字母，我们就新建一个节点。
  //然后从这个新建节点开始，用同样的方法把剩余的字母添加完。记住最后一个字母要添加叶子节点的标记，表明这个词到此已经完整了。
//search()：对于搜索操作，我们也是遍历字符串，然后根据每个节点的哈希表找到路径，最后返回该字符串最后一个字母所在节点。
  //如果中途有找不到路径的情况就直接返回null，如果找到了最后的节点，如果它也是叶子结点的话，就说明找到了。
//startWith()：使用和search()，一样的方法，只是我们返回的节点不用判断是否是叶子节点。只要找到就行。
class TrieNode {
  char c;
  Map<Character, TrieNode> map = new HashMap<Character, TrieNode>();
  boolean isWord = false;
  
  public TrieNode(){
  }
  
  public TrieNode(char c){
      this.c = c;
  }
}

public class Implement_Trie_Prefix_Tree {
	private TrieNode root;
    /** Initialize your data structure here. */
	public Implement_Trie_Prefix_Tree() {
        this.root = new TrieNode();
    }
	
    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] wc = word.toCharArray();
        TrieNode head = root;
        Map<Character, TrieNode> curMap = head.map;
        for (int i = 0; i < wc.length; i++){
            char c = wc[i];
            if (curMap.containsKey(c)){
                head = curMap.get(c);
            }else{
                TrieNode node = new TrieNode(c);
                curMap.put(c, node);
                head = node;
            }
            curMap = head.map;
            if (i == wc.length - 1){
                head.isWord = true;
            }
        }
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = searchNode(word);
        if(node == null)
            return false;
        else if (node.isWord)
            return true;
        else
            return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = searchNode(prefix);
        if(node == null)
            return false;
        else
            return true;
    }
    
    private TrieNode searchNode(String word){
        char[] wc = word.toCharArray();
        Map<Character, TrieNode> map = root.map;
        TrieNode res = null;
        for (int i = 0; i < wc.length; i++){
            char c = wc[i];
            if (map.containsKey(c)){
                res = map.get(c);
                map = res.map;
            }else{
                return null;
            }
        }
        return res;
    }
}
